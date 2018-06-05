package com.marine.shrimp.culture.marineshrimpculture.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.SavedWeatherModel;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.WeatherContract;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

   int position;
   Context context;
   Cursor cursor;
   public WeatherAdapter(Cursor cursor,Context context){
    this.cursor =cursor;
       this.context=context;
   }
   public WeatherAdapter(Context context){
    this.context=context;
   }

   @NonNull
   @Override
   public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_weather_row,parent,false);
    WeatherViewHolder holder = new WeatherViewHolder(row);
    return holder;
   }

   @Override
   public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
    if (!cursor.moveToPosition(position)) {
     return;
    }else {
     holder.Bind(cursor);
     this.position=position;
     holder.itemView.setTag(cursor.getLong(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_ID)));
    }
   }

   @Override
    public int getItemCount() {
    return  cursor.getCount();
    }

  public class WeatherViewHolder extends RecyclerView.ViewHolder{

   TextView savedTime, savedDate, description;
   ImageView icon;

   public WeatherViewHolder(View itemView) {
    super(itemView);
    savedTime = itemView.findViewById(R.id.saved_time);
    savedDate = itemView.findViewById(R.id.saved_date);
    icon= itemView.findViewById(R.id.saved_icon);
    description=itemView.findViewById(R.id.description_saved);
   }

   public void Bind(final Cursor cursor){
    long weatherId = cursor.getLong(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_ID));
    String weatherDate = String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_DATE)));
    String weatherTime = String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_TIME)));
    String weatherDescription = String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_DESCRIPTION)));
    String weatherIcon = String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_ICON)));
    String weatherPressure = String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_PRESSURE)));
    String weatherHumidity =String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_HUMIDITY)));
    String weatherTempMax =String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_TEMP_MAX)));
    String weatherTempMin=String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_TEMP_MIN)));
    String weatherSeaLevel =String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_SEA_LEVEL)));
    String weatherGrndLevel =String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_GRND_LEVEL)));
    String weatherWindSpeed=String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_WIND_SPEED)));
    String weatherWindDegree =String.valueOf(cursor.getString(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_WIND_DEGREE)));

    final SavedWeatherModel weather =new SavedWeatherModel(weatherId,weatherDate,weatherTime,weatherDescription,weatherIcon,
            weatherPressure,weatherHumidity,weatherTempMax,weatherTempMin,weatherSeaLevel,weatherGrndLevel,weatherWindSpeed,weatherWindDegree);
       String iconUri = "http://openweathermap.org/img/w/" + weatherIcon +
               ".png";
       Glide.with(icon.getContext())
            .load(iconUri)
            .into(icon);
    savedDate.setText(weatherDate);
    savedTime.setText(weatherTime);
    description.setText(weatherDescription);
   }
  }
}
