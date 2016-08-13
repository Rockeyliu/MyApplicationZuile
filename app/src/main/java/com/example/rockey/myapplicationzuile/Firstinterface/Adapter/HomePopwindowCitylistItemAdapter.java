package com.example.rockey.myapplicationzuile.Firstinterface.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeTopCityListEntity;
import com.example.rockey.myapplicationzuile.R;


public class HomePopwindowCitylistItemAdapter extends BaseAdapter {

    private List< HomeTopCityListEntity.ListBean> objects = new ArrayList< HomeTopCityListEntity.ListBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public HomePopwindowCitylistItemAdapter(Context context,List< HomeTopCityListEntity.ListBean> objects ) {
        this.objects=objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public  HomeTopCityListEntity.ListBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.home_popwindow_citylist_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((HomeTopCityListEntity.ListBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(HomeTopCityListEntity.ListBean object, ViewHolder holder) {
        holder.tvHomePopwCity.setText(object.getCity_name());
    }

    protected class ViewHolder {
        private TextView tvHomePopwCity;

        public ViewHolder(View view) {
            tvHomePopwCity = (TextView) view.findViewById(R.id.tv_home_popw_city);
        }
    }
}
