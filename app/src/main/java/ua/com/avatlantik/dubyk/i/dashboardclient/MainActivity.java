package ua.com.avatlantik.dubyk.i.dashboardclient;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ua.com.avatlantik.dubyk.i.dashboardclient.fragment.BusinessDirectionFragment;
import ua.com.avatlantik.dubyk.i.dashboardclient.fragment.InfoFragment;
import ua.com.avatlantik.dubyk.i.dashboardclient.fragment.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        initToolbar();

        setToolbarText(getString(R.string.app_name));
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerView, new BusinessDirectionFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_settings) {
            setToolbarText(getString(R.string.action_settings_ua));
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new SettingsFragment()).commit();
            return true;
        }

        if (id==R.id.nav_info) {
            setToolbarText(getString(R.string.nav_info_ua));
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerView, new InfoFragment()).commit();
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
        toolbar.setTitle(getString(R.string.app_name));
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

    @Override
    public void onBackPressed(){

        if (mFragmentManager.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            mFragmentManager.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }
}
