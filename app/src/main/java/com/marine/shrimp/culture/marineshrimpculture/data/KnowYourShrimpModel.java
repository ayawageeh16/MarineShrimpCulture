package com.marine.shrimp.culture.marineshrimpculture.data;

import android.os.Parcel;
import android.os.Parcelable;

public class KnowYourShrimpModel implements Parcelable{

    int image ;
    String description;

    public KnowYourShrimpModel(int image, String description){
        this.image=image;
        this.description=description;
    }

    protected KnowYourShrimpModel(Parcel in) {
        image = in.readInt();
        description = in.readString();
    }

    public static final Parcelable.Creator<KnowYourShrimpModel> CREATOR = new Parcelable.Creator<KnowYourShrimpModel>() {
        @Override
        public KnowYourShrimpModel createFromParcel(Parcel in) {
            return new KnowYourShrimpModel(in);
        }

        @Override
        public KnowYourShrimpModel[] newArray(int size) {
            return new KnowYourShrimpModel[size];
        }
    };

    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(description);
    }
}
