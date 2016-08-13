package com.example.rockey.myapplicationzuile.Firstinterface.Adapter;

/**
 * Created by Administrator on 2016/8/12.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeListEntity;
import com.example.rockey.myapplicationzuile.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

public class HomeListItemAdapter extends BaseAdapter {

    private List<HomeListEntity.ListBean> objects;

    private Context context;
    private LayoutInflater layoutInflater;
    private ImageOptions options;

    public HomeListItemAdapter(Context context, List<HomeListEntity.ListBean> objects) {
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
    public HomeListEntity.ListBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.home_list_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((HomeListEntity.ListBean) getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(HomeListEntity.ListBean object, ViewHolder holder) {
     //   x.image().bind(holder.ivStoreImg, object.getImgUrlList().get(0), options);
      //  holder.imgTime.setImageResource(R.drawable.img_release_item_time);



      //  holder.ivDianhua.setImageResource(R.drawable.list_phone);
        holder.tvStoreName.setText(object.getMerchant_name());
   //   holder.tvMoney.setText(object.get);
        holder.tvAddress.setText(object.getBusiness_location());
       // holder.tvType.setText(object.getChild_category_id());
        if (object.getOpening_time()!=null){
            holder.tvWorkTime.setText(object.getOpening_time()+"-"+object.getClosing_time());
        }else {
            holder.tvWorkTime.setVisibility(View.INVISIBLE);

        }

    }

    protected class ViewHolder {
        private ImageView ivStoreImg;
        private TextView tvStoreName;
        private TextView tvMoney;
        private TextView tvWorkTime;
        private ImageView imgTime;
        private TextView tvType;
        private TextView tvAddress;
        private ImageView ivDianhua;

        public ViewHolder(View view) {
            ivStoreImg = (ImageView) view.findViewById(R.id.iv_storeImg);
            tvStoreName = (TextView) view.findViewById(R.id.tv_storeName);
            tvMoney = (TextView) view.findViewById(R.id.tv_money);
            tvWorkTime = (TextView) view.findViewById(R.id.tv_workTime);
            imgTime = (ImageView) view.findViewById(R.id.img_time);
            tvType = (TextView) view.findViewById(R.id.tv_type);
            tvAddress = (TextView) view.findViewById(R.id.tv_address);
            ivDianhua = (ImageView) view.findViewById(R.id.iv_dianhua);
        }
    }
}

