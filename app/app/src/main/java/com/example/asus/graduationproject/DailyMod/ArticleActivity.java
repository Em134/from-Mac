package com.example.asus.graduationproject.DailyMod;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.asus.graduationproject.JavaBean.DailyItem;
import com.example.asus.graduationproject.R;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity {
    //推送模块
    RecyclerView recyclerView;
    private List<DailyItem> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        initData();
        recyclerView=findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ArticleAdapter(ArticleActivity.this,list));
    }
    private void initData(){
        if(list.size()==0){
            //这里为了方便，复用了之前的javabean，其实推送的javabean只需要标题和图片即可
            list.add(new DailyItem("为什么有高血压?",R.drawable.article1,"世界那么大,我想去看看"));
            list.add(new DailyItem("工作压力大\n应该怎么办?",R.drawable.article2,"生命在于运动，健康在于锻炼"));
            list.add(new DailyItem("关于夏日饮食\n你需要注意的事",R.drawable.article3,"快来领取你的专属问卷吧"));
            list.add(new DailyItem("测试文章1",R.drawable.ic_launcher_background,"1"));
            list.add(new DailyItem("测试文章2",R.drawable.ic_launcher_background,"1"));
            list.add(new DailyItem("测试文章3",R.drawable.ic_launcher_background,"1"));
        }
    }

}
