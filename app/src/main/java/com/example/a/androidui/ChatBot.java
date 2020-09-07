package com.example.a.androidui;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatBot extends AppCompatActivity implements View.OnClickListener {
    public static String GET_URL = "http://openapi.tuling123.com/openapi/api/v2";
    public static List<Msg> msgs = new ArrayList<>();
    RecyclerView msg_recyclerview;
    Context context = ChatBot.this;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Msg msg ;
    Msg msg1;
    MsgAdapter msgAdapter;
    private EditText want_to_say;
    private Button send;
    ImageView open;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        want_to_say = findViewById(R.id.want_to_say);
        title = findViewById(R.id.title);
        drawerLayout = findViewById(R.id.draw);
        open = findViewById(R.id.open_nav);
        open.setOnClickListener(this);
        send = findViewById(R.id.send);
        send.setOnClickListener(this);

        InitRecyclerView();
    }




    private void InitRecyclerView() {
        msg_recyclerview = findViewById(R.id.msg_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msg_recyclerview.setLayoutManager(linearLayoutManager);
        msgAdapter = new MsgAdapter(msgs, context);
        msg_recyclerview.setAdapter(msgAdapter);
        //键盘上移时recyclerview跟着上移
        msgs.clear();
        msg1 = new Msg("你好,请问想和我聊什么呢?",Msg.TYPE_RECEIVED);
        msgs.add(msg1);
        msg_recyclerview.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                if (bottom < oldBottom) {
                    msg_recyclerview.post(new Runnable() {
                        @Override
                        public void run() {
                            if (msgAdapter.getItemCount() > 0) {
                                msg_recyclerview.smoothScrollToPosition(msgAdapter.getItemCount() - 1);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send:
                if (want_to_say.getText().toString().equals("")) {
                    //
                    Toast.makeText(context, "请输入内容", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("MainActivity-----",want_to_say.getText().toString());
                    msg = new Msg(want_to_say.getText().toString(), Msg.TYPE_SENT);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                msgs.add(msg);
                                Log.e("MainActivity-----",msg.getContent());
                                msgAdapter.notifyItemInserted(msgs.size() - 1);
                                msg_recyclerview.scrollToPosition(msgs.size() - 1);
                                internet();
                                want_to_say.setText("");
                            }
                        });
                    }

                }).start();
                }
                break;
            case R.id.open_nav:
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
                break;
            default:
                break;
        }
    }

    private void internet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String content1 = Post();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            msg1 = new Msg(handleJson(content1), Msg.TYPE_RECEIVED);
                            msgs.add(msg1);
                            msgAdapter.notifyItemInserted(msgs.size() - 1);
                            msg_recyclerview.scrollToPosition(msgs.size() - 1);
                            //Glide.get(context).clearMemory();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        }).start();
    }

    private String Post() {
                OkHttpClient okHttpClient = new OkHttpClient();//客户端
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), getJson(msg.getContent()));
                Request request = new Request.Builder()//发送请求
                        .url(GET_URL)
                        .post(requestBody)//把body发送出去
                        .build();
                try {
                    Response response = okHttpClient.newCall(request).execute();//接受传回来的
                    String content = response.body().string();
                    Log.e("TAG-------", content);
                    return content;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;

    }

    public static String handleJson(String json) throws JSONException {
        StringBuilder stringBuilder = new StringBuilder();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String content = object.getJSONObject("values").getString("text");
            stringBuilder.append(content);
        }
        return String.valueOf(stringBuilder);
    }

    public static String getJson(String content) {

       return "{\n"+
            "\"reqType\":0,\n"+
               "\"perception\": {\n"+
            "\"inputText\": {"+
            "   \"text\":\" "+content+"\"\n" +
            "},\n"+
            "},\n"+
            "\"userInfo\": {"+
            "\"apiKey\": \"fff5b072570540e892a208abb5d8250a\",\n"+
               "\"userId\": \"297227\"\n"+
        "   }\n"+
        "}";
    }

}
