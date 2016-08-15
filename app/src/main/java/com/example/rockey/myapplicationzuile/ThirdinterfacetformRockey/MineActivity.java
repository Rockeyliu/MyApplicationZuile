package com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rockey.myapplicationzuile.R;
import com.example.rockey.myapplicationzuile.SigninActivityFormLJ;
import com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey.Adapter.MineListItemAdapter;
import com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey.Entity.Ownmodel;

import java.util.ArrayList;
import java.util.List;

public class MineActivity extends AppCompatActivity {
    ListView minfragmentlistview;
    TextView tvclicksignin;
    ImageView img_signin;
List<Ownmodel> dates;
    MineListItemAdapter adapter;
    int[] icons = {R.drawable.img_my_fragment_release_left, R.drawable.img_my_fragment_draft_left, R.drawable.img_my_fragment_collection_left,
            R.drawable.img_my_fragment_msg_left, R.drawable.img_my_fragment_stament_left, R.drawable.img_my_fragment_about_left,
            R.drawable.img_my_fragment_share_left, R.drawable.img_my_fragment_password_left,R.drawable.img_my_fragment_buffer_left};
    String[] name = {"我的发布","我的草稿","我的收藏","我的信息","平台声明","关于\"爱家乡\"","分享软件",
            "修改密码","清除缓存 "};


    View headview,footerview; // list的头部。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
       // 填充list的头部   和底部
        headview = LayoutInflater.from(this).inflate(R.layout.mineheaderview, null);
        footerview=LayoutInflater.from(this).inflate(R.layout.minefooterview, null);


        dates=new ArrayList<Ownmodel>();
        inview();
        intdate();
    }

    private void intdate() {
        for (int i=0;i<name.length;i++){
            Ownmodel tmp=new Ownmodel(name[i],icons[i]);
            dates.add(tmp);
        }

   adapter.notifyDataSetChanged();
    }

    private void inview() {
        minfragmentlistview= (ListView) findViewById(R.id.minfragment_listview);
        tvclicksignin= (TextView) findViewById(R.id.tv_click_signin);
        img_signin= (ImageView) findViewById(R.id.img_signinHeadportrait);
        minfragmentlistview.addHeaderView(headview);
        minfragmentlistview.addFooterView(footerview);
         adapter=new MineListItemAdapter(MineActivity.this,dates);

          minfragmentlistview.setAdapter(adapter);

        minfragmentlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i-1){
                    case 0:
                        Toast.makeText(MineActivity.this, dates.get(i-1).getName(), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MineActivity.this, dates.get(i-1).getName(), Toast.LENGTH_SHORT).show();

                        break;
                    case 2:
                    startActivity(new Intent(MineActivity.this,CollectionActivity.class));
                        break;
                }

            }
        });
    }

    public void signin(View v){
         startActivity(new Intent(MineActivity.this, SigninActivityFormLJ.class));
    }
    public void   Exitlogin(View v){
        Toast.makeText(this, "退出登录", Toast.LENGTH_SHORT).show();
    }
}
