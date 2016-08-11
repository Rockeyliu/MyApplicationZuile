package com.example.rockey.myapplicationzuile.constant;

import java.util.List;

/**
 * Created by LJ on 2016/8/11.
 */
public class ADmodel {

    public String business_location;
    public String child_category_id;
    public String city_id;
    public String closing_time;
    public String contact;
    public String detail_info;
    public String is_take_out;
    public String measure_unit;
    public String merchant_name;
    public String opening_time;
    public String parent_category_id;
    public String per_capita_consumption;
    public String phone;
    public String title;


    public String collect_fee;
    public String t_close_time;
    public String t_open_time;
    public String take_out_info;
    public String take_out_range;
    public List<ImgUrlInfo> imgeUrl;


    public ADmodel(String business_location, String child_category_id, String city_id, String closing_time, String contact, String detail_info, String is_take_out, String measure_unit, String merchant_name, String opening_time, String parent_category_id, String per_capita_consumption, String phone, String title) {
        this.business_location = business_location;
        this.child_category_id = child_category_id;
        this.city_id = city_id;
        this.closing_time = closing_time;
        this.contact = contact;
        this.detail_info = detail_info;
        this.is_take_out = is_take_out;
        this.measure_unit = measure_unit;
        this.merchant_name = merchant_name;
        this.opening_time = opening_time;
        this.parent_category_id = parent_category_id;
        this.per_capita_consumption = per_capita_consumption;
        this.phone = phone;
        this.title = title;
    }

    public ADmodel(String business_location, String child_category_id, String city_id, String closing_time, String contact, String detail_info, String is_take_out, String measure_unit, String merchant_name, String opening_time, String parent_category_id, String per_capita_consumption, String phone, String title, String collect_fee, String t_close_time, String t_open_time, String take_out_info, String take_out_range, List<ImgUrlInfo> imgeUrl) {
        this.business_location = business_location;
        this.child_category_id = child_category_id;
        this.city_id = city_id;
        this.closing_time = closing_time;
        this.contact = contact;
        this.detail_info = detail_info;
        this.is_take_out = is_take_out;
        this.measure_unit = measure_unit;
        this.merchant_name = merchant_name;
        this.opening_time = opening_time;
        this.parent_category_id = parent_category_id;
        this.per_capita_consumption = per_capita_consumption;
        this.phone = phone;
        this.title = title;
        this.collect_fee = collect_fee;
        this.t_close_time = t_close_time;
        this.t_open_time = t_open_time;
        this.take_out_info = take_out_info;
        this.take_out_range = take_out_range;
        this.imgeUrl = imgeUrl;
    }


}
