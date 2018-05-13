package com.marine.shrimp.culture.marineshrimpculture.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class IconModel implements Parcelable{

    int id;
    Bitmap image;
    String title;

    public IconModel (int id, String title, Bitmap image){
        this.id=id;
        this.title=title;
        this.image=image;
    }

    public Bitmap getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    protected IconModel(Parcel in) {
        id = in.readInt();
        image = in.readParcelable(Bitmap.class.getClassLoader());
        title = in.readString();
    }

    public static final Creator<IconModel> CREATOR = new Creator<IconModel>() {
        @Override
        public IconModel createFromParcel(Parcel in) {
            return new IconModel(in);
        }

        @Override
        public IconModel[] newArray(int size) {
            return new IconModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeParcelable(image, i);
        parcel.writeString(title);
    }
}
