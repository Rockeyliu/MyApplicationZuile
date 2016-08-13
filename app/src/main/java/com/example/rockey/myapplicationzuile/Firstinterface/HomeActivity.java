package com.example.rockey.myapplicationzuile.Firstinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Firstinterface.Adapter.HomeListItemAdapter;
import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeListEntity;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.R;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ListView listView;
    HomeListEntity homeListEntity;
    List<HomeListEntity.ListBean> data;
    HomeListItemAdapter listAdapter;
    @ViewInject(value = R.id.imgbtn_message)
    private ImageButton imgbtnmessage;
    int page = 1;
    int pageSize = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        x.view().inject(this);

        initData();
        initView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.lv_home);
        data = new ArrayList<HomeListEntity.ListBean>();
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
    }


    @Event(value = R.id.imgbtn_message)
    private void recevicemessage(View view) {
        startActivity(new Intent(HomeActivity.this, MessageActivity.class));
    }


}
