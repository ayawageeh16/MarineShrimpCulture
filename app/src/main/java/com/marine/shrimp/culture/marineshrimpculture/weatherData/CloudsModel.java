package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class CloudsModel {

    @SerializedName("all")
    @Expose
    public Integer all;

    public CloudsModel(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

}
