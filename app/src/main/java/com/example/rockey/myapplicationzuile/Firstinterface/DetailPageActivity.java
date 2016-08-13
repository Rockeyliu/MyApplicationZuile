package com.example.rockey.myapplicationzuile.Firstinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Firstinterface.model.HomeListEntity;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.R;

import org.xutils.common.Callback;

public class DetailPageActivity extends AppCompatActivity {

    ImageView ivDetailBack, ivFenxiang, ivShoucang, ivDaStoreImg;
    LinearLayout detailPhone, detailJubao;
    TextView tvTradeName, tvPerCapita, tvWorkHours, tvPlace, tvContacts, tvPhone, tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        initView();
//        initData();

    }

    private void initView() {
        ivDetailBack = (ImageView) findViewById(R.id.iv_detail_back);
        ivFenxiang = (ImageView) findViewById(R.id.iv_fenxiang);
        ivShoucang = (ImageView) findViewById(R.id.iv_shoucang);
        detailPhone = (LinearLayout) findViewById(R.id.detail_phone);
        detailJubao = (LinearLayout) findViewById(R.id.detail_jubao);

        ivDaStoreImg = (ImageView) findViewById(R.id.iv_daStoreImg);
        tvTradeName = (TextView) findViewById(R.id.tv_tradeName);
        tvPerCapita = (TextView) findViewById(R.id.tv_per_capita);
        tvWorkHours = (TextView) findViewById(R.id.tv_workHours);
        tvPlace = (TextView) findViewById(R.id.tv_place);
        tvContacts = (TextView) findViewById(R.id.tv_contacts);
        tvPhone = (TextView) findViewById(R.id.tv_phone);
        tvDetail = (TextView) findViewById(R.id.tv_detail);

    }

//    private void initData() {
//        Httpservice.getInstance().detailInfo(new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                HomeListEntity homeListEntity = JSON.parseObject(result, HomeListEntity.class);
//                if (homeListEntity.getResult() == 200) {
//
//                }
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//    }

}
