package com.example.asus.graduationproject.HealthMod;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.graduationproject.Tools.GlobalUitl;
import com.example.asus.graduationproject.Tools.GsonUtil;
import com.example.asus.graduationproject.JavaBean.EaxmInfo;
import com.example.asus.graduationproject.JavaBean.ExamData;
import com.example.asus.graduationproject.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;

public class ExamItemAdapter extends RecyclerView.Adapter<ExamItemAdapter.ViewHolder> {
    private static final String Tag="Adapter";
    private List<EaxmInfo> mlist;
    private static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");
    private List<ExamData> data=new ArrayList<>();
    private static final int CATEGORY=1;
    private static final int ITEM=0;
    private static final int FOOTER=2;
    private Context context;
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        TextView name;
        EditText content;
        Button button;
        ViewHolder(View view,int type){
            super(view);
            switch (type){
                case CATEGORY:
                    //category 的名称
                    category= view.findViewById(R.id.category);
                case ITEM:
                    //category的子项
                    name=view.findViewById(R.id.name);
                    name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context,name.getText().toString(),Toast.LENGTH_SHORT).show();
                            //点击子项的名称，查看该项的历史记录
                            Intent intent=new Intent(context,HistoryExamActivity.class);
                            intent.putExtra("item_name" ,name.getText().toString());

                            context.startActivity(intent);
                        }
                    });
                    content=view.findViewById(R.id.content);
                    break;
                case FOOTER:
                    //提交按钮
                    button=view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            OkHttpClient okHttpClient=new OkHttpClient();
                            okHttpClient.setConnectTimeout(5, TimeUnit.SECONDS);
                            okHttpClient.setWriteTimeout(5, TimeUnit.SECONDS);
                            okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
                            String gson=GsonUtil.createToGson(data);

                            RequestBody requestBody = null;
                            try {
                                requestBody = RequestBody.create(JSON, URLEncoder.encode(gson,"UTF-8"));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            final Request request = new Request.Builder().url(GlobalUitl.BaseURL + "postHistoryData").post(requestBody).build();
                            final Call call=okHttpClient.newCall(request);
                            call.enqueue(new Callback() {
                                @Override
                                    public void onFailure(Request request, IOException e) {
                                        Log.d(Tag,"连接失败");
                                    }

                                    @Override
                                    public void onResponse(Response response) throws IOException {
                                        Log.d(Tag,"连接成功");
                                        SharedPreferences.Editor editor=context.getSharedPreferences(GlobalUitl.accoutName,MODE_PRIVATE).edit();
                                        editor.putString("lastDate",GlobalUitl.getToday());
                                        editor.apply();
                                    }
                                });
                            Toast.makeText(context,"已提交",Toast.LENGTH_SHORT).show();
                            new Thread(){
                                @Override
                                public void run() {
                                    super.run();
                                    try {
                                        Instrumentation inst = new Instrumentation();
                                        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);//必须在线程中运行，不然会报错
                                    }catch (Exception e){

                                    }
                                }
                            }.start();
                        }
                    });



            }
        }
    }
    public ExamItemAdapter(Context context, List<EaxmInfo> mlist){
        this.mlist=mlist;
        this.context=context;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String date  = formatter.format(curDate);
        SharedPreferences islogin=context.getSharedPreferences("login",MODE_PRIVATE);
        String name=islogin.getString("account","未登录");
        for(int i=0;i<mlist.size();i++){
            ExamData examData=new ExamData();
            examData.setDate(date);
            examData.setUser_name(name);
            examData.setItem_name(mlist.get(i).getName());
            examData.setCategory(mlist.get(i).getCategory());
            examData.setNormal_val(mlist.get(i).getNormal_val());
            examData.setNumber(mlist.get(i).isNumber());
            examData.setPosition(mlist.get(i).getPosition());
            data.add(examData);
        }

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case CATEGORY:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_item_category,parent,false);
                return new ViewHolder(view,CATEGORY);
            case FOOTER:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_item_footer,parent,false);
                return new ViewHolder(view,FOOTER);
            case ITEM:
            default :
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_item,parent,false);
                return new ViewHolder(view,ITEM);
        }
    }

    @Override
    public int getItemViewType(int position) {

        if(position==0||(
                position<mlist.size()-1&&!mlist.get(position).getCategory().equals(mlist.get(position-1).getCategory()))){
            return CATEGORY;
        }
        if(position==mlist.size())
            return FOOTER;
        return ITEM;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        switch (getItemViewType(position)){
            case CATEGORY:
                holder.category.setText(mlist.get(position).getCategory());
            case ITEM:
                holder.name.setText(mlist.get(position).getName());
                holder.content.setHint(mlist.get(position).getNormal_val());
                data.get(position).setVal(holder.content.getHint().toString());

                holder.content.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if(!hasFocus){
                            if(holder.content.getText().length()==0){
                                data.get(position).setVal(holder.content.getHint().toString());
                            }else{
                                data.get(position).setVal(holder.content.getText().toString());
                            }
                            Log.d(Tag,data+"");
                        }
                    }
                });

            default :break;
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size()+1;
    }


}