package com.example.rockey.myapplicationzuile;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rockey.myapplicationzuile.Firstinterface.HomeActivity;
import com.example.rockey.myapplicationzuile.Secondinterface.ReleaseGridActivity;
import com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey.MineActivity;

import java.util.ArrayList;
import java.util.List;
public class MyActivity extends TabActivity {
    private TabHost tabhost;
    // 存放Tab页中ImageView信息
    private List<ImageView> imageList = new ArrayList<ImageView>();
    // 存放Tab页中TextView信息
    private List<TextView>  textList = new ArrayList<TextView>();
    private void addTab(int tabId,String tabName, int drawableId, Class<?> cls) {
        TabHost.TabSpec ts1 = tabhost.newTabSpec(tabId+"");   //id是选项卡的标识
        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab1, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText(tabName);       //这是选项卡上显示的文字
        if(tabId==0){		//四个选项卡上的文字在xml中默认都设置了灰色，第一个要设置为默认选中的红色
            title.setTextColor(getResources().getColor(R.color.tab_checked_color));
        }
        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(drawableId);
        ts1.setIndicator(tabIndicator);
        ts1.setContent(new Intent(this,cls));		//设置要切换到的Activity
        tabhost.addTab(ts1);						//设置好的控制区加到TabHost中
        imageList.add(icon);	//将下面的四个ImageView加到List中
        textList.add(title);	//将下面的四个TextView加到List中
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //获取TabHost控件
        tabhost = getTabHost();
        addTab(0, "爱家乡", R.drawable.home_press, HomeActivity.class);
        addTab(1,"发布", R.drawable.publish, ReleaseGridActivity.class);
        addTab(2,"我的", R.drawable.wode, MineActivity.class);
        tabhost.getTabWidget().setStripEnabled(false); //设置底部下划线是否出现
        // 设置TabHost的背景颜色
       //tabhost.setBackgroundColor(Color.argb(150, 22, 70, 150));
        //设置当前显示哪一个标签
        tabhost.setCurrentTab(0);
        //标签切换事件处理，setOnTabChangedListener
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {


            public void onTabChanged(String tabId) {
               // Toast.makeText(MyActivity.this, tabId, Toast.LENGTH_LONG).show();
                // 设置所有选项卡的图片为未选中图片
                imageList.get(0).setImageDrawable(getResources().getDrawable(R.drawable.home));
                imageList.get(1).setImageDrawable(getResources().getDrawable(R.drawable.publish));
                imageList.get(2).setImageDrawable(getResources().getDrawable(R.drawable.wode));
                // 设置所有文字为未选中颜色
                for (int i = 0; i < textList.size();i++) {
                    textList.get(i).setTextColor(getResources().getColor(R.color.tab_unchecked_color));
                }
                switch (Integer.parseInt(tabId)) {
                    case 0:
                        imageList.get(0).setImageDrawable(getResources().getDrawable(R.drawable.home_press));
                        textList.get(0).setTextColor(getResources().getColor(R.color.tab_checked_color));
                        break;

                    case 1:
                        imageList.get(1).setImageDrawable(getResources().getDrawable(R.drawable.publish_press));
                        textList.get(1).setTextColor(getResources().getColor(R.color.tab_checked_color));
                        break;
                    case 2:
                        imageList.get(2).setImageDrawable(getResources().getDrawable(R.drawable.wode_press));
                        textList.get(2).setTextColor(getResources().getColor(R.color.tab_checked_color));
                        break;
                }
            }
        });
    }
}
