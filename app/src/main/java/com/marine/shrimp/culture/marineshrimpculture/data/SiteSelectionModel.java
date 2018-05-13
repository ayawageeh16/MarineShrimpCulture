package com.marine.shrimp.culture.marineshrimpculture.data;

import android.os.Parcel;
import android.os.Parcelable;

public class SiteSelectionModel implements Parcelable{

    static String description, criteria, waterQuality, tidal, soil, topography, vegetation, sourceOfSeed, accessibilty, factors, source;
    static int image ;
    public SiteSelectionModel( String description, String criteria, String waterQuality, String tidal, String soil,
                               String topography, String vegetation, String sourceOfSeed, String accessibilty,
                               String factors, String source, int image){
        this.description=description;
        this.criteria=criteria;
        this.waterQuality=waterQuality;
        this.tidal=tidal;
        this.soil=soil;
        this.topography=topography;
        this.vegetation=vegetation;
        this.sourceOfSeed=sourceOfSeed;
        this.accessibilty=accessibilty;
        this.factors=factors;
        this.source=source;
        this.image=image;
    }

    protected SiteSelectionModel(Parcel in) {
    }

    public static final Parcelable.Creator<SiteSelectionModel> CREATOR = new Parcelable.Creator<SiteSelectionModel>() {
        @Override
        public SiteSelectionModel createFromParcel(Parcel in) {
            return new SiteSelectionModel(in);
        }

        @Override
        public SiteSelectionModel[] newArray(int size) {
            return new SiteSelectionModel[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public String getCriteria() {
        return criteria;
    }

    public String getTidal() {
        return tidal;
    }

    public String getSoil() {
        return soil;
    }

    public String getWaterQuality() {
        return waterQuality;
    }

    public String getAccessibilty() {
        return accessibilty;
    }

    public String getFactors() {
        return factors;
    }

    public String getSource() {
        return source;
    }

    public String getSourceOfSeed() {
        return sourceOfSeed;
    }

    public String getTopography() {
        return topography;
    }

    public String getVegetation() {
        return vegetation;
    }

    public int getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
