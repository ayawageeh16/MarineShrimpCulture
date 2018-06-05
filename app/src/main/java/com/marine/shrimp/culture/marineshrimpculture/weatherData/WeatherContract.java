package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import android.net.Uri;
import android.provider.BaseColumns;

public class WeatherContract {


    public static final String AUTHORITY ="com.marine.shrimp.culture.marineshrimpculture";
    public static final Uri BASE_CONTENT_URI= Uri.parse("content://"+AUTHORITY);
    public static final String PATH_WEATHER="weather";

    public static final class WeatherEntry implements BaseColumns {
        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_WEATHER).build();
        public static final String TABLE_NAME = "weather";
        public static final String COLUMN_WEATHER_ID = "id" ;
        public static final String COLUMN_WEATHER_DATE = "date" ;
        public static final String COLUMN_WEATHER_TIME = "time" ;
        public static final String COLUMN_WEATHER_DESCRIPTION = "description" ;
        public static final String COLUMN_WEATHER_ICON = "icon" ;
        public static final String COLUMN_WEATHER_PRESSURE = "pressure" ;
        public static final String COLUMN_WEATHER_HUMIDITY = "humidity" ;
        public static final String COLUMN_WEATHER_TEMP_MAX= "tempmax" ;
        public static final String COLUMN_WEATHER_TEMP_MIN = "tempmin" ;
        public static final String COLUMN_WEATHER_SEA_LEVEL = "sealevel" ;
        public static final String COLUMN_WEATHER_GRND_LEVEL = "grndlevel" ;
        public static final String COLUMN_WEATHER_WIND_SPEED= "windspeed" ;
        public static final String COLUMN_WEATHER_WIND_DEGREE = "winddegree" ;
    }
}
