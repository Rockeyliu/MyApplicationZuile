package com.example.rockey.myapplicationzuile.ThirdinterfacetformRockey.Entity;

/**
 * Created by Administrator on 2016/8/12.
 */
public class Ownmodel {
    String name;
    int imgpath;

    public Ownmodel(String name, int imgpath) {
        this.name = name;
        this.imgpath = imgpath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgpath() {
        return imgpath;
    }

    public void setImgpath(int imgpath) {
        this.imgpath = imgpath;
    }
}
