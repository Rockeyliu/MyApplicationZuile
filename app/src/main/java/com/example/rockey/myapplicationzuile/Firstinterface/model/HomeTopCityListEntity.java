package com.example.rockey.myapplicationzuile.Firstinterface.model;

import java.util.List;

/**
 * Created by Rockey on 2016/8/13.
 */
public class HomeTopCityListEntity {


    /**
     * list : [{"city_id":1,"city_name":"长沙"},{"city_id":2,"city_name":"上海"},{"city_id":3,"city_name":"北京"}]
     * msg : success
     * result : 200
     */

    private String msg;
    private int result;
    /**
     * city_id : 1
     * city_name : 长沙
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
        private int city_id;
        private String city_name;

        public int getCity_id() {
            return city_id;
        }

        public void setCity_id(int city_id) {
            this.city_id = city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }
    }
}
