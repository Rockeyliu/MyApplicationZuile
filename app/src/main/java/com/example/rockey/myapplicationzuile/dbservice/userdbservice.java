package com.example.rockey.myapplicationzuile.dbservice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.rockey.myapplicationzuile.constant.Constant;

/**
 * Created by Rockey on 2016/8/15.
 */
public class userdbservice {
private  DBOpenHelper dbOpenHelper;
public  userdbservice(Context contant){
  this.dbOpenHelper=new DBOpenHelper(contant);
}

    /**
     *
     * @param userid  用户名
     * @param islogin  是否登录  1登陆  0退出。
     */

    public void changelogin(String userid,int islogin){
        Log.d("数据", userid);
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("userid", userid);
        values.put("islogin",islogin);
        db.insert("islog", null, values);
    }

    /**
     * 清除缓存的话  删除用户名所有信息
     * @param id
     */


    public void delete(String id){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        db.delete("islog", "userid=?", new String[]{id});
    }
    /**
     * 更新登陆情况
     * @param
     */
    public void uploginxinxi(String userid,int islogin){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("userid",userid);
        values.put("islogin", islogin);
        db.update("islog", values, "userid=?", new String[]{userid});
    }
    /**
     * 查询记录
     * @param
     * @return
     */
    public String whethersomeonelanding(){
        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
        Cursor cursor = db.query("islog", null, "islogin=?", new String[]{"1"}, null, null, null);
        if(cursor.moveToFirst()){
         //   int thisid = cursor.getInt(cursor.getColumnIndex("thisid"));
            String userid = cursor.getString(cursor.getColumnIndex("userid"));
            String islogin = cursor.getString(cursor.getColumnIndex("islogin"));
            return userid;
        }
        cursor.close();
        return "";
    }



}
