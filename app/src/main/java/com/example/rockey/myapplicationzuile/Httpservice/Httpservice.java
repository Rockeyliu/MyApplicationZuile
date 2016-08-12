package com.example.rockey.myapplicationzuile.Httpservice;

import com.example.rockey.myapplicationzuile.constant.ADmodel;
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

    //  2016/8/11 该接口可能有问题
    public void login(String third_login_tag,String userName ,String pwd, Callback.CommonCallback<String> callback){//用户登录
        RequestParams params  = new RequestParams(Constant.IP+"isLogin");
        params.addQueryStringParameter("third_login_tag",third_login_tag);
        params.addQueryStringParameter("userName",userName);
        params.addQueryStringParameter("pwd",pwd);
        x.http().get(params, callback);
    }

    //修改密码
    public void updatePwd(String user_id  ,String oldPwd,String newPwd, Callback.CommonCallback<String> callback){
        RequestParams params  = new RequestParams(Constant.IP+"isLogin");
        params.addQueryStringParameter("user_id",user_id);
        params.addQueryStringParameter("oldPwd",oldPwd);
        params.addQueryStringParameter("newPwd",newPwd);
        x.http().get(params, callback);
    }


    //修改用户信息   请求方式：post
    public void updateUser(String user_id  ,String user_name,String phone, String contact_site,Callback.CommonCallback<String> callback){
        RequestParams params  = new RequestParams(Constant.IP+"isLogin");
        params.addQueryStringParameter("user_id",user_id);
        params.addQueryStringParameter("user_name",user_name);
        params.addQueryStringParameter("phone",phone);
        params.addQueryStringParameter("contact_site",contact_site);
        x.http().get(params, callback);
    }

       //添加发布信息   注：有的发布类型没有下列某些参数，也没关系，只需要添加相应的参数即可
//       public void addDetail(ADmodel dmodel, Callback.CommonCallback<String> callback){
//           RequestParams params  = new RequestParams(Constant.IP+"isLogin");
//           params.addQueryStringParameter("business_location",dmodel.business_location);
//           params.addQueryStringParameter("child_category_id",dmodel.child_category_id);
//           ...
//           x.http().get(params, callback);
//       }


    //  注册用户信息
    public void registerUser(String phone,String pwd  ,String code , Callback.CommonCallback<String> callback){//用户登录
        RequestParams params  = new RequestParams(Constant.IP+"isLogin");
        params.addQueryStringParameter("third_login_tag",phone);
        params.addQueryStringParameter("userName",pwd);
        params.addQueryStringParameter("pwd",code);
        x.http().get(params, callback);
    }

    //  获取验证码
    public void scanCode(String phone , Callback.CommonCallback<String> callback){//用户登录
        RequestParams params  = new RequestParams(Constant.IP+"scanCode");
        params.addQueryStringParameter("phone",phone);
        x.http().get(params, callback);
    }

    //  忘记密码
    public void forgetPwd(String user_id ,String newPwd , Callback.CommonCallback<String> callback){//用户登录
        RequestParams params  = new RequestParams(Constant.IP+"scanCode");
        params.addQueryStringParameter("user_id",user_id);
        params.addQueryStringParameter("newPwd",newPwd);
        x.http().get(params, callback);
    }

     //核对验证码
     public void checkCode(String code  , Callback.CommonCallback<String> callback){//用户登录
         RequestParams params  = new RequestParams(Constant.IP+"checkCode");
         params.addQueryStringParameter("code ",code );
         x.http().get(params, callback);
     }
}
