package com.marine.shrimp.culture.marineshrimpculture.weatherData;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WeatherDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="weather.db";
    public static final int DATABASE_VERSION = 1;

    public WeatherDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        final String SQL_CREATE_WEATHER_TABLE ="CREATE TABLE "+ WeatherContract.WeatherEntry.TABLE_NAME +" ("
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_ID +" INTEGER PRIMARY KEY,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_DATE +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_TIME +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_DESCRIPTION +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_ICON +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_PRESSURE +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_HUMIDITY +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_TEMP_MAX +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_TEMP_MIN +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_SEA_LEVEL +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_GRND_LEVEL +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_WIND_SPEED +" TEXT,"
                + WeatherContract.WeatherEntry.COLUMN_WEATHER_WIND_DEGREE +" TEXT,"
                +"UNIQUE"+" ("+ WeatherContract.WeatherEntry.COLUMN_WEATHER_TIME+ ") "
                + "ON CONFLICT REPLACE" +");";
        sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ WeatherContract.WeatherEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
