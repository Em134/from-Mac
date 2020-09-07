package com.example.asus.graduationproject.Tools;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalUitl {
    public static String BaseURL="http://192.168.43.81:8080/MyServer1/";
    public static String accoutName;
    public static String getToday(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        return formatter.format(curDate);
    }

}
