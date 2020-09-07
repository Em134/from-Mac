package com.example.asus.graduationproject.Tools;

import com.google.gson.Gson;

public class GsonUtil {
    public static Object createFromGson(String str,Class type){
        return new Gson().fromJson(str,type);
    }
    public static String createToGson(Object object){
        return new Gson().toJson(object);
    }
}
