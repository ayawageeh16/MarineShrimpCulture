package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class CoordModel {

    @SerializedName("lon")
    @Expose
    public Float lon;
    @SerializedName("lat")
    @Expose
    public Float lat;

    public CoordModel(Float lon, Float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public Float getLat() {
        return lat;
    }
}
