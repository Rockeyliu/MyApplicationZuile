package com.example.rockey.myapplicationzuile;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.entity.RegisterUserEntity;
import com.example.rockey.myapplicationzuile.entity.GetyzmEntity;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
//注册的  Activity
public class releaseActivityFormRockey extends AppCompatActivity {

    @ViewInject(value = R.id.register)
    public Button register;
    @ViewInject(value = R.id.btn_getyzm)
    public Button getyzm;
  @ViewInject(value = R.id.iv_back2)
    public ImageView ivback2;
  ///  @ViewInject(value = R.id.register_checkbox)
    public CheckBox registercheckbox;
//    @ViewInject(value = R.id.register_haoma)
    private EditText registerhaoma;
 //   @ViewInject(value = R.id.register_yzm)
    private EditText registeryzm;
 //   @ViewInject(value = R.id.register_mima)
    private EditText registermima;
  //  @ViewInject(value = R.id.register_mimaagain)
    private EditText registermimaagain;
    String haoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
      x.view().inject(this);
      intview();
    }

    private void intview() {

        ivback2= (ImageView) findViewById(R.id.iv_back2);
        registercheckbox= (CheckBox) findViewById(R.id.register_checkbox);
        registerhaoma= (EditText) findViewById(R.id.register_haoma);
        registeryzm= (EditText) findViewById(R.id.register_yzm);
        registermima=(EditText) findViewById(R.id.register_mima);

        registermimaagain= (EditText) findViewById(R.id.register_mimaagain);
    }


    @Event(value = R.id.register)
    private void register(View view) {
        haoma = registerhaoma.getText().toString();
        String yzm = registeryzm.getText().toString();
        String mima = registermima.getText().toString();
        String mimaagain = registermimaagain.getText().toString();

        register.setFocusable(false);

        if (mima.equals(mimaagain)) {

            Httpservice.getInstance().registerUser(haoma, mima, yzm, new Callback.CommonCallback<String>() {

                @Override
                public void onSuccess(String result) {

                    RegisterUserEntity registerUserEntity = JSON.parseObject(result, RegisterUserEntity.class);
                    if (registerUserEntity.getResult() == 200) {
                        Toast.makeText(releaseActivityFormRockey.this, "注册成功", Toast.LENGTH_SHORT).show();
                        //  startActivity(new Intent(SigninActivityFormLJ.this, ));
                    } else if (registerUserEntity.getResult() == 201) {
                        Toast.makeText(releaseActivityFormRockey.this, "验证码不正确", Toast.LENGTH_SHORT).show();
                    } else if (registerUserEntity.getResult() == 202) {
                        Toast.makeText(releaseActivityFormRockey.this, "手机号码、密码、验证码不能为空", Toast.LENGTH_SHORT).show();

                    }


                }

                @Override
                public void onError(Throwable ex, boolean isOnCallback) {
                    register.setFocusable(true);
                }

                @Override
                public void onCancelled(CancelledException cex) {
                    register.setFocusable(true);
                }

                @Override
                public void onFinished() {
                    register.setFocusable(true);
                }
            });
        } else {
            Toast.makeText(releaseActivityFormRockey.this, "再次确认密码错误", Toast.LENGTH_SHORT).show();
        }
    }





    @Event(value = R.id.btn_getyzm)
    private void getyzm(View view) {
        haoma = registerhaoma.getText().toString();
       // Toast.makeText(RegisterActivityFromRockey.this,haoma,Toast.LENGTH_LONG).show();
        getyzm.setFocusable(false);
        Httpservice.getInstance().scanCode(haoma, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                GetyzmEntity getyzmEntity = JSON.parseObject(result, GetyzmEntity.class);
                if (getyzmEntity.getCode() == 0) {
                    Toast.makeText(releaseActivityFormRockey.this, "发送成功", Toast.LENGTH_SHORT).show();
                }else if(getyzmEntity.getCode() == 2){
                    Toast.makeText(releaseActivityFormRockey.this, "参数 mobile 格式不正确，mobile手机号格式不正确", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                getyzm.setFocusable(true);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                getyzm.setFocusable(true);
            }

            @Override
            public void onFinished() {
                getyzm.setFocusable(true);
            }
        });

    }
}

