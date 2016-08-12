package com.example.rockey.myapplicationzuile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.rockey.myapplicationzuile.Httpservice.Httpservice;
import com.example.rockey.myapplicationzuile.entity.LoginEntity;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class SigninActivityFormLJ extends AppCompatActivity {

    private EditText et_uerName, et_password;
    @ViewInject(value = R.id.btnLogin)
    public Button btnLogin;
    @ViewInject(value = R.id.tv_uerregister)
    public TextView tv_uerregister;
    @ViewInject(value = R.id.tv_forgetpwd)
    public TextView tv_forgetpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activitytohqq);

        et_uerName = (EditText) findViewById(R.id.et_uerName);
        et_password = (EditText) findViewById(R.id.et_password);

        et_password.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

        x.view().inject(this);
    }


    @Event(value = R.id.btnLogin)
    private void blogin(View view) {
        String uerName = et_uerName.getText().toString();
        String password = et_password.getText().toString();
        Log.i("TAG", "kaishi" + uerName + password);
        btnLogin.setFocusable(false);
        Httpservice.getInstance().login("1",uerName, password,new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.d("嘴大", result);
                LoginEntity loginEntity = JSON.parseObject(result, LoginEntity.class);
                if (loginEntity.getResult() == 200) {
                    Log.i("TAG",loginEntity.getList().getUser_name());
                    Toast.makeText(SigninActivityFormLJ.this, "登陆成功", Toast.LENGTH_SHORT).show();

                  //  startActivity(new Intent(SigninActivityFormLJ.this, ));
                } else {
                    Toast.makeText(SigninActivityFormLJ.this, "登录失败", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("嘴大", ex.getMessage());

                btnLogin.setFocusable(true);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                btnLogin.setFocusable(true);
            }

            @Override
            public void onFinished() {
                btnLogin.setFocusable(true);
            }
        });

    }

    public void uerregister(View view){
       startActivity(new Intent(SigninActivityFormLJ.this,releaseActivityFormRockey.class));
    }

    public void forgetpwd(View view){
       // startActivity(new Intent(SigninActivityFormLJ.this,RegistActivity.class));
    }

    public void loginreturn(View view){
      //  startActivity(new Intent(SigninActivityFormLJ.this,RegistActivity.class));
     //   SigninActivityFormLJ.this.finish();
    }
}
