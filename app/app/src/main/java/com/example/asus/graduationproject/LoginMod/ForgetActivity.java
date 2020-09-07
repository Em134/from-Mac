package com.example.asus.graduationproject.LoginMod;

import androidx.appcompat.app.AppCompatActivity;

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

public class ForgetActivity extends AppCompatActivity {
    private static  final String TAG="ForgetActivity";
    RegisterEditview pwd;
    String phone=null;
    RegisterEditview pwd_again;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        phone=getIntent().getStringExtra("phone");
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
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pwd.isOK()&&pwd_again.isOK()){
                    updatePwd(pwd.getText().toString());

                }else{
                    Toast.makeText(ForgetActivity.this,"注册信息填写有误",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void updatePwd(String pwd){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request.Builder builder=new Request.Builder();

        FormEncodingBuilder requestBodyBuilder=new FormEncodingBuilder();
        requestBodyBuilder.add("userPwd",pwd).
                add("phone",phone);
        RequestBody requestBody = requestBodyBuilder.build();
        final Request request = builder.url(GlobalUitl.BaseURL + "updatePwd").post(requestBody).build();
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
                            Toast.makeText(ForgetActivity.this,"密码修改成功",Toast.LENGTH_SHORT).show();
                            ForgetActivity.this.finish();
                        }else{
                            Toast.makeText(ForgetActivity.this,"修改错误",Toast.LENGTH_SHORT).show();;

                        }
                    }
                });

            }
        });
    }
}
