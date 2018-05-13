package com.marine.shrimp.culture.marineshrimpculture.data;

public class TraditionalAndModernModel {

    int image1, image2, image3;
    String title1 , description1, title2 , description2, title3 , description3,
            title4 , description4, title5 , description5 ;
    int  numberOfImages ;

    public TraditionalAndModernModel (int numberOfImages, String title1, String description1, String title2 , String description2,
                                      String title3, String description3, String title4 , String description4,
                                      String title5, String description5, int image1, int image2, int image3){
        this.numberOfImages=numberOfImages;
        this.title1=title1;
        this.title2=title2;
        this.title3=title3;
        this.title4=title4;
        this.title5=title5;
        this.description1=description1;
        this.description2=description2;
        this.description3=description3;
        this.description4=description4;
        this.description5=description5;
        this.image1=image1;
        this.image2=image2;
        this.image3=image3;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public String getTitle3() {
        return title3;
    }

    public String getTitle2() {
        return title2;
    }

    public int getImage3() {
        return image3;
    }

    public String getDescription3() {
        return description3;
    }

    public String getTitle1() {
        return title1;
    }

    public String getDescription2() {
        return description2;
    }

    public String getDescription1() {
        return description1;
    }

    public int getNumberOfImages() {
        return numberOfImages;
    }

    public String getDescription4() {
        return description4;
    }

    public String getDescription5() {
        return description5;
    }

    public String getTitle4() {
        return title4;
    }

    public String getTitle5() {
        return title5;
    }
}
