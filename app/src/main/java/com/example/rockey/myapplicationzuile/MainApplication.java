package com.example.rockey.myapplicationzuile;

import android.app.Application;

import org.xutils.x;

/**
 * Created by LJ on 2016/8/11.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}