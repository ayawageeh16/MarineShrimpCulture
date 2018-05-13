package com.marine.shrimp.culture.marineshrimpculture.data;

public class DiseasesAndViralDiseaseModel {

    int image ;
    String title, summary, title1, description1, title2, description2, title3, description3;

    public DiseasesAndViralDiseaseModel(String title, String summary, String title1, String description1, String title2, String description2,
                                        String title3, String description3, int image){
        this.title=title;
        this.summary=summary;
        this.title1=title1;
        this.description1=description1;
        this.title2=title2;
        this.description2=description2;
        this.title3=title3;
        this.description3=description3;
        this.image=image;
    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public String getDescription1() {
        return description1;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription2() {
        return description2;
    }

    public String getTitle1() {
        return title1;
    }

    public String getDescription3() {
        return description3;
    }

    public String getTitle2() {
        return title2;
    }

    public String getTitle3() {
        return title3;
    }
}
