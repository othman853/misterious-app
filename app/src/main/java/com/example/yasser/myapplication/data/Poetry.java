package com.example.yasser.myapplication.data;

import java.io.Serializable;

/**
 * Created by yasser on 10/28/15.
 */
public class Poetry implements Serializable{

    private String title;
    private String content;

    public Poetry() {
    }

    public Poetry(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Poetry deserialize(String serial) {
        String [] exploded = serial.split("[|]");
        title = exploded[0];
        content = exploded[1];
        return this;
    }
}
