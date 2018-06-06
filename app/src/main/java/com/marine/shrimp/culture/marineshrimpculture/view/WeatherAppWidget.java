package com.marine.shrimp.culture.marineshrimpculture.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.widget.RemoteViews;

import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.TempModel;

public class WeatherAppWidget extends AppWidgetProvider {

    public static TempModel tempModel;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                               int appWidgetId) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_app_widget);

        if( tempModel != null) {
            TempModel mainTempModel = tempModel;

            StringBuilder tempDescription = new StringBuilder();

            tempDescription.append(mainTempModel.getWeather().get(0).getDescription());

            StringBuilder sMainTemp = new StringBuilder();
            sMainTemp.append(context.getString(R.string.min))
                    .append(mainTempModel.getMain().getTempMin())
                    .append(context.getString(R.string.newLine))
                    .append(context.getString(R.string.maxlabel))
                    .append(mainTempModel.getMain().getTempMax())
                    .append(context.getString(R.string.newLine))
                    .append(context.getString(R.string.pressure))
                    .append(mainTempModel.getMain().getPressure())
                    .append(context.getString(R.string.newLine))
                    .append(context.getString(R.string.sea_level))
                    .append(mainTempModel.getMain().getSeaLevel())
                    .append(context.getString(R.string.newLine))
                    .append(context.getString(R.string.grnd_level))
                    .append(mainTempModel.getMain().getGrndLevel())
                    .append(context.getString(R.string.newLine))
                    .append(context.getString(R.string.humidity))
                    .append(mainTempModel.getMain().getHumidity());

            views.setTextViewText(R.id.description_widget, tempDescription);
            views.setTextViewText(R.id.temp_details, sMainTemp);


            // Handle click to open the selected recipe in activity
            Intent intent = new Intent(context, MainActivity.class);
            // intent.putExtra(WeatherActivity.EXTRA_WEATHER, tempModel);
            PendingIntent pendingIntent = TaskStackBuilder.create(context)
                    .addNextIntentWithParentStack(intent)
                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            PendingIntent.getActivity(context, 0, intent, 0);

            views.setOnClickPendingIntent(R.id.root_layout, pendingIntent);
        }

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);

    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    public static void updateWeathersWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
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

}

