package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindModel {

    @SerializedName("speed")
    @Expose
    public Float speed;
    @SerializedName("deg")
    @Expose
    public Float deg;

    public WindModel(Float speed, Float deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Float getSpeed() {
        return speed;
    }

    public Float getDeg() {
        return deg;
    }


}
