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
import com.example.rockey.myapplicationzuile.entity.GetyzmEntity;
import com.example.rockey.myapplicationzuile.entity.HeiduiYzmEntity;
import com.example.rockey.myapplicationzuile.entity.LoginEntity;

import org.xutils.common.Callback;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
//忘记密码界面的
public class  ForgetPasswordActivityFormRockey extends AppCompatActivity {

    @ViewInject(value = R.id.forget_password_getyzm)
    public Button forget_password_getyzm;
    @ViewInject(value = R.id.forget_password_getmima)
    public Button forget_password_getmima;
    @ViewInject(value = R.id.forget_password_haoma)
    public EditText forget_password_haoma;
    @ViewInject(value = R.id.forget_password_againyzm)
    public EditText forget_password_againyzm;
    @ViewInject(value = R.id.forget_password_getnewpwd)
    public EditText forget_password_getnewpwd;
    @ViewInject(value = R.id.forget_password_back)
    public ImageView forget_password_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_activity_form_rockey);
        x.view().inject(this);

    }

    /**
     * 先通过点击获取验证码按钮调用Httpservice.getInstance().scanCode获取验证码，
     * 再点击获取登录密码：Httpservice.getInstance().checkCode验证获取的验证码，如果正确，则调用Httpservice.getInstance().forgetPwd修改密码
     */
    @Event(value = R.id.forget_password_getmima)
    private void forgetpwdgetmima(View view) {
        String forgetpwdgetyzm = forget_password_againyzm.getText().toString();

        forget_password_getmima.setFocusable(false);

        Httpservice.getInstance().checkCode( forgetpwdgetyzm , new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {

                HeiduiYzmEntity heiduiYzmEntity = JSON.parseObject(result, HeiduiYzmEntity.class);
                if (heiduiYzmEntity.getResult() == 200) {
                    Toast.makeText(ForgetPasswordActivityFormRockey.this, "验证成功", Toast.LENGTH_SHORT).show();
                    String forgetpwdgethaoma = forget_password_haoma.getText().toString();
                    String forgetnewpwd = forget_password_getnewpwd.getText().toString();

                    Httpservice.getInstance().forgetPwd( forgetpwdgethaoma ,forgetnewpwd, new Callback.CommonCallback<String>() {

                        @Override
                        public void onSuccess(String result) {

                            HeiduiYzmEntity heiduiYzmEntity = JSON.parseObject(result, HeiduiYzmEntity.class);
                            if (heiduiYzmEntity.getResult() == 200) {
                                Toast.makeText(ForgetPasswordActivityFormRockey.this, "操作成功", Toast.LENGTH_SHORT).show();
                                //  startActivity(new Intent(SigninActivityFormLJ.this, ));
                            } else {
                                Toast.makeText(ForgetPasswordActivityFormRockey.this, "操作失败", Toast.LENGTH_SHORT).show();
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



                    //  startActivity(new Intent(SigninActivityFormLJ.this, ));
                } else {
                    Toast.makeText(ForgetPasswordActivityFormRockey.this, "操作失败", Toast.LENGTH_SHORT).show();
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



    @Event(value = R.id.forget_password_getyzm)
    private void getyzm(View view) {
        String forgetpwdgethaoma = forget_password_haoma.getText().toString();
        // Toast.makeText(RegisterActivityFromRockey.this,haoma,Toast.LENGTH_LONG).show();
        forget_password_getyzm.setFocusable(false);
        Httpservice.getInstance().scanCode(forgetpwdgethaoma, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                GetyzmEntity getyzmEntity = JSON.parseObject(result, GetyzmEntity.class);
                if (getyzmEntity.getCode() == 0) {
                    Toast.makeText(ForgetPasswordActivityFormRockey.this, "发送成功", Toast.LENGTH_SHORT).show();
                }else if(getyzmEntity.getCode() == 2){
                    Toast.makeText(ForgetPasswordActivityFormRockey.this, "参数 mobile 格式不正确，mobile手机号格式不正确", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                forget_password_getyzm.setFocusable(true);
            }

            @Override
            public void onCancelled(CancelledException cex) {
                forget_password_getyzm.setFocusable(true);
            }

            @Override
            public void onFinished() {
                forget_password_getyzm.setFocusable(true);
            }
        });

    }

}
