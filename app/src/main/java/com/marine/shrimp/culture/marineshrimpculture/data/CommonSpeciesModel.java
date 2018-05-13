package com.marine.shrimp.culture.marineshrimpculture.data;

import android.os.Parcel;
import android.os.Parcelable;

public class CommonSpeciesModel implements Parcelable {

    String title, commonName, description, distribution, stocking, tolerance, protein, survival, market, spf, problems;
    int image;
    public  CommonSpeciesModel (String title, String commonName, String description, String distribution,
                                String stocking, String tolerance, String protein, String survival, String market,
                                String spf, String problems, int image){
        this.title= title;
        this.commonName= commonName;
        this.description= description;
        this.distribution= distribution;
        this.stocking = stocking;
        this.tolerance = tolerance;
        this.protein =protein;
        this.survival= survival;
        this.market = market;
        this.spf = spf;
        this.problems = problems;
        this.image = image;
    }

    protected CommonSpeciesModel(Parcel in) {
        title = in.readString();
        commonName = in.readString();
        description = in.readString();
        distribution = in.readString();
        stocking = in.readString();
        tolerance = in.readString();
        protein = in.readString();
        survival = in.readString();
        market = in.readString();
        spf = in.readString();
        problems = in.readString();
        image = in.readInt();
    }

    public static final Parcelable.Creator<CommonSpeciesModel> CREATOR = new Parcelable.Creator<CommonSpeciesModel>() {
        @Override
        public CommonSpeciesModel createFromParcel(Parcel in) {
            return new CommonSpeciesModel(in);
        }

        @Override
        public CommonSpeciesModel[] newArray(int size) {
            return new CommonSpeciesModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCommonName() {
        return commonName;
    }

    public String getDistribution() {
        return distribution;
    }

    public String getMarket() {
        return market;
    }

    public String getProtein() {
        return protein;
    }

    public String getStocking() {
        return stocking;
    }

    public String getSurvival() {
        return survival;
    }

    public String getTolerance() {
        return tolerance;
    }

    public String getSpf() { return spf; }

    public String getProblems(){
        return this.problems;
    }

    public int getImage() {
        return image;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(commonName);
        parcel.writeString(description);
        parcel.writeString(distribution);
        parcel.writeString(stocking);
        parcel.writeString(tolerance);
        parcel.writeString(protein);
        parcel.writeString(survival);
        parcel.writeString(market);
        parcel.writeString(spf);
        parcel.writeString(problems);
        parcel.writeInt(image);
    }
}
