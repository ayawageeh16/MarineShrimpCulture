package com.marine.shrimp.culture.marineshrimpculture.utils;

import android.Manifest;
import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marine.shrimp.culture.marineshrimpculture.view.WeatherAppWidget;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.TempModel;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class WeatherWidgetService extends IntentService{


    public static final String ACTION_UPDATE_WIDGET = "com.marine.shrimp.culture.marineshrimpculture.action.update.widget";
    private final static StringBuilder API = new StringBuilder("&appid=a672aedf129676161fc4d392a8877853&units=Metric");
    private final static StringBuilder MAINAPI = new StringBuilder("http://api.openweathermap.org/data/2.5/weather?");
    LocationManager locationManager;
    double longitude, latitude;
    private LocationRequest mLocationRequest;
    private long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 2000; /* 2 sec */

    private RequestQueue requestQueue;
    private Gson gson;
    TempModel model;


    public WeatherWidgetService(String name) {
        super(name);
    }

    public static void startActionUpdateWidget(Context context) {
        Intent intent = new Intent(context, WeatherWidgetService.class);
        intent.setAction(ACTION_UPDATE_WIDGET );
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_UPDATE_WIDGET.equals(action)) {
                handleActionUpdateWeatherWidgets();
            }
        }
    }

    private void getJsonData() {
        MAINAPI.append("lat=");
        MAINAPI.append(String.valueOf(latitude));
        MAINAPI.append("&lon=");
        MAINAPI.append(String.valueOf(longitude));
        MAINAPI.append(API);
        StringRequest request = new StringRequest(Request.Method.GET, MAINAPI.toString(), onWeatherLoaded, onPostsError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onWeatherLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            final TempModel tempModel = gson.fromJson(response, TempModel.class);
            model=tempModel;
        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
        }
    };

    // Trigger new location updates at interval
    protected void startLocationUpdates() {

        // Create the location request to start receiving updates
        mLocationRequest = new LocationRequest().create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);

        // Create LocationSettingsRequest object using location request
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        LocationSettingsRequest locationSettingsRequest = builder.build();

        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest);

        // new Google API SDK v11 uses getFusedLocationProviderClient(this)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        getFusedLocationProviderClient(this).requestLocationUpdates(mLocationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        onLocationChanged(locationResult.getLastLocation());
                    }
                },
                Looper.myLooper());
    }

    public void onLocationChanged(Location location) {
        // New location has now been determined
        latitude=location.getLatitude();
        longitude=location.getLongitude();
    }


    private void handleActionUpdateWeatherWidgets() {

        startLocationUpdates();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        requestQueue = Volley.newRequestQueue(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        getJsonData();

      /*  AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(WeatherWidgetService.this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(WeatherWidgetService.this, WeatherAppWidget.class));
        //Now update all widgets
        WeatherAppWidget.updatePlantWidgets(WeatherWidgetService.this, appWidgetManager,model,appWidgetIds);*/
    }
}