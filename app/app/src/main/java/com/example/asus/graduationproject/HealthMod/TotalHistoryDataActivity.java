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

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.JavaBean.ExamData;
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

public class TotalHistoryDataActivity extends AppCompatActivity {
    //查看该用户该天体检记录的细则
    private final static String Tag="TotalHistoryData";
    private RecyclerView recyclerView;
    String str;
    List<ExamData> list;
    String user_name;
    String date;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TotalHistoryDataAdapter myAdapter = new TotalHistoryDataAdapter(TotalHistoryDataActivity.this, list);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setItemViewCacheSize(20);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tota_history_data);
        initView();
        getData();

    }
    public void initView(){
        recyclerView=findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(TotalHistoryDataActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Intent intent=getIntent();
        date=intent.getStringExtra("date");
        user_name=intent.getStringExtra("user_name");
    }
    public void getData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();


                OkHttpClient okHttpClient=new OkHttpClient();
                okHttpClient.setConnectTimeout(5, TimeUnit.SECONDS);
                okHttpClient.setWriteTimeout(5, TimeUnit.SECONDS);
                okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);

                FormEncodingBuilder formEncodingBuilder = new FormEncodingBuilder();
                formEncodingBuilder.add("user_name",user_name);
                formEncodingBuilder.add("date",date);
                RequestBody requestBody=formEncodingBuilder.build();
                final Request request = new Request.Builder().url(GlobalUitl.BaseURL + "getTotalHistoryData").post(requestBody).build();
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
                                new TypeToken<List<ExamData>>() {}.getType());
                        Log.d(Tag,list.toString());
                        mHandler.sendEmptyMessage(1);
                    }
                });

            }
        }).start();


    }
}
