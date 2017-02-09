package com.icooer;

/**
 * Created by zhoushuai on 2017/1/19.
 */
public class User {
    private int id;
    private String name;

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

    @Override
    public String toString() {
        return getId()+":"+getName();
    }
}
