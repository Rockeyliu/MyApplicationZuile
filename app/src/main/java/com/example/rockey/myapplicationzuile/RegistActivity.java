package com.example.rockey.myapplicationzuile;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.entity.RegisterUserEntity;
import com.example.rockey.myapplicationzuile.entity.GetyzmEntity;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class RegistActivity extends AppCompatActivity {

    @ViewInject(value = R.id.register)
    public Button register;
    @ViewInject(value = R.id.getyzm)
    public Button getyzm;
    @ViewInject(value = R.id.iv_back2)
    public Image iv_back2;
    @ViewInject(value = R.id.register_checkbox)
    public CheckBox register_checkbox;
    @ViewInject(value = R.id.register_haoma)
    private EditText register_haoma;
    @ViewInject(value = R.id.register_yzm)
    private EditText register_yzm;
    @ViewInject(value = R.id.register_mima)
    private EditText register_mima;
    @ViewInject(value = R.id.register_mimaagain)
    private EditText register_mimaagain;
    String haoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        x.view().inject(this);

    }


    @Event(value = R.id.register)
    private void register(View view) {
        haoma = register_haoma.getText().toString();
        String yzm = register_yzm.getText().toString();
        String mima = register_mima.getText().toString();
        String mimaagain = register_mimaagain.getText().toString();

        register.setFocusable(false);

        if (mima == mimaagain) {

            Httpservice.getInstance().registerUser(haoma, mima, yzm, new Callback.CommonCallback<String>() {

                @Override
                public void onSuccess(String result) {

                    RegisterUserEntity registerUserEntity = JSON.parseObject(result, RegisterUserEntity.class);
                    if (registerUserEntity.getResult() == 200) {
                        Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        //  startActivity(new Intent(SigninActivityFormLJ.this, ));
                    } else if (registerUserEntity.getResult() == 201) {
                        Toast.makeText(RegistActivity.this, "验证码不正确", Toast.LENGTH_SHORT).show();
                    } else if (registerUserEntity.getResult() == 202) {
                        Toast.makeText(RegistActivity.this, "手机号码、密码、验证码不能为空", Toast.LENGTH_SHORT).show();

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
            Toast.makeText(RegistActivity.this, "再次确认密码错误", Toast.LENGTH_SHORT).show();
        }
    }


    @Event(value = R.id.getyzm)
    private void getyzm(View view) {
        getyzm.setFocusable(false);
        Httpservice.getInstance().scanCode(haoma, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                GetyzmEntity getyzmEntity = JSON.parseObject(result, GetyzmEntity.class);
                if (getyzmEntity.getCode() == 0) {
                    Toast.makeText(RegistActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
}
