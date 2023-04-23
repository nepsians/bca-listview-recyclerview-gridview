package com.example.listviewexample;

public class MyDataModel {
    private String title;
    private String desc;

    public MyDataModel(String title, String desc){
        this.title = title;
        this.desc = desc;
    }

    public String getTitle(){
        return title;
    }

    public String getDesc(){
        return desc;
    }
}
