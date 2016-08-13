package com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey.Adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rockey.myapplicationzuile.R;
import com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey.Entity.Ownmodel;

public class MineListItemAdapter extends BaseAdapter {

    private List<Ownmodel> objects = new ArrayList<Ownmodel>();

    private Context context;
    private LayoutInflater layoutInflater;

    public MineListItemAdapter(Context context, List<Ownmodel> objects ) {
        this.objects=objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Ownmodel getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.mine_list_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((Ownmodel)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(Ownmodel object, ViewHolder holder) {
        holder.tvMineItemName.setText(object.getName());
        holder.imMinePath.setImageResource(object.getImgpath());
    }

    protected class ViewHolder {
        private ImageView imMinePath;
    private TextView tvMineItemName;

        public ViewHolder(View view) {
            imMinePath = (ImageView) view.findViewById(R.id.im_mine_path);
            tvMineItemName = (TextView) view.findViewById(R.id.tv_mine_item_name);
        }
    }
}
