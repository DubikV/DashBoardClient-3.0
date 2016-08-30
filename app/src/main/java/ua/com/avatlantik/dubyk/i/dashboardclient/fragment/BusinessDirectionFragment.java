package ua.com.avatlantik.dubyk.i.dashboardclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ua.com.avatlantik.dubyk.i.dashboardclient.R;
import ua.com.avatlantik.dubyk.i.dashboardclient.adapter.BusinessDirectionAdapter;
import ua.com.avatlantik.dubyk.i.dashboardclient.dto.Data.BusinessDirectionDTO;

/**
 * Created by i.dubyk on 30.08.2016.
 */
public class BusinessDirectionFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_businnes_direction_list;
    private View view;
    private Button buttonGenerate;
    private ListView listView;

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

        initElementsForm();

        return view;
    }

    private void initElementsForm() {

        listView = (ListView) view.findViewById(R.id.busn_dir_listView);

        BusinessDirectionAdapter adapter = new BusinessDirectionAdapter(getActivity(), getList());
        listView.setAdapter(adapter);
        buttonGenerate = (Button) view.findViewById(R.id.busn_dir_button);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private List<BusinessDirectionDTO> getList(){
        List<BusinessDirectionDTO> list = new ArrayList<BusinessDirectionDTO>();
        list.add(new BusinessDirectionDTO("Свині", "гуид"));
        list.add(new BusinessDirectionDTO("ВРХ", "гуид"));
        list.add(new BusinessDirectionDTO("Птиця", "гуид"));
        list.add(new BusinessDirectionDTO("Кормові добавки", "гуид"));
        return list;
    }
}
