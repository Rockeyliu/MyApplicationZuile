package com.example.rockey.myapplicationzuile.Firstinterface.model;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
public class model2 {

    /**
     * list : [{"business_location":"望城县 高塘岭镇步行街A8栋4楼","child_category_id":11,"city_id":1,"detail_id":47,"detail_info":"基于影院设备之间的互联互通，每天24小时、全年365天无间断地为设备提供实时、专业的监控、预警和维护服务。目前，世纪美映数字电影设备监护系统已为今典院线、万达院线、新影联院线、比高国际等多家院线和影院提供服务，有效降低了由放映设备故障造成的维修费用和票房损失，显著提高观众满意度。","imgUrlList":[],"isApprove":0,"is_take_out":0,"merchant_name":"17.5影城（望城店）","parent_category_id":2,"per_capita_consumption":0,"phone":"0731-82021811","user_id":21}]
     * msg : success
     * result : 200
     */

    private String msg;
    private int result;
    /**
     * business_location : 望城县 高塘岭镇步行街A8栋4楼
     * child_category_id : 11
     * city_id : 1
     * detail_id : 47
     * detail_info : 基于影院设备之间的互联互通，每天24小时、全年365天无间断地为设备提供实时、专业的监控、预警和维护服务。目前，世纪美映数字电影设备监护系统已为今典院线、万达院线、新影联院线、比高国际等多家院线和影院提供服务，有效降低了由放映设备故障造成的维修费用和票房损失，显著提高观众满意度。
     * imgUrlList : []
     * isApprove : 0
     * is_take_out : 0
     * merchant_name : 17.5影城（望城店）
     * parent_category_id : 2
     * per_capita_consumption : 0
     * phone : 0731-82021811
     * user_id : 21
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
        private int detail_id;
        private String detail_info;
        private int isApprove;
        private int is_take_out;
        private String merchant_name;
        private int parent_category_id;
        private int per_capita_consumption;
        private String phone;
        private int user_id;
        private List<?> imgUrlList;

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

        public String getMerchant_name() {
            return merchant_name;
        }

        public void setMerchant_name(String merchant_name) {
            this.merchant_name = merchant_name;
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

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public List<?> getImgUrlList() {
            return imgUrlList;
        }

        public void setImgUrlList(List<?> imgUrlList) {
            this.imgUrlList = imgUrlList;
        }
    }
}
