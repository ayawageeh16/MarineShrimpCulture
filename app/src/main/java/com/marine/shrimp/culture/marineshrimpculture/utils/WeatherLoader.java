package com.marine.shrimp.culture.marineshrimpculture.utils;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.marine.shrimp.culture.marineshrimpculture.data.IconModel;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.WeatherContract;

import java.util.List;

public class WeatherLoader extends AsyncTaskLoader<Cursor> {

    Context context;
    public WeatherLoader(Context context) {
        super(context);
        this.context = context;
    }
    @Override
    public Cursor loadInBackground() {
        Uri querySearch = WeatherContract.WeatherEntry.CONTENT_URI;
        try{
            return context.getContentResolver().query(querySearch,
                    null,
                    null,
                    null,
                    null,
                    null);
        }catch (Exception e){
            Log.e("query","failed");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public void deliverResult(Cursor data) {
        super.deliverResult(data);
    }
}
