package com.example.yasser.myapplication.data;

/**
 * Created by yasser on 10/28/15.
 */
public class Pet {
    private String name;
    private String description;
    private String naturalHabitat;
    private String eatingHabits;
    private String pictureId;


    public Pet() {
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

    public String getNaturalHabitat() {
        return naturalHabitat;
    }

    public void setNaturalHabitat(String naturalHabitat) {
        this.naturalHabitat = naturalHabitat;
    }

    public String getEatingHabits() {
        return eatingHabits;
    }

    public void setEatingHabits(String eatingHabits) {
        this.eatingHabits = eatingHabits;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public Pet deserialize(String serial) {
        String [] data = serial.split("[|]");
        name = data[0];
        description = data[1];
        naturalHabitat = data[2];
        eatingHabits = data[3];
        pictureId = data[4];
        return this;
    }
}
