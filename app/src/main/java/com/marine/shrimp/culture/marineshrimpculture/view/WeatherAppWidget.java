package com.marine.shrimp.culture.marineshrimpculture.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.utils.WeatherDataInterface;
import com.marine.shrimp.culture.marineshrimpculture.utils.WeatherWidgetService;
import com.marine.shrimp.culture.marineshrimpculture.view.WeatherActivity;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.TempModel;

public class WeatherAppWidget extends AppWidgetProvider implements WeatherActivity.EditWidgetListener{

    TempModel model;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                TempModel model, int appWidgetId) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_app_widget);

        views.setTextViewText(R.id.description_widget, model.getWeather().get(0).getDescription());
        views.setTextViewText(R.id.temp_max_widget, String.valueOf(model.getMain().getTempMax()));
        views.setTextViewText(R.id.temp_min_widget, String.valueOf(model.getMain().getTempMin()));
        //views.setBitmap(R.id.image_widget,R.drawable.storm);
        Log.d("HEY HEY HEY WIDGET",model.toString());

        Intent intent = new Intent(context, WeatherActivity.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(context,0,intent,0);
        views.setOnClickPendingIntent(R.id.image_widget,pendingIntent);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        WeatherWidgetService.startActionUpdateWidget(context);
    }

    public static void updatePlantWidgets(Context context, AppWidgetManager appWidgetManager,
                                          TempModel model, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, model, appWidgetId);
            Log.d("HEY HEY HEY WIDGET",model.toString());
        }
    }
    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void updateResult(TempModel model) {
        this.model = model;
    }
}

