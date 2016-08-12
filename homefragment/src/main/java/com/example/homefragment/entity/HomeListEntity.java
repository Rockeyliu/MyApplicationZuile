package com.example.homefragment.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/12.
 */
public class HomeListEntity {


    /**
     * list : [{"business_location":"宁乡县一环北路人人乐水晶城C座9楼，10楼（美丽人生中西餐厅楼上）","child_category_id":1,"city_id":1,"closing_time":"23:59","contact":"24小时前台","detail_id":2,"detail_info":"云中天商务会所集休闲，住宿，餐饮于一体。地处中心位置，周边人人乐商圈。吃喝玩乐都非常方便。云中天所有职工恭候您的光临。","imgUrlList":["http://p1.meituan.net/deal/__38987119__2907895.jpg"],"isApprove":0,"is_take_out":0,"measure_unit":"豪华单人间","merchant_name":"云中天商务宾馆","opening_time":"00:00","parent_category_id":1,"per_capita_consumption":158,"phone":"0731-87233777"}]
     * msg : success
     * result : 200
     */

    private String msg;
    private int result;
    /**
     * business_location : 宁乡县一环北路人人乐水晶城C座9楼，10楼（美丽人生中西餐厅楼上）
     * child_category_id : 1
     * city_id : 1
     * closing_time : 23:59
     * contact : 24小时前台
     * detail_id : 2
     * detail_info : 云中天商务会所集休闲，住宿，餐饮于一体。地处中心位置，周边人人乐商圈。吃喝玩乐都非常方便。云中天所有职工恭候您的光临。
     * imgUrlList : ["http://p1.meituan.net/deal/__38987119__2907895.jpg"]
     * isApprove : 0
     * is_take_out : 0
     * measure_unit : 豪华单人间
     * merchant_name : 云中天商务宾馆
     * opening_time : 00:00
     * parent_category_id : 1
     * per_capita_consumption : 158
     * phone : 0731-87233777
     */

    private List<ListBean> list;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String business_location;
        private int child_category_id;
        private int city_id;
        private String closing_time;
        private String contact;
        private int detail_id;
        private String detail_info;
        private int isApprove;
        private int is_take_out;
        private String measure_unit;
        private String merchant_name;
        private String opening_time;
        private int parent_category_id;
        private int per_capita_consumption;
        private String phone;
        private List<String> imgUrlList;

        public String getBusiness_location() {
            return business_location;
        }

        public void setBusiness_location(String business_location) {
            this.business_location = business_location;
        }

        public int getChild_category_id() {
            return child_category_id;
        }

        public void setChild_category_id(int child_category_id) {
            this.child_category_id = child_category_id;
        }

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getClosing_time() {
            return closing_time;
        }

        public void setClosing_time(String closing_time) {
            this.closing_time = closing_time;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public int getDetail_id() {
            return detail_id;
        }

        public void setDetail_id(int detail_id) {
            this.detail_id = detail_id;
        }

        public String getDetail_info() {
            return detail_info;
        }

        public void setDetail_info(String detail_info) {
            this.detail_info = detail_info;
        }

        public int getIsApprove() {
            return isApprove;
        }

        public void setIsApprove(int isApprove) {
            this.isApprove = isApprove;
        }

        public int getIs_take_out() {
            return is_take_out;
        }

        public void setIs_take_out(int is_take_out) {
            this.is_take_out = is_take_out;
        }

        public String getMeasure_unit() {
            return measure_unit;
        }

        public void setMeasure_unit(String measure_unit) {
            this.measure_unit = measure_unit;
        }

        public String getMerchant_name() {
            return merchant_name;
        }

        public void setMerchant_name(String merchant_name) {
            this.merchant_name = merchant_name;
        }

        public String getOpening_time() {
            return opening_time;
        }

        public void setOpening_time(String opening_time) {
            this.opening_time = opening_time;
        }

        public int getParent_category_id() {
            return parent_category_id;
        }

        public void setParent_category_id(int parent_category_id) {
            this.parent_category_id = parent_category_id;
        }

        public int getPer_capita_consumption() {
            return per_capita_consumption;
        }

        public void setPer_capita_consumption(int per_capita_consumption) {
            this.per_capita_consumption = per_capita_consumption;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public List<String> getImgUrlList() {
            return imgUrlList;
        }

        public void setImgUrlList(List<String> imgUrlList) {
            this.imgUrlList = imgUrlList;
        }
    }
}
