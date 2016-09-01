package ua.com.avatlantik.dubyk.i.dashboardclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.com.avatlantik.dubyk.i.dashboardclient.R;
import ua.com.avatlantik.dubyk.i.dashboardclient.adapter.BusinessDirectionAdapter;

/**
 * Created by i.dubyk on 30.08.2016.
 */
public class BusinessDirectionFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_businnes_direction_list;
    private View view;
    private Button buttonGenerate;
    private ListView listView;
    private TextView textView;
    private List<String> list;

    public static SettingsFragment getInstance() {

        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        initData();

        initElementsForm();

        if (list.size()==0){
            textView.setText(getString(R.string.error_no_data));
            buttonGenerate.setVisibility(View.GONE);
            return view;
        }

        textView.setText(getString(R.string.businnes_direction_select));
        buttonGenerate.setVisibility(View.VISIBLE);

        initDataToForm();

        return view;
    }

    private void initData() {

//        list =  new ArrayList<String>();
//        DBHelper dbHelper = new DBHelper(getActivity());
//
//        Cursor res = dbHelper.getDataWithSelection(ConstantsGlobal.TABLE_COLUMN_BN_NAME,
//                ""+ConstantsGlobal.TABLE_COLUMN_TYPE_DATA+""+ConstantsGlobal.TYPE_DATA_BN_DATA);
//
//        while(res.isAfterLast() == false){
//            list.add(res.getString(res.getColumnIndex(ConstantsGlobal.TABLE_COLUMN_BN_NAME)));
//            res.moveToNext();
//        }
        list = getList();

    }

    private void initDataToForm() {

        BusinessDirectionAdapter adapter = new BusinessDirectionAdapter(getActivity(), list);
        listView.setAdapter(adapter);

    }

    private void initElementsForm() {

        listView = (ListView) view.findViewById(R.id.busn_dir_listView);

        buttonGenerate = (Button) view.findViewById(R.id.busn_dir_button);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView = (TextView)view.findViewById(R.id.busn_dir_textView);

    }

    private List<String> getList(){
        List<String> list = new ArrayList<String>();
        list.add("Свині");
        list.add("ВРХ");
        list.add("Птиця");
        list.add("Кормові добавки");
        list.add("Оборудование");
        list.add("ПСП");
        list.add("МОЛОКО");
        list.add("Сировина");
        list.add("Услуги");
        list.add("Прочее");
        list.add("Ритейл");
        list.add("Корма");
        return list;
    }
}
