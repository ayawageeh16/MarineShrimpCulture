package com.marine.shrimp.culture.marineshrimpculture.view;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.adapter.WeatherAdapter;
import com.marine.shrimp.culture.marineshrimpculture.utils.WeatherLoader;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.SavedWeatherModel;
import com.marine.shrimp.culture.marineshrimpculture.weatherData.WeatherContract;

import static android.widget.LinearLayout.VERTICAL;

public class SavedWeather extends AppCompatActivity {

    RecyclerView recyclerView ;
    WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_weather);
        recyclerView = findViewById(R.id.weather_rv);

        getLoaderManager().initLoader(0, null, callbacks);
        setRecyclerView(recyclerView);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                long weatherId = (long) viewHolder.itemView.getTag();
                deleteFavourite(weatherId);
                getLoaderManager().initLoader(0, null, callbacks);
            }
        }).attachToRecyclerView(recyclerView);
    }

    LoaderManager.LoaderCallbacks<Cursor> callbacks = new LoaderManager.LoaderCallbacks<Cursor>() {
        @Override
        public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
            return new WeatherLoader(SavedWeather.this);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            adapter= new WeatherAdapter(cursor, new WeatherAdapter.OnItemClickedListener() {
                @Override
                public void onItemClicked(SavedWeatherModel weather) {
                    Intent intent = new Intent(SavedWeather.this,WeatherActivity.class);
                    intent.putExtra("weather", weather);
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    };


    private void setRecyclerView (RecyclerView recyclerView){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,VERTICAL,true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }
    private void deleteFavourite(long movieId){
        String id = Long.toString(movieId);
        Uri uri = WeatherContract.WeatherEntry.CONTENT_URI;
        uri= uri.buildUpon().appendPath(id).build();
        getContentResolver().delete(uri,null,null);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }
}
