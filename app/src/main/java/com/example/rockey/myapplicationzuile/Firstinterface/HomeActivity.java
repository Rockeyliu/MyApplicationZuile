package com.example.rockey.myapplicationzuile.Firstinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.rockey.myapplicationzuile.Firstinterface.Adapter.HomeListItemAdapter;
import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeListEntity;
import com.example.rockey.myapplicationzuile.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    ListView listView;
    List<HomeListEntity.ListBean> data;
    HomeListItemAdapter listAdapter;
    @ViewInject(value = R.id.imgbtn_message)
    private ImageButton imgbtnmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        x.view().inject(this);
    }

    private void initView(){
        listView = (ListView) findViewById(R.id.lv_home);
        data = new ArrayList<>();
        listAdapter = new HomeListItemAdapter(getApplicationContext(), data);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
    @Event(value = R.id.imgbtn_message)
    private void recevicemessage(View view) {
    startActivity(new Intent(HomeActivity.this,MessageActivity.class));
    }


}
