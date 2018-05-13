package com.marine.shrimp.culture.marineshrimpculture.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.data.CommonSpeciesData;
import com.marine.shrimp.culture.marineshrimpculture.data.CommonSpeciesModel;

import java.util.ArrayList;
import java.util.List;

public class CommonSpecies extends AppCompatActivity {

    private ScrollView mainScrollView;
    private ImageView image;
    private TextView common_title_tv, common_name_tv,  common_description_tv,  common_distribution_tv,
            common_stocking_density_tv,  common_tolerance_tv, common_protein_requirement_tv,
            common_survival_tv, common_market_value_tv, common_spf_stock_tv, problem_label, common_problems_tv;
    private ImageButton previous_button , next_button;
    private LinearLayout linearLayout;
    private CommonSpeciesData commonSpeciesData  ;
    private ArrayList<CommonSpeciesModel> data = new ArrayList<>();
    private int positionCounter=0, listSize;
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_species);
        mainScrollView= findViewById(R.id.mainScrollView);
        image = findViewById(R.id.topic_img);
        common_title_tv=findViewById(R.id.common_title_tv);
        common_name_tv = findViewById(R.id.common_name_tv);
        common_description_tv = findViewById(R.id.common_description_tv);
        common_distribution_tv = findViewById(R.id.common_distribution_tv);
        common_stocking_density_tv = findViewById(R.id.common_stocking_density_tv);
        common_tolerance_tv = findViewById(R.id.common_tolerance_tv);
        common_protein_requirement_tv = findViewById(R.id.common_protein_requirement_tv);
        common_survival_tv = findViewById(R.id.common_survival_tv);
        common_market_value_tv = findViewById(R.id.common_market_value_tv);
        common_spf_stock_tv = findViewById(R.id.common_spf_stock_tv);
        common_problems_tv = findViewById(R.id.common_problems_tv);
        problem_label = findViewById(R.id.problems_label);
        previous_button = findViewById(R.id.previous_button);
        next_button = findViewById(R.id.next_button);
        linearLayout=findViewById(R.id.common_linear);


        if (savedInstanceState != null){
            data= savedInstanceState.getParcelableArrayList("data");
            positionCounter= savedInstanceState.getInt("position");
            listSize= data.size();
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            // Use 1/8th of the available memory for this memory cache.
            final int cacheSize = maxMemory / 8;
            bitmapCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    // The cache size will be measured in kilobytes rather than
                    // number of items.
                    return bitmap.getByteCount() / 1024;
                }
            };

            setView(positionCounter,data);
            if (positionCounter ==0){
                previous_button.setVisibility(View.INVISIBLE);
            }
        }
        else {
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            // Use 1/8th of the available memory for this memory cache.
            final int cacheSize = maxMemory / 8;
            bitmapCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    // The cache size will be measured in kilobytes rather than
                    // number of items.
                    return bitmap.getByteCount() / 1024;
                }
            };

            commonSpeciesData = new CommonSpeciesData(CommonSpecies.this);
            data = commonSpeciesData.createList();
            listSize = data.size();

            setView(positionCounter,data);
            if (positionCounter ==0){
                previous_button.setVisibility(View.INVISIBLE);
            }
        }
    }

    public void setView (int positionCounter, ArrayList<CommonSpeciesModel> data){
        loadBitmap(positionCounter, data);
        common_title_tv.setText(data.get(positionCounter).getTitle());
        common_name_tv.setText(data.get(positionCounter).getCommonName());
        common_description_tv.setText(data.get(positionCounter).getDescription());
        common_distribution_tv.setText(data.get(positionCounter).getDistribution());
        common_stocking_density_tv.setText(data.get(positionCounter).getStocking());
        common_tolerance_tv.setText(data.get(positionCounter).getTolerance());
        common_protein_requirement_tv.setText(data.get(positionCounter).getProtein());
        common_survival_tv.setText(data.get(positionCounter).getSurvival());
        common_market_value_tv.setText(data.get(positionCounter).getMarket());
        common_spf_stock_tv.setText(data.get(positionCounter).getSpf());

        if(data.get(positionCounter).getProblems() == ""){
            linearLayout.removeView(common_problems_tv);
            linearLayout.removeView(problem_label);
        }
        else {
            linearLayout.removeView(common_problems_tv);
            linearLayout.removeView(problem_label);
            linearLayout.addView(problem_label, 20);
            linearLayout.addView(common_problems_tv,21);
            common_problems_tv.setText(data.get(positionCounter).getProblems());
        }

    }

    public void goToPrevious(View view) {
        if (positionCounter > 0){
            if(positionCounter==1){
                previous_button.setVisibility(View.INVISIBLE);
                next_button.setVisibility(View.VISIBLE);
            }
            positionCounter--;

            setView(positionCounter,data);
            setScrollViewPosition();
        }
    }

    public void goToNext(View view) {
        if (positionCounter < listSize-1){
            if (positionCounter == listSize-2) {
                next_button.setVisibility(View.INVISIBLE);
                previous_button.setVisibility(View.VISIBLE);
            }
            positionCounter++;

            setView(positionCounter,data);
            setScrollViewPosition();
        }
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            bitmapCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return (Bitmap) bitmapCache.get(key);
    }

    public void loadBitmap(int positionCounter, List<CommonSpeciesModel> data) {

        final String imageKey = String.valueOf(data.get(positionCounter).getImage());
        final Bitmap bitmap = getBitmapFromMemCache(imageKey);

        if (bitmap != null) {
            Glide.with(this)
                    .load(bitmap)
                    .into(image);
        } else {
            Bitmap img = BitmapFactory.decodeResource(getResources(),data.get(positionCounter).getImage());
            Glide.with(this)
                    .load(img)
                    .into(image);
            addBitmapToMemoryCache(imageKey,img);
        }
    }

    void setScrollViewPosition(){
        mainScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mainScrollView.fullScroll(View.FOCUS_UP);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("position",positionCounter);
        outState.putParcelableArrayList("data",data);
        super.onSaveInstanceState(outState);
    }
}
