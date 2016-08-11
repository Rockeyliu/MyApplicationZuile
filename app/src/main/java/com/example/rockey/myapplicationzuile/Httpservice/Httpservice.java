package com.example.rockey.myapplicationzuile.Httpservice;

import com.example.rockey.myapplicationzuile.constant.Constant;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by LJ on 2016/8/11.
 */
public class Httpservice {

    public Httpservice(){}
    public static Httpservice oneself;
    public static Httpservice getInstance() {
        if (oneself == null) {
            oneself = new Httpservice();
        }
        return oneself;
    }

    public void cityinfo( Callback.CommonCallback<String> callback){//获取城市信息
        RequestParams params  = new RequestParams(Constant.IP+"printCity");
        x.http().get(params, callback);
    }


    public void Parentsinfo( Callback.CommonCallback<String> callback){//获取父分类信息
        RequestParams params  = new RequestParams(Constant.IP+"printCategory");
        x.http().get(params, callback);
    }

    public void childinfo( Callback.CommonCallback<String> callback){//获取子分类信息
        RequestParams params  = new RequestParams(Constant.IP+"printCategory?parent_category_id=1");
        x.http().get(params, callback);
    }

    public void detailInfo( Callback.CommonCallback<String> callback){//查询发布信息
        RequestParams params  = new RequestParams(Constant.IP+"detailInfo");
        x.http().get(params, callback);
    }

    ////  2016/8/11 该接口可能有问题
    public void login(String userName ,String pwd, Callback.CommonCallback<String> callback){//用户登录
        RequestParams params  = new RequestParams(Constant.IP+"isLogin");
        params.addQueryStringParameter("userName",userName);
        params.addQueryStringParameter("password",pwd);
        x.http().get(params, callback);
    }

    //修改密码
    public void updatePwd(String user_id  ,String oldPwd,String newPwd, Callback.CommonCallback<String> callback){
        RequestParams params  = new RequestParams(Constant.IP+"isLogin");
        params.addQueryStringParameter("userName",user_id);
        params.addQueryStringParameter("password",oldPwd);
        params.addQueryStringParameter("password",newPwd);
        x.http().get(params, callback);
    }


    //修改用户信息
    public void updateUser(String user_id  ,String user_name,String phone, String contact_site,Callback.CommonCallback<String> callback){
        RequestParams params  = new RequestParams(Constant.IP+"isLogin");
        params.addQueryStringParameter("userName",user_id);
        params.addQueryStringParameter("password",user_name);
        params.addQueryStringParameter("password",phone);
        params.addQueryStringParameter("contact_site",phone);
        x.http().get(params, callback);
    }
}
