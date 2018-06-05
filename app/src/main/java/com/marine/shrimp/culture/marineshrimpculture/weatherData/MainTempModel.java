package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainTempModel {

    @SerializedName("temp")
    @Expose
    public Float temp;
    @SerializedName("pressure")
    @Expose
    public Float pressure;
    @SerializedName("humidity")
    @Expose
    public Integer humidity;
    @SerializedName("temp_min")
    @Expose
    public Float tempMin;
    @SerializedName("temp_max")
    @Expose
    public Float tempMax;
    @SerializedName("sea_level")
    @Expose
    public Float seaLevel;
    @SerializedName("grnd_level")
    @Expose
    public Float grndLevel;

    //float temp, pressure, humidity, temp_min, temp_max;

    public MainTempModel(Float temp, Float pressure, Integer humidity, Float tempMin, Float tempMax, Float seaLevel, Float grndLevel) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
    }

    public Float getTemp() {
        return temp;
    }

    public Float getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Float getTempMin() {
        return tempMin;
    }

    public Float getTempMax() {
        return tempMax;
    }

    public Float getSeaLevel() {
        return seaLevel;
    }

    public Float getGrndLevel() {
        return grndLevel;
    }




}
