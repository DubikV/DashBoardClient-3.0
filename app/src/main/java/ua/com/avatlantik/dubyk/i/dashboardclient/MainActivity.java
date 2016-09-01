package ua.com.avatlantik.dubyk.i.dashboardclient;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ua.com.avatlantik.dubyk.i.dashboardclient.Constants.ConstantsGlobal;
import ua.com.avatlantik.dubyk.i.dashboardclient.Modules.Module_GetURL;
import ua.com.avatlantik.dubyk.i.dashboardclient.Modules.Module_ReadWrite_Data;
import ua.com.avatlantik.dubyk.i.dashboardclient.Settings.SettingConnect;
import ua.com.avatlantik.dubyk.i.dashboardclient.fragment.BusinessDirectionFragment;
import ua.com.avatlantik.dubyk.i.dashboardclient.fragment.InfoFragment;
import ua.com.avatlantik.dubyk.i.dashboardclient.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;
    private Toolbar toolbar;
    private Module_GetURL module_getURL;
    private Module_ReadWrite_Data module_readWrite_data;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initToolbar();

        module_readWrite_data.readDataFromMemory();

        downloadData();

    }

    private void initData() {
        mFragmentManager = getSupportFragmentManager();
        module_readWrite_data = new Module_ReadWrite_Data(this);
        module_getURL = new Module_GetURL(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.nav_loadData) {
            downloadData();
            return true;
        }

        if (id == R.id.nav_settings) {
            setToolbarText(getString(R.string.action_settings_ua));
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new SettingsFragment());
            fragmentTransaction.addToBackStack(this.getClass().getName());
            fragmentTransaction.commit();
            return true;
        }

        if (id==R.id.nav_info) {
            setToolbarText(getString(R.string.nav_info_ua));
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new InfoFragment());
            fragmentTransaction.addToBackStack(this.getClass().getName());
            fragmentTransaction.commit();
            return true;
        }

        if (id == R.id.nav_exit) {
            SetOnExitApp();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setToolbarText(getString(R.string.app_name));
    }

    public void setToolbarText(String text){

        toolbar.setTitle(text);

    }

    public void setToastToActivity(String textToast){

        Toast.makeText(getApplicationContext(), textToast, Toast.LENGTH_LONG).show();

    }

    private void SetOnExitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.title_Exit));
        builder.setMessage(getString(R.string.questions_Exit));

        builder.setPositiveButton(getString(R.string.questions_Exit_answer_yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                System.exit(0);

            }
        });

        builder.setNegativeButton(getString(R.string.questions_Exit_answer_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void downloadData(){


        String textURL = "";
        if (SettingConnect.getInstance().isAvtoDownload()){
            textURL = "getDataDTO?type="+ ConstantsGlobal.TYPE_DATA_BN_DATA;
        }else{
            textURL = "getDataDTO";
        }

        if(module_getURL.getCheckConnektion()) {

            String url = module_getURL.getGetURL(textURL);
            if(url.isEmpty() || url==null){
                setToolbarText(getString(R.string.action_settings_ua));
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.containerView, new SettingsFragment());
                fragmentTransaction.addToBackStack(this.getClass().getName());
                fragmentTransaction.commit();
                return;
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setMainActivity(this);
            downloadData.setOpenStart(true);
            downloadData.execute(url);

        }

        setToolbarText(getString(R.string.app_name));
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new BusinessDirectionFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed(){

        if (mFragmentManager.getBackStackEntryCount() > 0) {
             mFragmentManager.popBackStack();
        } else {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;

        Toast.makeText(this, R.string.double_back_pressed_text, Toast.LENGTH_SHORT).show();

        }
    }
}
