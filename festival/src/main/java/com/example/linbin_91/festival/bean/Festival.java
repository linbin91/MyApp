package com.example.linbin_91.festival.bean;

/**
 * Created by linbin_91 on 2015/10/17.
 */
public class Festival {
    public  int id;
    public  String name;

    public Festival(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
