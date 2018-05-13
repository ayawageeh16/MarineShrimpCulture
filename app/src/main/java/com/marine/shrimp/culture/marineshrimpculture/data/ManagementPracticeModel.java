package com.marine.shrimp.culture.marineshrimpculture.data;

public class ManagementPracticeModel {
    int image1, image2, image3;
    String title, description;
    int numberOfImages;

    public ManagementPracticeModel( int numberOfImages, String title, String description,
                                    int image1, int image2, int image3) {

        this.numberOfImages=numberOfImages;
        this.title=title;
        this.description=description;
        this.image1=image1;
        this.image2=image2;
        this.image3=image3;
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

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }
}
