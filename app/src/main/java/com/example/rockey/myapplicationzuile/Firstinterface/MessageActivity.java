package com.example.rockey.myapplicationzuile.Firstinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.rockey.myapplicationzuile.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MessageActivity extends AppCompatActivity {
   @ViewInject(value =R.id.im_back_mesg )
   public ImageView  imbackmesg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        x.view().inject(this);
    }
   @Event(R.id.im_back_mesg)
    private void back(View view){
       finish();
   }


}
