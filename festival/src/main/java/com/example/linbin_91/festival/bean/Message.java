package com.example.linbin_91.festival.bean;

/**
 * Created by linbin_91 on 2015/10/17.
 */
public class Message {

    private  int id;
    private  int festivalId;
    private  String content;

    public Message(int id, int festivalId, String content) {
        this.id = id;
        this.festivalId = festivalId;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getFestivalId() {
        return festivalId;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFestivalId(int festivalId) {
        this.festivalId = festivalId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
