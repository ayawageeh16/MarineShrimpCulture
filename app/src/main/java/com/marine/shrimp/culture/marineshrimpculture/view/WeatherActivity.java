package com.marine.shrimp.culture.marineshrimpculture.view;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.android.gms.location.LocationCallback;

import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.utils.WeatherDataInterface;
import com.marine.shrimp.culture.marineshrimpculture.utils.WeatherUtils;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.SavedWeatherModel;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.TempModel;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.WeatherContentProvider;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.WeatherContract;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class WeatherActivity extends AppCompatActivity {

    private final static StringBuilder API = new StringBuilder("&appid=a672aedf129676161fc4d392a8877853&units=Metric");
    private final static StringBuilder MAINAPI = new StringBuilder("http://api.openweathermap.org/data/2.5/weather?");

    LocationManager locationManager;
    double longitude, latitude;

    private RequestQueue requestQueue;
    private Gson gson;
    String currentWeather;
    WeatherUtils weatherUtils;
    TempModel weatherModel;
    String currentDate;
    String currentTime;

    private LocationRequest mLocationRequest;
    private long UPDATE_INTERVAL = 10 * 1000;  /* 10 secs */
    private long FASTEST_INTERVAL = 2000; /* 2 sec */

    ScrollView mainLyout;
    TextView date, time, description, temp_max, temp_min, humidity, sea_level, grnd_level, wind_speed, wind_degree, wind, pressure;
    ImageView icon;
    ImageButton saveWeather;
    SavedWeatherModel savedWeatherModel;
    EditWidgetListener listener;


    public interface EditWidgetListener {
        void updateResult(TempModel model);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mainLyout = findViewById(R.id.weather_main_layout);
        date = findViewById(R.id.weather_date);
        time =findViewById(R.id.weather_time);
        description = findViewById(R.id.weather_description_tv);
        temp_max = findViewById(R.id.temp_max_tv);
        temp_min = findViewById(R.id.temp_min_tv);
        humidity = findViewById(R.id.weather_humidity_tv);
        sea_level = findViewById(R.id.weather_sea_level_tv);
        grnd_level = findViewById(R.id.weather_grnd_level_tv);
        wind_speed = findViewById(R.id.wind_speed_tv);
        wind_degree = findViewById(R.id.wind_degree_tv);
        wind = findViewById(R.id.wind_tv);
        pressure = findViewById(R.id.clouds_tv);
        icon = findViewById(R.id.weather_icon);
        saveWeather = findViewById(R.id.save_weather);

        Intent i = getIntent();
        savedWeatherModel =i.getParcelableExtra("weather");

        if (savedWeatherModel != null){
            getCurrentTime();
            getDate();
            setView(savedWeatherModel,currentDate,currentTime);
        }else  {
            weatherUtils = new WeatherUtils();
            startLocationUpdates();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gson = gsonBuilder.create();
            requestQueue = Volley.newRequestQueue(this);
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            if (isConnected()) {
                getJsonData();
            } else {
                Snackbar snackbar = Snackbar
                        .make(mainLyout, R.string.no_internet_connection, Snackbar.LENGTH_LONG)
                        .setAction(R.string.Retry, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                getJsonData();
                            }
                        });
                snackbar.show();
            }
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, currentWeather + "\n" + R.string.app_hashtag);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }

    private Boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        Boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
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

    public void getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        currentTime =  mdformat.format(calendar.getTime());
    }

    public void  getDate (){
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        currentDate = df.format(c);
    }


    private final Response.Listener<String> onWeatherLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            final TempModel tempModel = gson.fromJson(response, TempModel.class);
            if (tempModel != null) {
                getCurrentTime();
                getDate();
                setView(tempModel, currentDate, currentTime);
               // listener.updateResult(tempModel);
            } else {
                Toast.makeText(WeatherActivity.this, "null", Toast.LENGTH_LONG).show();
            }
        }
    };

    private void setView(TempModel tempModel, String currentDate, String currentTime) {
        weatherModel = tempModel;

        boolean check = checkIfExists(weatherModel.getWeather().get(0).getId());
        if (check == true) {
            saveWeather.setImageResource(R.drawable.ic_saveclicked);
        } else {
            saveWeather.setImageResource(R.drawable.ic_save);
        }
        date.setText(currentDate);
        time.setText(currentTime);
        temp_max.setText(String.valueOf(tempModel.getMain().getTempMax()) +"°");
        temp_min.setText(String.valueOf(tempModel.getMain().getTempMin()) +"°");
        description.setText(tempModel.getWeather().get(0).getDescription());
        humidity.setText("Humidity: \t"+ String.valueOf(tempModel.getMain().getHumidity()));
        if (String.valueOf(tempModel.getMain().getSeaLevel()).equals(null)) {
            sea_level.setText("Sea level: \t"+ " Not Predicted! ");
        } else {
            sea_level.setText("Sea level: \t"+ String.valueOf(tempModel.getMain().getSeaLevel()));
        }

        if (String.valueOf(tempModel.getMain().getGrndLevel()).equals(null)) {
            grnd_level.setText("Grnd level: \t"+ R.string.not_predicted);
        } else {
            grnd_level.setText("Grnd level: \t"+ String.valueOf(tempModel.getMain().getGrndLevel()));
        }
        wind_speed.setText("Wind speed: \t"+ String.valueOf(tempModel.getWind().getSpeed()));
        wind_degree.setText("Wind degree: \t"+ String.valueOf(tempModel.getWind().getDeg()));
        wind.setText("Wind: \t" + String.valueOf(WeatherUtils.getFormattedWind(this, tempModel.getWind().getSpeed(), tempModel.getWind().getDeg())));
        pressure.setText("Pressure: \t"+ String.valueOf(tempModel.getMain().getPressure()));
        //Bitmap img = BitmapFactory.decodeResource(getResources(), WeatherUtils.getResourceIdForWeatherCondition(tempModel.getId()));
        String iconCode = tempModel.getWeather().get(0).getIcon();
        StringBuilder iconUri = new StringBuilder("http://openweathermap.org/img/w/");
        iconUri.append(iconCode);
        iconUri.append(".png");
        Glide.with(this)
                .load(iconUri.toString())
                .into(icon);
    }

    private void setView(SavedWeatherModel savedWeatherModel, String currentDate, String currentTime) {

        boolean check = checkIfExists((int) savedWeatherModel.getId());
        if (check == true) {
            saveWeather.setImageResource(R.drawable.ic_saveclicked);
        } else {
            saveWeather.setImageResource(R.drawable.ic_save);
        }
        date.setText(currentDate);
        time.setText(currentTime);
        temp_max.setText(String.valueOf(savedWeatherModel.getWeatherTempMax()));
        temp_min.setText(String.valueOf(savedWeatherModel.getWeatherTempMin()));
        description.setText(savedWeatherModel.getWeatherDescription());
        humidity.setText(savedWeatherModel.getWeatherHumidity());
        if (savedWeatherModel.getWeatherSeaLevel().equals(null)) {
            sea_level.setText("Sea level: \t"+ " Not Predicted! ");
        } else {
            sea_level.setText("Sea level: \t"+ savedWeatherModel.getWeatherSeaLevel());
        }

        if (savedWeatherModel.getWeatherGrndLevel().equals(null)) {
            grnd_level.setText("Grnd level: \t"+ R.string.not_predicted);
        } else {
            grnd_level.setText("Grnd level: \t"+ savedWeatherModel.getWeatherGrndLevel());
        }
        wind_speed.setText("Wind speed: \t"+ savedWeatherModel.getWeatherWindSpeed());
        wind_degree.setText("Wind degree: \t"+ savedWeatherModel.getWeatherWindDegree());
       // wind.setText("Wind: \t" + String.valueOf(WeatherUtils.getFormattedWind(this, tempModel.getWind().getSpeed(), tempModel.getWind().getDeg())));
        pressure.setText("Pressure: \t"+ savedWeatherModel.getWeatherPressure());
        //Bitmap img = BitmapFactory.decodeResource(getResources(), WeatherUtils.getResourceIdForWeatherCondition(tempModel.getId()));
        String iconCode = savedWeatherModel.getWeatherIcon();
        StringBuilder iconUri = new StringBuilder("http://openweathermap.org/img/w/");
        iconUri.append(iconCode);
        iconUri.append(".png");
        Glide.with(this)
                .load(iconUri.toString())
                .into(icon);
    }

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Snackbar snackbar = Snackbar
                    .make(mainLyout, R.string.no_internet_connection, Snackbar.LENGTH_LONG)
                    .setAction(R.string.Retry, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            getJsonData();
                        }
                    });

            snackbar.show();
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

    public void saveWeather(View view) {

        ContentValues values = new ContentValues();
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_ID, weatherModel.getWeather().get(0).getId() );
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_DATE, currentDate.toString());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_TIME, currentTime.toString());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_DESCRIPTION, weatherModel.getWeather().get(0).getDescription());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_ICON, weatherModel.getWeather().get(0).getIcon());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_PRESSURE, weatherModel.getMain().getPressure());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_HUMIDITY, weatherModel.getMain().getHumidity());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_TEMP_MAX, weatherModel.getMain().getTempMax());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_TEMP_MIN, weatherModel.getMain().getTempMin());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_SEA_LEVEL, weatherModel.getMain().getSeaLevel());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_GRND_LEVEL, weatherModel.getMain().getGrndLevel());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_WIND_SPEED, weatherModel.getWind().getSpeed());
        values.put(WeatherContract.WeatherEntry.COLUMN_WEATHER_WIND_DEGREE, weatherModel.getWind().getDeg());

        boolean check = checkIfExists(weatherModel.getWeather().get(0).getId());
        if (check == true) {
            deleteWeather(weatherModel.getWeather().get(0).getId());
            saveWeather.setImageResource(R.drawable.ic_save);
        } else {
            Uri uri = getContentResolver().insert(WeatherContract.WeatherEntry.CONTENT_URI, values);
            if (uri != null) {
                saveWeather.setImageResource(R.drawable.ic_saveclicked);
            } else {
                Toast.makeText(this, "failed", Toast.LENGTH_LONG).show();
            }}}


    private boolean checkIfExists(int movieId) {
        String id = String.valueOf(movieId);
        Uri queryUri = WeatherContract.WeatherEntry.CONTENT_URI.buildUpon().appendPath(id).build();
        Cursor cursor = getContentResolver().query(queryUri,
                null,
                null,
                null,
                null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int returnedId = cursor.getInt(cursor.getColumnIndex(WeatherContract.WeatherEntry.COLUMN_WEATHER_ID));
                if (movieId == returnedId) {
                    cursor.close();
                    return true;
                }}}
        return false;
    }

    private void deleteWeather(int weatherId) {
        String id = Long.toString(weatherId);
        Uri uri = WeatherContract.WeatherEntry.CONTENT_URI;
        uri = uri.buildUpon().appendPath(id).build();
        getContentResolver().delete(uri, null, null);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }
}