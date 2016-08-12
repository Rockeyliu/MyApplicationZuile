package com.example.homefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.homefragment.adapter.HomeListItemAdapter;
import com.example.homefragment.entity.HomeListEntity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment1 extends AppCompatActivity {

    ListView listView;
    List<HomeListEntity.ListBean> data;
    HomeListItemAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fragment1);


    }

    private void initView(){
        listView = (ListView) findViewById(R.id.lv_home);
        data = new ArrayList<>();
        listAdapter = new HomeListItemAdapter(this, data);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
