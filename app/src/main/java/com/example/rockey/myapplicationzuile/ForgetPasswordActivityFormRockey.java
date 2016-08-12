package com.example.rockey.myapplicationzuile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.entity.LoginEntity;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class  ForgetPasswordActivityFormRockey extends AppCompatActivity {

    @ViewInject(value = R.id.forget_password_getyzm)
    public Button forget_password_getyzm;
    @ViewInject(value = R.id.forget_password_getmima)
    public Button forget_password_getmima;
    @ViewInject(value = R.id.forget_password_haoma)
    public EditText forget_password_haoma;
    @ViewInject(value = R.id.forget_password_againyzm)
    public EditText forget_password_againyzm;
    @ViewInject(value = R.id.forget_password_back)
    public ImageView forget_password_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_activity_form_rockey);

        x.view().inject(this);

    }


    @Event(value = R.id.forget_password_getmima)
    private void forgetpwdgetmima(View view) {
        String forgetpwdgethaoma = forget_password_haoma.getText().toString();
        String forgetpwdgetyzm = forget_password_againyzm.getText().toString();

        forget_password_getmima.setFocusable(false);

        Httpservice.getInstance().forgetPwd(forgetpwdgethaoma, forgetpwdgetyzm , new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                LoginEntity loginEntity = JSON.parseObject(result, LoginEntity.class);
                if (loginEntity.getResult() == 200) {
                    Log.i("TAG",loginEntity.getList().getUser_name());
                    Toast.makeText(ForgetPasswordActivityFormRockey.this, "登陆成功", Toast.LENGTH_SHORT).show();

                    //  startActivity(new Intent(SigninActivityFormLJ.this, ));
                } else {
                    Toast.makeText(ForgetPasswordActivityFormRockey.this, "登录失败", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                forget_password_getmima.setFocusable(true);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                forget_password_getmima.setFocusable(true);
            }

            @Override
            public void onFinished() {
                forget_password_getmima.setFocusable(true);
            }
        });

    }

}
