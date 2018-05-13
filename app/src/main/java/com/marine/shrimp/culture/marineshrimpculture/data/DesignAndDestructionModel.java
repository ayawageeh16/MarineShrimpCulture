package com.marine.shrimp.culture.marineshrimpculture.data;

public class DesignAndDestructionModel {

    int image1;
    String title, description ;

    public DesignAndDestructionModel(String title, String description, int image1) {
        this.title=title;
        this.description=description;
        this.image1=image1;
    }

    public String getTitle() {
        return title;
    }

    public int getImage1() {
        return image1;
    }

    public String getDescription() {
        return description;
    }
}
