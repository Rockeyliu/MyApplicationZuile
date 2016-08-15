package com.example.rockey.myapplicationzuile.entity;

import android.widget.Toast;

/**
 * Created by LJ on 2016/8/15.
 */
public class CollectEntity {

    private int imgUrlList;
    private String merchant_name;
    private String per_capita_consumption;
    private String business_location;
    private String opening_time;
    private String closing_time;

    public int getImgUrlList() {
        return imgUrlList;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public String getPer_capita_consumption() {
        return per_capita_consumption;
    }

    public String getBusiness_location() {
        return business_location;
    }

    public String getOpening_time() {
        return opening_time;
    }

    public String getClosing_time() {
        return closing_time;
    }

    public void setImgUrlList(int imgUrlList) {
        this.imgUrlList = imgUrlList;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public void setPer_capita_consumption(String per_capita_consumption) {
        this.per_capita_consumption = per_capita_consumption;
    }

    public void setBusiness_location(String business_location) {
        this.business_location = business_location;
    }

    public void setOpening_time(String opening_time) {
        this.opening_time = opening_time;
    }

    public void setClosing_time(String closing_time) {
        this.closing_time = closing_time;
    }
}
