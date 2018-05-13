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
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.data.KnowYourShrimpData;
import com.marine.shrimp.culture.marineshrimpculture.data.KnowYourShrimpModel;

import java.util.ArrayList;
import java.util.List;

public class KnowYourShrimp extends AppCompatActivity {

    private ImageView image;
    private TextView description;
    private ArrayList<KnowYourShrimpModel> data = new ArrayList<>();
    private KnowYourShrimpData knowYourShrimpData;
    private ImageButton nextButton, previousButton;
    private ScrollView scrollView;
    private int positionCounter=0,listSize;
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_your_shrimp);

        image = findViewById(R.id.topic_img);
        description = findViewById(R.id.description_tv);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.previous_button);
        scrollView=findViewById(R.id.knowyourshrimp_scrollview);

        if (savedInstanceState != null) {
            positionCounter= savedInstanceState.getInt("position");
            data=savedInstanceState.getParcelableArrayList("data");
            listSize = data.size();

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
            if(positionCounter==0) {
                previousButton.setVisibility(View.INVISIBLE);
            }

        }else {
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

            knowYourShrimpData = new KnowYourShrimpData(KnowYourShrimp.this);
            data = knowYourShrimpData.createList();
            listSize = data.size();

            setView(positionCounter, data);
            if(positionCounter==0) {
                previousButton.setVisibility(View.INVISIBLE);
            }

        }
    }

    public void setView (int positionCounter, ArrayList<KnowYourShrimpModel> data){
        loadBitmap(positionCounter, data);
        description.setText(data.get(positionCounter).getDescription());
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            bitmapCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return (Bitmap) bitmapCache.get(key);
    }

    public void loadBitmap(int positionCounter, List<KnowYourShrimpModel> data) {

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

    public void goToNext(View view) {

        if (positionCounter < listSize-1){
            if (positionCounter == listSize-2) {
                nextButton.setVisibility(View.INVISIBLE);
                previousButton.setVisibility(View.VISIBLE);
            }
            positionCounter++;
            previousButton.setVisibility(View.VISIBLE);
            setView(positionCounter,data);
            setScrollViewPosition();
        }
    }

    public void goToPrevious(View view) {

        if (positionCounter > 0){
            if(positionCounter==1){
                previousButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);
            }
            positionCounter--;
            nextButton.setVisibility(View.VISIBLE);
            setView(positionCounter,data);
            setScrollViewPosition();
        }

    }

    void setScrollViewPosition(){
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                scrollView.fullScroll(View.FOCUS_UP);
            }
        });
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("position",positionCounter);
        outState.putParcelableArrayList("data",data);
        super.onSaveInstanceState(outState);
    }
}

