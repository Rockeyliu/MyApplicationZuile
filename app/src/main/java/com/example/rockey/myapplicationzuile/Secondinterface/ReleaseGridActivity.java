package com.example.rockey.myapplicationzuile.Secondinterface;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rockey.myapplicationzuile.R;


public class ReleaseGridActivity extends AppCompatActivity {

    GridView gridview;
    BaseAdapter adapter ;

    int[] icons = {R.drawable.meishi, R.drawable.yule, R.drawable.fangchan,
            R.drawable.che, R.drawable.hunqing, R.drawable.zhuangxiu,
          R.drawable.jiaoyu, R.drawable.gongzuo,R.drawable.baihuode,
            R.drawable.tiaozhao, R.drawable.shangwu, R.drawable.bianmin,
           R.drawable.laoxianghui, R.drawable.qita };
    String[] name = {"美食","娱乐","房产","车","婚庆","装修","教育",
            "工作","百货","跳蚤","商务","便民","老乡会","其他"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_grid);
        intadapter();
        inview();
    }


    private void inview() {
        // 二、找到网格控件
        gridview = (GridView) findViewById(R.id.gv_release);
        gridview.setAdapter(adapter);
        // 设置点击事件
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ImageView showImg = (ImageView)findViewById(R.id.iv_icon);
                showImg.setImageResource(icons[position]);
            }
        });

    }

    public void intadapter() {
        // 三、设置适配器
        adapter = new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // 新建一个布局，设置到convertView中（布局中包括一个图片）
                convertView = LayoutInflater.from(ReleaseGridActivity.this)
                        .inflate(R.layout.release_item, null);
                // 设置布局里图片和文本的内容
                ImageView img = (ImageView) convertView.findViewById(R.id.iv_icon);
                ((ImageView) convertView.findViewById(R.id.iv_icon)).setImageResource(icons[position]);
                TextView tv = (TextView) convertView.findViewById(R.id.tv_iconName);
                ((TextView) convertView.findViewById(R.id.tv_iconName)).setText(name[position]);
                return convertView;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public Object getItem(int position) {
                return icons[position];
            }

            @Override
            public int getCount() {
                return icons.length;
            }
        };

    }

}
