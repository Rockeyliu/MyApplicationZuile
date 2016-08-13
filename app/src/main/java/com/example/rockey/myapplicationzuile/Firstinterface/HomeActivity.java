package com.example.rockey.myapplicationzuile.Firstinterface;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Firstinterface.Adapter.HomeListItemAdapter;
import com.example.rockey.myapplicationzuile.Firstinterface.Adapter.HomePopwindowCitylistItemAdapter;
import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeListEntity;
import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeTopCityListEntity;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import org.xutils.common.Callback;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    ListView listView;
    HomeListEntity homeListEntity;
    List<HomeListEntity.ListBean> data;
    List<HomeTopCityListEntity.ListBean > citylistdates;
    HomeListItemAdapter listAdapter;
    @ViewInject(value = R.id.imgbtn_message)
    private ImageButton imgbtnmessage;
    int page = 1;
    int pageSize = 10;
    PopupWindow pop;
    @ViewInject(value = R.id.tv_home_citylist)
    private TextView homecityshow;
    private RollPagerView mRollViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        x.view().inject(this);

        initData();
        initView();
        inmRolliewPager();//载入滚动的  viewpage
    }
    private void inmRolliewPager() {
        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(2000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);

    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.home_centre_tp,
                R.drawable.home_centre_tp2

        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }



    private void initView() {
        listView = (ListView) findViewById(R.id.lv_home);
        data = new ArrayList<HomeListEntity.ListBean>();
        citylistdates=new ArrayList<HomeTopCityListEntity.ListBean>();


        listAdapter = new HomeListItemAdapter(getApplicationContext(), data);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(HomeActivity.this, DetailPageActivity.class));
            }
        });

    }



    private void initData() {

        //底部 bottom  Listviewdates  获取
        Httpservice.getInstance().detailInfo(page, pageSize, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("我的数据", result);
                homeListEntity = JSON.parseObject(result, HomeListEntity.class);
                if (homeListEntity.getResult() == 200) {
                    data.addAll(homeListEntity.getList());
                    Log.d("HomeActivity", "data:" + data);
                    listAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

//popwindow加载
        Httpservice.getInstance().getcitylistinfo(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                HomeTopCityListEntity citylistdate=JSON.parseObject(result,HomeTopCityListEntity.class);
                if (citylistdate.getResult()==200){
                    citylistdates.addAll( citylistdate.getList());
                    Log.d("我的数据", "城市列表加载完毕");
                }else {
                    Log.d("HomeActivity", "获取失败");
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                homecityshow.setText(  citylistdates.get(0).getCity_name());

            }
        });
    }

//铃铛信息按钮的  弹出popwindows
    @Event(value = R.id.imgbtn_message)
    private void recevicemessage(View view) {
        startActivity(new Intent(HomeActivity.this, MessageActivity.class));
    }
   public void homecitylistshow(View v){
     //  homecitylist.setText("hksajfjksfh");
//正常情况数据来自网络、数据库、文件等，这里我们先假设数据


LinearLayout homelinearlayou= (LinearLayout) findViewById(R.id.home_linearlayou_topopowd);

       View muban = LayoutInflater.from(HomeActivity.this).inflate(R.layout.home_pop_citylist, null);
       pop = new PopupWindow(muban, 480, LayoutParams.WRAP_CONTENT);
       pop.setFocusable(true);
       pop.setBackgroundDrawable(new BitmapDrawable());
       pop.setOutsideTouchable(true);
       pop.showAsDropDown(homelinearlayou, 30, 0);//x:水平偏移   -左   +右 // y:垂直偏移   -上   +下
       //三、获取ListView控件
       ListView    listview= (ListView) muban.findViewById(R.id.listview);
       //四、创建适配器，发现数据源要求，重新整理数据
       //SimpleAdapter对数据源是有要求的，必须是List集合，且集合中的元素类型必须是Map，Map的Key必须是String和Value不限
       //五个参数，第一个传contex当前的Activity，第二个传数据，第三个传城市天气项目布局的id
       //第四个，第五个
       HomePopwindowCitylistItemAdapter adapter = new HomePopwindowCitylistItemAdapter(HomeActivity.this,citylistdates);
       //五、设置适配器
       listview.setAdapter(adapter);
       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              // Toast.makeText(HomeActivity.this, citylistdates.get(i).getCity_name(), Toast.LENGTH_SHORT).show();
               homecityshow.setText(  citylistdates.get(i).getCity_name());
                pop.dismiss();//关闭PopupWindow
           }
       });

    }

}
