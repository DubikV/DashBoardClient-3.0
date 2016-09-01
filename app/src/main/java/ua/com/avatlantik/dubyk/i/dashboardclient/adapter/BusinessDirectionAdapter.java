package ua.com.avatlantik.dubyk.i.dashboardclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.SectionIndexer;

import java.util.List;

import ua.com.avatlantik.dubyk.i.dashboardclient.R;

/**
 * Created by i.dubyk on 30.08.2016.
 */
public class BusinessDirectionAdapter extends BaseAdapter implements SectionIndexer{

    private List<String > list;
    private LayoutInflater layoutInflater;

    public BusinessDirectionAdapter(Context context, List<String> list) {
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
        CheckBox checkBox = (CheckBox)view.findViewById(R.id.busn_dir_checkBox);
        checkBox.setText((String)getItem(position));

        return view;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
