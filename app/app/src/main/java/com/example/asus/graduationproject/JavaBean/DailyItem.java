package com.example.asus.graduationproject.JavaBean;

public class DailyItem {
    private String name;
    private String content;
    private int image;

    public DailyItem(String name, int imageID,String content) {
        this.image = imageID;
        this.name = name;
        this.content=content;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getContent() {
        return content;
    }

}
