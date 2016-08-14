package com.example.rockey.myapplicationzuile.Secondinterface.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.rockey.myapplicationzuile.R;
import com.example.rockey.myapplicationzuile.Secondinterface.GridEntity;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rockey on 2016/8/14.
 */
public class ReleaseItemAdapter extends BaseAdapter {
    private ImageOptions options;
    private List<GridEntity.ListBean> objects = new ArrayList<GridEntity.ListBean>();

    private Context context;
    private LayoutInflater layoutInflater;

    public ReleaseItemAdapter(Context context, List<GridEntity.ListBean> objects) {
        this.objects=objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        options = new ImageOptions.Builder().setLoadingDrawableId(R.drawable.defualt) //设置加载过程中的图片
                .setFailureDrawableId(R.drawable.defualt) //设置加载失败后的图片
                .setUseMemCache(true) //设置使用缓存
                // .setCircular(true) //设置显示圆形图片
                .setIgnoreGif(true) //设置支持gif
                .build();

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public GridEntity.ListBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(com.example.releasefragment.R.layout.release_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((GridEntity.ListBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(GridEntity.ListBean object, ViewHolder holder) {
//   x.image().bind(holder.ivStoreImg, object.getImgUrlList().get(0), options);
        x.image().bind(holder.gridIvIcon,object.getParent_cate_img_url(),options);
        holder.gridTvIconName.setText(object.getParent_cate_name());
    }

    protected class ViewHolder {
        private ImageView gridIvIcon;
        private TextView gridTvIconName;

        public ViewHolder(View view) {
            gridIvIcon = (ImageView) view.findViewById(com.example.releasefragment.R.id.Grid_iv_icon);
            gridTvIconName = (TextView) view.findViewById(com.example.releasefragment.R.id.Grid__tv_iconName);
        }
    }
}
