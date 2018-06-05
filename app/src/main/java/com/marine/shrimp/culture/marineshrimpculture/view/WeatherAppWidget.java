package com.marine.shrimp.culture.marineshrimpculture.view;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.RemoteViews;

import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.utils.WeatherWidgetService;
import com.marine.shrimp.culture.marineshrimpculture.view.WeatherActivity;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.MainTempModel;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.TempModel;

public class WeatherAppWidget extends AppWidgetProvider {

    public static TempModel tempModel;
    public static final String ACTION_TEXT_CHANGED = "com.marine.shrimp.culture.marineshrimpculture.TEXT_CHANGED";
    public static String s;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                               int appWidgetId) {
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.weather_app_widget);

        if( tempModel != null) {

            MainTempModel mainTempModel = tempModel.getMain();
            StringBuilder sMainTemp = new StringBuilder();

            sMainTemp.append("min: ")
                    .append(mainTempModel.getTempMin())
                    .append("\n")
                    .append("max: ")
                    .append(mainTempModel.getTempMax())
                    .append("\n")
                    .append("pressure: ")
                    .append(mainTempModel.getPressure())
                    .append("\n")
                    .append("sea level: ")
                    .append(mainTempModel.getSeaLevel())
                    .append("\n")
                    .append("grnd_level: ")
                    .append(mainTempModel.getGrndLevel())
                    .append("\n")
                    .append("humidity: ")
                    .append(mainTempModel.getHumidity());

            views.setTextViewText(R.id.description_widget, sMainTemp);


            // Handle click to open the selected recipe in activity
            Intent intent = new Intent(context, WeatherActivity.class);
            intent.putExtra(WeatherActivity.EXTRA_WEATHER, tempModel);
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
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals(ACTION_TEXT_CHANGED)) {
            // handle intent here
            s = intent.getStringExtra("NewString");
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
       // WeatherWidgetService.startActionUpdateWidget(context);
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    public static void updateWeathersWidget(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

   /* public static void updatePlantWidgets(Context context, AppWidgetManager appWidgetManager,
                                          TempModel model, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, model, appWidgetId);
            Log.d("HEY HEY HEY WIDGET",model.toString());
        }
    }*/

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

}

