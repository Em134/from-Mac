package com.example.asus.graduationproject.JavaBean;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;

public class ExamData {
    private String user_name;
    private String item_name;
    private String normal_val;
    private String position;
    private String category;
    private String date;
    private String val;
    private String result;
    private String low;
    private String high;
    private boolean isNumber;
    @Override
    public String toString(){
        return "user_name="+user_name+","+"item_name="+item_name+","+"normal_val="+normal_val+","+"position="+position+","+"category="+category+","+
        "date="+date+","+"val="+val+","+"isNumber="+isNumber;
    }
    public String getUser_name() {
        return user_name;
    }




    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
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

    public String getDate() {
        return date;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public boolean isNumber() {
        return isNumber;
    }

    public void setNumber(boolean number) {
        isNumber = number;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }



    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }
}
