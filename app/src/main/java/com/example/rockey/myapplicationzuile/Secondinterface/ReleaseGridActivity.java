package com.example.rockey.myapplicationzuile.Secondinterface;


import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.R;
import com.example.rockey.myapplicationzuile.Secondinterface.Adapter.RelealPopwindowCitylistItemAdapter;
import com.example.rockey.myapplicationzuile.Secondinterface.Adapter.ReleaseItemAdapter;


import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.List;


public class ReleaseGridActivity extends AppCompatActivity {

    GridView gridview;
    ReleaseItemAdapter adapter ;
    int[] icons = {R.drawable.meishi, R.drawable.yule, R.drawable.fangchan,
            R.drawable.che, R.drawable.hunqing, R.drawable.zhuangxiu,
          R.drawable.jiaoyu, R.drawable.gongzuo,R.drawable.baihuode,
            R.drawable.tiaozhao, R.drawable.shangwu, R.drawable.bianmin,
           R.drawable.laoxianghui, R.drawable.qita };
    String[] name = {"美食","娱乐","房产","车","婚庆","装修","教育",
            "工作","百货","跳蚤","商务","便民","老乡会","其他"};
List<GridEntity.ListBean>  dates;
    PopupWindow pop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_grid);
        dates=new ArrayList<GridEntity.ListBean>();
        adapter=new ReleaseItemAdapter(this,dates);
        inview();
        indate();
    }

    private void indate() {
        Httpservice.getInstance().Parentsinfo(new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("ReleaseGridActivity", result);
                GridEntity gridtdates= JSON.parseObject(result,GridEntity.class);
                if (gridtdates.getResult()==200){
                //    gridtdates.addAll( citylistdate.getList());
                    dates.addAll(gridtdates.getList());
                    adapter.notifyDataSetChanged();
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
            }
        });
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
                releaseintpopwindows(dates.get(position).getChildCategoryList());
            }
        });
    }

    private void releaseintpopwindows(final List<GridEntity.ListBean.ChildCategoryListBean> popdatest) {
        final List<GridEntity.ListBean.ChildCategoryListBean> popdate=popdatest;
        View parent = ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
        View popView = View.inflate(this, R.layout.selease_pop_listview, null);
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        final PopupWindow popWindow = new PopupWindow(popView,width,height);
        popWindow.setFocusable(true);
        popWindow.setAnimationStyle(R.style.AnimBottom);
        popWindow.setOutsideTouchable(false);// 设置允许在外点击消失
        ListView listview= (ListView) popView.findViewById(R.id.selease_poplistview);
        RelealPopwindowCitylistItemAdapter adapter = new RelealPopwindowCitylistItemAdapter(ReleaseGridActivity.this,popdatest);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ReleaseGridActivity.this, popdate.get(i).getChild_category_name().toString(), Toast.LENGTH_SHORT).show();
                popWindow.dismiss();//关闭listview
            }
        });
        ColorDrawable dw = new ColorDrawable(0x30000000);
        popWindow.setBackgroundDrawable(dw);//背景颜色
        popWindow.showAtLocation(parent, Gravity.BOTTOM , 200, 300);
























//        LinearLayout homelinearlayou=(LinearLayout) findViewById(R.id.release_ll);
//        View muban = LayoutInflater.from(ReleaseGridActivity.this).inflate(R.layout.selease_pop_listview, null);
//
//
//        pop = new PopupWindow(muban, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        pop.setFocusable(true);
//        pop.setBackgroundDrawable(new BitmapDrawable());
//        pop.setOutsideTouchable(true);
//
//        pop.showAsDropDown(homelinearlayou,10, -300);//x:水平偏移   -左   +右 // y:垂直偏移   -上   +下
//
//        ListView listview= (ListView) muban.findViewById(R.id.selease_poplistview);
//        RelealPopwindowCitylistItemAdapter adapter = new RelealPopwindowCitylistItemAdapter(ReleaseGridActivity.this,popdatest);
//
//        listview.setAdapter(adapter);
//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                pop.dismiss();//关闭listview
//            }
//        });


    }


}
