package com.example.rockey.myapplicationzuile.entity;

/**
 * Created by LJ on 2016/8/11.
 */
public class LoginEntity {

    /**
     * pwd : 123
     * user_id : 1
     * user_name : 李四
     */

    private ListBean list;
    /**
     * list : {"pwd":"123","user_id":1,"user_name":"李四"}
     * msg : success
     * result : 200
     */

    private String msg;
    private int result;

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

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

    public static class ListBean {
        private String pwd;
        private int user_id;
        private String user_name;

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
    }
}
