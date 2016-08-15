package com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rockey.myapplicationzuile.Firstinterface.Adapter.CollectAdapter;
import com.example.rockey.myapplicationzuile.R;
//收藏
public class CollectionActivity extends AppCompatActivity {

    private CollectAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        listView = (ListView)findViewById(R.id.lv_collect) ;


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }


}
