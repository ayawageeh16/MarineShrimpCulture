package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class SysModel {
    @SerializedName("message")
    @Expose
    public Float message;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("sunrise")
    @Expose
    public Integer sunrise;
    @SerializedName("sunset")
    @Expose
    public Integer sunset;

    public SysModel(Float message, String country, Integer sunrise, Integer sunset) {
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Float getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }
}
