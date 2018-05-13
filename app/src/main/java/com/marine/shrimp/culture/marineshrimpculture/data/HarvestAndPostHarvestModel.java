package com.marine.shrimp.culture.marineshrimpculture.data;

public class HarvestAndPostHarvestModel {

    int image1, image2;
    String title, description;
    int numberOfImages;

    public HarvestAndPostHarvestModel(int numberOfImages, String title, String description,
                                      int image1, int image2) {
        this.numberOfImages = numberOfImages;
        this.title = title;
        this.description = description;
        this.image1 = image1;
        this.image2 = image2;
    }


    public String getTitle() {
        return title;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public int getImage2() {
        return image2;
    }

    public String getDescription() {
        return description;
    }

    public int getImage1() {
        return image1;
    }
}
