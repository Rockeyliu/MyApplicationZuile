package com.example.minefragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MineFragment extends AppCompatActivity {
ListView minfragmentlistview;
    TextView tvclicksignin;
    ImageView img_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_fragment);
        inview();
    }
    private void inview() {
        minfragmentlistview= (ListView) findViewById(R.id.minfragment_listview);
        tvclicksignin= (TextView) findViewById(R.id.tv_click_signin);
        img_signin= (ImageView) findViewById(R.id.img_signinHeadportrait);
    }

   public void signin(View v){
     //  startActivity(new Intent(MineFragment.this,SigninActivityFormLJ.));
   }
}
