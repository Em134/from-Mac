package com.example.asus.graduationproject.HealthMod;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.JavaBean.EaxmInfo;
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

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExamFragment extends Fragment {
    //根据部位进行显示该部位的体检项目
    private static final String Tag="ExamFragment";

    private List<EaxmInfo> data;
    private String position;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ExamItemAdapter myAdapter = new ExamItemAdapter(getContext(), data);
            recyclerView.setAdapter(myAdapter);
            recyclerView.setItemViewCacheSize(40);
            Log.d(Tag,data.size()+"");
        }
    };
    private RecyclerView recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam, container, false);
        initView(view);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //开线程提交网络请求
                assert getArguments() != null;
                position=getArguments().getString("position");
                OkHttpClient okHttpClient=new OkHttpClient();
                okHttpClient.setConnectTimeout(5, TimeUnit.SECONDS);
                okHttpClient.setWriteTimeout(5, TimeUnit.SECONDS);
                okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
                Request.Builder builder=new Request.Builder();

                FormEncodingBuilder requestBodyBuilder=new FormEncodingBuilder();

                requestBodyBuilder.add("position",position);
                RequestBody requestBody= requestBodyBuilder.build();
                final Request request = builder.url(GlobalUitl.BaseURL + "queryExamItemName").post(requestBody).build();

                final Call call=okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        Looper.prepare();
                        Toast.makeText(getContext(),"网络故障，请稍后再尝试连接！",Toast.LENGTH_SHORT).show();
                        Log.d(Tag,"连接失败");
                        Looper.loop();
                    }


                    @Override
                    public void onResponse(Response response) throws IOException {
                        Log.d(Tag,"连接成功");
                        Gson gson=new Gson();
                        String responsestr=response.body().string();
                        //获得该部位的体检项目表
                        data=gson.fromJson(responsestr,
                                new TypeToken<List<EaxmInfo>>() {}.getType());
                        mHandler.sendEmptyMessage(1);

                    }
                });
            }
        }).start();

        return view;
    }

    private void initView(View view){
         recyclerView = view.findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);


    }


}
