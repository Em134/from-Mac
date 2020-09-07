package com.example.asus.graduationproject.HealthMod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TotalHistoryActivity extends AppCompatActivity {
    //显示用户在不同日期录入数据的摘要
    private RecyclerView recyclerView;
    private static final String Tag="TotalHistoryActivity";
    private List<String> list;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TotalHistoryAdapter myAdapter = new TotalHistoryAdapter(TotalHistoryActivity.this, list);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setItemViewCacheSize(20);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_history);
        initView();
        getData();
    }
    public void initView(){
        recyclerView=findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(TotalHistoryActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    public void getData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Intent i=getIntent();


                OkHttpClient okHttpClient=new OkHttpClient();
                okHttpClient.setConnectTimeout(5, TimeUnit.SECONDS);
                okHttpClient.setWriteTimeout(5, TimeUnit.SECONDS);
                okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);

                FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
                formEncodingBuilder.add("user_name", GlobalUitl.accoutName);
                RequestBody requestBody=formEncodingBuilder.build();
                final Request request = new Request.Builder().url(GlobalUitl.BaseURL + "getTotalHistoryItem").post(requestBody).build();
                final Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        Log.d(Tag,"连接失败");
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        Log.d(Tag,"连接成功");
                        Gson gson=new Gson();
                        list=gson.fromJson(response.body().string(),
                                new TypeToken<List<String>>() {}.getType());
                        mHandler.sendEmptyMessage(1);
                    }
                });



                Toast.makeText(TotalHistoryActivity.this,"已提交",Toast.LENGTH_SHORT).show();
            }
        }).start();


    }
}
