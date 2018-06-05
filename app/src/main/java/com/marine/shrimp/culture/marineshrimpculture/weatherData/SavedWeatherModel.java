package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import android.os.Parcel;
import android.os.Parcelable;

public class SavedWeatherModel implements Parcelable, Parcelable.Creator<SavedWeatherModel>{

    long id;
    String weatherDate, weatherTime, weatherDescription, weatherIcon, weatherPressure, weatherHumidity,
    weatherTempMax, weatherTempMin, weatherSeaLevel, weatherGrndLevel, weatherWindSpeed, weatherWindDegree;

    public SavedWeatherModel (long id, String weatherDate, String weatherTime, String weatherDescription,
                              String weatherIcon, String weatherPressure, String weatherHumidity, String weatherTempMax,
                              String weatherTempMin, String weatherSeaLevel, String weatherGrndLevel, String weatherWindSpeed,
                              String weatherWindDegree) {

        this.id = id;
        this.weatherDate = weatherDate;
        this.weatherTime = weatherTime;
        this.weatherDescription = weatherDescription;
        this.weatherIcon = weatherIcon;
        this.weatherPressure = weatherPressure;
        this.weatherHumidity = weatherHumidity;
        this.weatherTempMax = weatherTempMax;
        this.weatherTempMin = weatherTempMin;
        this.weatherSeaLevel = weatherSeaLevel;
        this.weatherGrndLevel = weatherGrndLevel;
        this.weatherWindSpeed = weatherWindSpeed;
        this.weatherWindDegree = weatherWindDegree;

    }

    public SavedWeatherModel(Parcel in) {
        id = in.readLong();
        weatherDate = in.readString();
        weatherTime = in.readString();
        weatherDescription = in.readString();
        weatherIcon = in.readString();
        weatherPressure = in.readString();
        weatherHumidity = in.readString();
        weatherTempMax = in.readString();
        weatherTempMin = in.readString();
        weatherSeaLevel = in.readString();
        weatherGrndLevel = in.readString();
        weatherWindSpeed = in.readString();
        weatherWindDegree = in.readString();
    }

    public static final Creator<SavedWeatherModel> CREATOR = new Creator<SavedWeatherModel>() {
        @Override
        public SavedWeatherModel createFromParcel(Parcel in) {
            return new SavedWeatherModel(in);
        }

        @Override
        public SavedWeatherModel[] newArray(int size) {
            return new SavedWeatherModel[size];
        }
    };

    public long getId() {
        return id;
    }

    public String getWeatherDate() {
        return weatherDate;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getWeatherHumidity() {
        return weatherHumidity;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public String getWeatherGrndLevel() {
        return weatherGrndLevel;
    }

    public String getWeatherPressure() {
        return weatherPressure;
    }

    public String getWeatherSeaLevel() {
        return weatherSeaLevel;
    }

    public String getWeatherTempMax() {
        return weatherTempMax;
    }

    public String getWeatherTempMin() {
        return weatherTempMin;
    }

    public String getWeatherTime() {
        return weatherTime;
    }

    public String getWeatherWindDegree() {
        return weatherWindDegree;
    }

    public String getWeatherWindSpeed() {
        return weatherWindSpeed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(weatherDate);
        parcel.writeString(weatherTime);
        parcel.writeString(weatherDescription);
        parcel.writeString(weatherIcon);
        parcel.writeString(weatherPressure);
        parcel.writeString(weatherHumidity);
        parcel.writeString(weatherTempMax);
        parcel.writeString(weatherTempMin);
        parcel.writeString(weatherSeaLevel);
        parcel.writeString(weatherGrndLevel);
        parcel.writeString(weatherWindSpeed);
        parcel.writeString(weatherWindDegree);
    }

    @Override
    public SavedWeatherModel createFromParcel(Parcel parcel) {
        return new SavedWeatherModel(parcel);
    }

    @Override
    public SavedWeatherModel[] newArray(int i) {
        return new SavedWeatherModel[i];
    }
}
