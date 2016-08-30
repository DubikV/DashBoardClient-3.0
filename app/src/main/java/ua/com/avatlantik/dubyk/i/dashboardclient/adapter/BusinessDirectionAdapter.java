package ua.com.avatlantik.dubyk.i.dashboardclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.List;

import ua.com.avatlantik.dubyk.i.dashboardclient.R;
import ua.com.avatlantik.dubyk.i.dashboardclient.dto.Data.BusinessDirectionDTO;

/**
 * Created by i.dubyk on 30.08.2016.
 */
public class BusinessDirectionAdapter extends BaseAdapter{

    private List<BusinessDirectionDTO> list;
    private LayoutInflater layoutInflater;

    public BusinessDirectionAdapter(Context context, List<BusinessDirectionDTO> list) {
        this.list = list;
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if(view==null){
            view = layoutInflater.inflate(R.layout.fragment_businnes_direction, parent, false);
        }
        BusinessDirectionDTO busnessDirection = getBusnessDirection(position);

        CheckBox checkBox = (CheckBox)view.findViewById(R.id.busn_dir_checkBox);
        checkBox.setText(busnessDirection.getName());

        return view;
    }

    private BusinessDirectionDTO getBusnessDirection(int position){
        return (BusinessDirectionDTO) getItem(position);
    }
}
