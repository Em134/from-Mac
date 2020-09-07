package com.example.asus.graduationproject.LoginMod;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.MyView.RegisterEditview;
import com.example.asus.graduationproject.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG ="RegisterActivity" ;

    RegisterEditview name;

    RegisterEditview pwd;

    RegisterEditview pwd_again;

    RegisterEditview phone;

    Button button;
    /*private static class MyHandler extends Handler{
        @Override
        public void handleMessage(Message message){
            if(message.what==1){
                Toast.makeText(new RegisterActivity(),"注册成功",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(new RegisterActivity(),"用户名或者手机号已存在",Toast.LENGTH_SHORT).show();
            }
        }
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    public void initView(){
        name=findViewById(R.id.et_name);
        name.setType("name");
        pwd=findViewById(R.id.et_pwd);

        pwd.setType("pwd");
        pwd_again=findViewById(R.id.et_pwd_again);
        pwd_again.setType("pwd");
        pwd_again.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus&&!pwd.getText().toString().equals(pwd_again.getText().toString())){
                    pwd_again.setBackgroundResource(R.drawable.bg_edittext_wrong);
                }else  pwd_again.setBackgroundResource(R.drawable.bg_edittext_normal);
            }
        });
        phone=findViewById(R.id.et_phone);
        phone.setType("phone");
        button=findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pwd.isOK()&&name.isOK()&&pwd_again.isOK()&&phone.isOK()&&name.isOK()){
                    regist();

                }else{
                    Toast.makeText(RegisterActivity.this,"注册信息填写有误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void regist(){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request.Builder builder=new Request.Builder();

        FormEncodingBuilder requestBodyBuilder=new FormEncodingBuilder();
        requestBodyBuilder.add("userName",name.getText().toString()).add("userPwd",pwd.getText().toString()).
                add("phone",phone.getText().toString());
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
                        if(res.equals("success")){
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                            RegisterActivity.this.finish();
                        }else{
                            Toast.makeText(RegisterActivity.this,"用户名或者手机已存在",Toast.LENGTH_SHORT).show();;

                        }
                    }
                });

            }
        });
    }

}