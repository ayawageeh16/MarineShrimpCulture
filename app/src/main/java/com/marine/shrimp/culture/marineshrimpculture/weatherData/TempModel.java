package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TempModel {

    @SerializedName("coord")
    @Expose
    public CoordModel coord;
    @SerializedName("weather")
    @Expose
    public List<WeatherModel> weather = null;
    @SerializedName("base")
    @Expose
    public String base;
    @SerializedName("main")
    @Expose
    public MainTempModel main;
    @SerializedName("wind")
    @Expose
    public WindModel wind;
    @SerializedName("clouds")
    @Expose
    public CloudsModel clouds;
    @SerializedName("dt")
    @Expose
    public Integer dt;
    @SerializedName("sys")
    @Expose
    public SysModel sys;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("cod")
    @Expose
    public Integer cod;


    public TempModel(CoordModel coord, List<WeatherModel> weather, String base, MainTempModel main, WindModel wind, CloudsModel clouds, Integer dt, SysModel sys, Integer id, String name, Integer cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public CoordModel getCoord() {
        return coord;
    }


    public List<WeatherModel> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainTempModel getMain() {
        return main;
    }

    public WindModel getWind() {
        return wind;
    }

    public CloudsModel getClouds() {
        return clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public SysModel getSys() {
        return sys;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCod() {
        return cod;
    }

}
