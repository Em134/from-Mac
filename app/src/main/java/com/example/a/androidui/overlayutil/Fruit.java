package com.example.a.androidui.overlayutil;

public class Fruit {
    private String name;
    private int imageId;
    private String urlnume;
    public Fruit(String name,int imageId,String urlnume){
        this.name=name;
        this.imageId=imageId;
        this.urlnume=urlnume;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }

    public String getUrlnume(){
        return urlnume;
    }

}
