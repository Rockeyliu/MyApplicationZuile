package com.example.rockey.myapplicationzuile.Firstinterface.model;

import java.util.List;

/**
 * Created by Rockey on 2016/9/1.
 */
public class Advertising {


    /**
     * error_code : 0
     * reason : Success
     * result : {"data":[{"addres":"http://www.baidu.com/","img":"AdvertisingImgs/tu1.jpg"},{"addres":"http://www.whwh11.com/","img":"AdvertisingImgs/tu2.jpg"},{"addres":"http://www.a4yy.com/","img":"AdvertisingImgs/tu3.jpg"}]}
     */

    private int error_code;
    private String reason;
    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * addres : http://www.baidu.com/
         * img : AdvertisingImgs/tu1.jpg
         */

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String addres;
            private String img;

            public String getAddres() {
                return addres;
            }

            public void setAddres(String addres) {
                this.addres = addres;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
