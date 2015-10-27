package com.example.yasser.myapplication.data;

/**
 * Created by yasser on 10/27/15.
 */
public class LuckNumber {

    private String value;
    private String description;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void deserialize(String text) {
        String [] exploded = text.split("[|]");
        value = exploded[0];
        description = exploded[1];
    }
}
