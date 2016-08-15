package com.example.rockey.myapplicationzuile.Firstinterface.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeListEntity;
import com.example.rockey.myapplicationzuile.R;
import com.example.rockey.myapplicationzuile.entity.CollectEntity;

import org.xutils.image.ImageOptions;

import java.util.List;

/**
 * Created by LJ on 2016/8/15.
 */
public class CollectAdapter extends BaseAdapter {

    private List<CollectEntity> objects;

    private Context context;
    private LayoutInflater layoutInflater;
    private ImageOptions options;

    public CollectAdapter(Context context, List<CollectEntity> objects) {
        this.context = context;
        this.objects = objects;
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
    public CollectEntity getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.mycollect_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((CollectEntity) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(CollectEntity object, ViewHolder holder) {
        //   x.image().bind(holder.ivStoreImg, object.getImgUrlList().get(0), options);
        //  holder.imgTime.setImageResource(R.drawable.img_release_item_time);



        holder.imgUrlList.setImageResource(R.drawable.list_phone);
        holder.merchant_name.setText(object.getMerchant_name());
        holder.per_capita_consumption.setText(object.getPer_capita_consumption());
        holder.business_location.setText(object.getBusiness_location());
        holder.opening_time.setText(object.getOpening_time());
        holder.closing_time.setText(object.getClosing_time());

    }

    protected class ViewHolder {
        private ImageView imgUrlList;
        private TextView merchant_name;
        private TextView per_capita_consumption;
        private TextView business_location;
        private TextView opening_time;
        private TextView closing_time;


        public ViewHolder(View view) {
            imgUrlList = (ImageView) view.findViewById(R.id.collect_img);
            merchant_name = (TextView) view.findViewById(R.id.collect_name);
            per_capita_consumption = (TextView) view.findViewById(R.id.collect_sp);
            business_location = (TextView) view.findViewById(R.id.collect_address);
            opening_time = (TextView) view.findViewById(R.id.collect_opentime);
            closing_time = (TextView) view.findViewById(R.id.collect_clostime);

        }
    }
}
