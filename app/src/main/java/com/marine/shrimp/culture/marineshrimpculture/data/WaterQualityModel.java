package com.marine.shrimp.culture.marineshrimpculture.data;

import android.os.Parcel;

public class WaterQualityModel {

    int imageNumber ;
    String title, description;
    int image1, image2, image3;

    public  WaterQualityModel(String title, String description, int image1, int image2, int image3, int imageNumber ){
        this.title=title;
        this.description=description;
        this.image1=image1;
        this.image2=image2;
        this.image3=image3;
        this.imageNumber=imageNumber;
    }


    protected WaterQualityModel(Parcel in) {
        imageNumber = in.readInt();
        title = in.readString();
        description = in.readString();
        image1 = in.readInt();
        image2 = in.readInt();
        image3 = in.readInt();
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public int getImageNumber() {
        return imageNumber;
    }
}
