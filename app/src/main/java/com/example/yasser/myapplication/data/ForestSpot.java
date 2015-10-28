package com.example.yasser.myapplication.data;

/**
 * Created by yasser on 10/28/15.
 */
public class ForestSpot {

    private String name;
    private String description;
    private String pets;

    public ForestSpot() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public ForestSpot deserialize(String serial) {
        String [] data = serial.split("[|]");
        name = data[0];
        description = data[1];
        pets = data[2];
        return this;
    }

}
