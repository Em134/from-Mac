package com.example.asus.graduationproject.LoginMod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.JavaBean.UserInfo;
import com.example.asus.graduationproject.MainActivity;
import com.example.asus.graduationproject.MyView.BackgroundView;
import com.example.asus.graduationproject.MyView.PwdLayout;
import com.example.asus.graduationproject.R;
import com.google.gson.Gson;
import com.mob.MobSDK;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG ="LoginActivity" ;
    UserInfo userInfo;
    BackgroundView backgroundView;
    ImageView login_btn;
    TextView name;
    TextView pwd;
    TextView register;
    TextView forget;
    TextView other;
    TextView phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences islogin=getSharedPreferences("login",MODE_PRIVATE);
        boolean flag=islogin.getBoolean("state",false);
        if(flag){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        intitView();

    }
    @Override
    public void onResume(){
        super.onResume();
        backgroundView.start();
    }
    public void intitView(){
        backgroundView=findViewById(R.id.bg_view);
        backgroundView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.loginbg));
        backgroundView.start();
        backgroundView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                backgroundView.start();
            }
        });
        name=findViewById(R.id.et_name);
        PwdLayout pwdLayout=findViewById(R.id.layout_pwd);
        pwd=pwdLayout.findViewById(R.id.pwd);
        login_btn=findViewById(R.id.btn_login);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(LoginActivity.this,"验证中，请稍等！",Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Looper.prepare();

                            if(login(name.getText().toString(),pwd.getText().toString())){

                                SharedPreferences.Editor islogin=getSharedPreferences("login",MODE_PRIVATE).edit();
                                islogin.putBoolean("state",true);
                                islogin.putString("account",userInfo.getName()) ;
                                //GlobalUitl.accoutName=userInfo.getName();
                                islogin.putString("phone",userInfo.getPhone());

                                islogin.apply();
                                Toast.makeText(LoginActivity.this,"登录成功，加载中！",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);

                                finish();
                            }else{
                                Toast.makeText(LoginActivity.this,"账号密码错误，请重新输入！",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).start();


            }
        });
        forget=findViewById(R.id.forget);//忘记密码
        forget.setOnClickListener(new View.OnClickListener() {//
            @Override
            public void onClick(View v) {
                    final String[] phone = {null};
                    MobSDK.submitPolicyGrantResult(true, null);
                    sendCode(LoginActivity.this);
                    RegisterPage page = new RegisterPage();

                    page.setTempCode(null);
                    page.setRegisterCallback(new EventHandler() {
                        public void afterEvent(int event, int result, Object data) {
                            if (result == SMSSDK.RESULT_COMPLETE) {
                                // 处理成功的结果
                                HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                                // 国家代码，如“86”
                                String country = (String) phoneMap.get("country");
                                // 手机号码，如“13800138000”
                                phone[0] = (String) phoneMap.get("phone");
                                // TODO 利用国家代码和手机号码进行后续的操作
                                Toast.makeText(LoginActivity.this,"验证成功，正在重置密码",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(LoginActivity.this,ForgetActivity.class);
                                intent.putExtra("phone",phone[0]);
                                startActivity(intent);

                            } else{
                                // TODO 处理错误的结果
                                Toast.makeText(LoginActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    page.show(LoginActivity.this);


            }});

        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        phone=findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobSDK.submitPolicyGrantResult(true, null);
                sendCode(LoginActivity.this);
            }
        });
    }
    public boolean login(String name,String pwd) {//登录
        Log.d(TAG,name+","+pwd);
        boolean flag = false;//是否成功登录
         StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
         StrictMode.setThreadPolicy(policy);


        try {
            OkHttpClient okHttpClient=new OkHttpClient();
            Request.Builder builder=new Request.Builder();

            FormEncodingBuilder requestBodyBuilder=new FormEncodingBuilder();
            requestBodyBuilder.add("userName",name).add("userPwd",pwd);
            RequestBody requestBody= requestBodyBuilder.build();
            final Request request = builder.url(GlobalUitl.BaseURL + "login").post(requestBody).build();
            final Call call=okHttpClient.newCall(request);

            Response response=call.execute();
            Gson gson=new Gson();
            userInfo=gson.fromJson(response.body().string(),UserInfo.class);
            Log.d(TAG,userInfo.toString()+"");
            if(userInfo.getState().equals("success")) flag=true;

            Log.d(TAG,flag+"");

        }catch (Exception e){
            e.printStackTrace();
            Log.d(TAG,"提交申请失败");
    }
        return flag;
    }
    public void sendCode(final Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                    // 国家代码，如“86”
                    String country = (String) phoneMap.get("country");
                    // 手机号码，如“13800138000”
                    final String phone = (String) phoneMap.get("phone");
                    // TODO 利用国家代码和手机号码进行后续的操作
                    Toast.makeText(context,"验证成功，请稍后",Toast.LENGTH_SHORT).show();
                    OkHttpClient okHttpClient=new OkHttpClient();
                    Request.Builder builder=new Request.Builder();

                    FormEncodingBuilder requestBodyBuilder=new FormEncodingBuilder();
                    requestBodyBuilder.add("userName",phone).add("userPwd",phone).
                            add("phone",phone);
                    RequestBody requestBody = requestBodyBuilder.build();
                    final Request request = builder.url(GlobalUitl.BaseURL + "regist").post(requestBody).build();
                    final Call call=okHttpClient.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            Log.d(TAG,"failed");
                        }

                        @Override
                        public void onResponse(final Response response) throws IOException {
                            Log.d(TAG,"success");
                            final String res=response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Looper.prepare();

                                            if(login(phone,"wOtjdim9L2@rnBxTJJ%h")){

                                                SharedPreferences.Editor islogin=getSharedPreferences("login",MODE_PRIVATE).edit();
                                                islogin.putBoolean("state",true);
                                                islogin.putString("account",userInfo.getName()) ;
                                                //GlobalUitl.accoutName=userInfo.getName();
                                                islogin.putString("phone",userInfo.getPhone());

                                                islogin.apply();
                                                Toast.makeText(LoginActivity.this,"登录成功，加载中！",Toast.LENGTH_SHORT).show();
                                                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                                                startActivity(intent);

                                                finish();
                                            }else{
                                                Toast.makeText(LoginActivity.this,"账号密码错误，请重新输入！",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }).start();
                                }
                            });

                        }
                    });

                } else{
                    // TODO 处理错误的结果
                    Toast.makeText(context,"验证码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        page.show(context);
    }
}
