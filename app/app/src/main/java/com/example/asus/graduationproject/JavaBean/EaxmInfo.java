package com.example.asus.graduationproject.JavaBean;

import androidx.annotation.NonNull;

public class EaxmInfo {
    private String name;//项目名称
    private String normal_val;//参考值
    private String position;//部位
    private String category;//分类
    private boolean isNumber;//是否是数字
    @NonNull
    @Override
    public String toString(){
       return "name"+name+",normal_val"+normal_val+"position"+position+",category"+category+"isNumber"+isNumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNormal_val() {
        return normal_val;
    }

    public void setNormal_val(String normal_val) {
        this.normal_val = normal_val;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isNumber() {
        return isNumber;
    }

    public void setNumber(boolean number) {
        isNumber = number;
    }
}
