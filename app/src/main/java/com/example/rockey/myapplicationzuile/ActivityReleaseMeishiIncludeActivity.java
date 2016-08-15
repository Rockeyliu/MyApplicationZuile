package com.example.rockey.myapplicationzuile;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;


public class ActivityReleaseMeishiIncludeActivity extends Activity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release_meishi_include);

        imageButton = (ImageButton) findViewById(R.id.imgbnt_meishi_waimai_picture);

    }
    public void myOnClick(View view){

    }

}
