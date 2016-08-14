package com.example.rockey.myapplicationzuile.Secondinterface.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeTopCityListEntity;
import com.example.rockey.myapplicationzuile.R;
import com.example.rockey.myapplicationzuile.Secondinterface.GridEntity;

import java.util.ArrayList;
import java.util.List;


public class RelealPopwindowCitylistItemAdapter extends BaseAdapter {

    private List< GridEntity.ListBean.ChildCategoryListBean> objects = new ArrayList< GridEntity.ListBean.ChildCategoryListBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public RelealPopwindowCitylistItemAdapter(Context context, List< GridEntity.ListBean.ChildCategoryListBean> objects ) {
        this.objects=objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public GridEntity.ListBean.ChildCategoryListBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.selease_popwindow_list_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((GridEntity.ListBean.ChildCategoryListBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(GridEntity.ListBean.ChildCategoryListBean object, ViewHolder holder) {
        holder.tvHomePopwCity.setText(object.getChild_category_name());
    }

    protected class ViewHolder {
        private TextView tvHomePopwCity;

        public ViewHolder(View view) {
            tvHomePopwCity = (TextView) view.findViewById(R.id.tv_selease_popw_entity);
        }
    }
}
