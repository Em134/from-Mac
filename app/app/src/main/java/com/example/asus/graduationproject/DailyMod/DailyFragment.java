package com.example.asus.graduationproject.DailyMod;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.graduationproject.JavaBean.DailyItem;
import com.example.asus.graduationproject.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DailyFragment extends Fragment {
    //日报模块的主界面
    private List<DailyItem> list=new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        initData();
        initView(view);
        return view;
    }
    private void initView(View view){
        recyclerView=view.findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext()) ;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new DailyAdapter(getContext(),list));
    }
    private void initData(){
        if(list.size()==0){
            list.add(new DailyItem("每日步数",R.drawable.walk,"世界那么大,我想去看看"));
            list.add(new DailyItem("运动计划",R.drawable.sport,"生命在于运动，健康在于锻炼"));
            list.add(new DailyItem("健康测试",R.drawable.survey,"快来领取你的专属问卷吧"));
            list.add(new DailyItem("医学推文",R.drawable.article,"每天一篇医学知识，让你的健康不再文盲"));
            list.add(new DailyItem("录入设备",R.drawable.devices,"使用设备来快速录入你的健康参数吧"));
        }
    }



}
