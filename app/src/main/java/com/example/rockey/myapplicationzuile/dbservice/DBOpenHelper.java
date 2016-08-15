package com.example.rockey.myapplicationzuile.dbservice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rockey on 2016/8/15.
 */
public class DBOpenHelper extends SQLiteOpenHelper {


    public DBOpenHelper(Context context) {
        super(context, "dream.db", null, 1);//<包>/databases/

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE islog(thisid integer primary key autoincrement, userid varchar(20), islogin VARCHAR(2) NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
