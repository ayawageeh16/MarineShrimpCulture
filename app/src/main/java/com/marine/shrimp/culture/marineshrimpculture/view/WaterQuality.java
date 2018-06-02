package com.marine.shrimp.culture.marineshrimpculture.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
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
import com.marine.shrimp.culture.marineshrimpculture.data.WaterQualityData;
import com.marine.shrimp.culture.marineshrimpculture.data.WaterQualityModel;

import java.util.ArrayList;
import java.util.List;

public class WaterQuality extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private TextView title, description;
    private ConstraintLayout constraintLayout;
    private ImageButton nextButton, previousButton, imageNext, imagePrevious;
    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private ArrayList<WaterQualityModel> data = new ArrayList<>();
    private WaterQualityData waterQualityData ;
    private int    positionCounter = 0, imageCounter = 1,numberOfImages = 0, listSize;
    private LruCache bitmapCache ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_quality);

        image = findViewById(R.id.img);
        title = findViewById(R.id.title_tv);
        description = findViewById(R.id.description_tv);
        constraintLayout = findViewById(R.id.image_buttons);
        nextButton = findViewById(R.id.water_next_btn);
        previousButton = findViewById(R.id.water_previous_btn);
        imageNext = findViewById(R.id.image_next);
        imagePrevious = findViewById(R.id.image_previous);
        linearLayout =findViewById(R.id.water_linearlayout);
        scrollView=findViewById(R.id.waterquality_scrollview);

        waterQualityData = new WaterQualityData(this);
        data = waterQualityData.createList();
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

        loadBitmap(positionCounter, 1, data);
        title.setText(data.get(positionCounter).getTitle());
        description.setText(data.get(positionCounter).getDescription());
        numberOfImages = data.get(positionCounter).getImageNumber();
        if (numberOfImages == 0 || numberOfImages == 1) {
            constraintLayout.setVisibility(View.INVISIBLE);
        } else {
            constraintLayout.setVisibility(View.VISIBLE);
        }

        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
        imageNext.setOnClickListener(this);
        imagePrevious.setOnClickListener(this);
        previousButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        if (view== nextButton){
            imagePrevious.setVisibility(View.INVISIBLE);
            if (positionCounter < listSize-1){

                if (positionCounter == listSize-2) {
                    nextButton.setVisibility(View.INVISIBLE);
                    previousButton.setVisibility(View.VISIBLE);
                }
                positionCounter++;

                previousButton.setVisibility(View.VISIBLE);
                title.setText(data.get(positionCounter).getTitle());
                if (data.get(positionCounter).getDescription().equals("")){
                    linearLayout.removeView(description);
                }else {
                    linearLayout.removeView(description);
                    linearLayout.addView(description,3);
                    description.setText(data.get(positionCounter).getDescription());
                }
                if(data.get(positionCounter).getImage1() == 0){
                    image.setVisibility(View.INVISIBLE);
                    constraintLayout.setVisibility(View.INVISIBLE);
                }else {
                    image.setVisibility(View.VISIBLE);
                    numberOfImages=data.get(positionCounter).getImageNumber();
                    if (numberOfImages ==1) {
                        constraintLayout.setVisibility(View.INVISIBLE);
                    }else {
                        constraintLayout.setVisibility(View.VISIBLE);
                        imageNext.setVisibility(View.VISIBLE);
                        imagePrevious.setVisibility(View.INVISIBLE);
                    }

                    loadBitmap(positionCounter,1,data);
                }
                setScrollViewPosition();
            }
        }
        else if (view== previousButton){
            imageNext.setVisibility(View.VISIBLE);
            if (positionCounter > 0){

                if(positionCounter ==1){
                    previousButton.setVisibility(View.INVISIBLE);
                    nextButton.setVisibility(View.VISIBLE);
                }

                positionCounter--;
                nextButton.setVisibility(View.VISIBLE);
                previousButton.setVisibility(View.VISIBLE);
                title.setText(data.get(positionCounter).getTitle());
                if (data.get(positionCounter).getDescription() == ""){
                    linearLayout.removeView(description);
                }else {
                    linearLayout.removeView(description);
                    linearLayout.addView(description,3);
                    description.setText(data.get(positionCounter).getDescription());
                }
                if(data.get(positionCounter).getImage1() == 0){
                    image.setVisibility(View.INVISIBLE);
                    constraintLayout.setVisibility(View.INVISIBLE);
                }else {
                    image.setVisibility(View.VISIBLE);
                    numberOfImages = data.get(positionCounter).getImageNumber();
                    if ( numberOfImages == 1) {
                        constraintLayout.setVisibility(View.INVISIBLE);
                    } else {
                        constraintLayout.setVisibility(View.VISIBLE);
                        imageNext.setVisibility(View.VISIBLE);
                        imagePrevious.setVisibility(View.INVISIBLE);
                    }

                    loadBitmap(positionCounter,1,data);
                }
                setScrollViewPosition();
            }
        }
        else if(view==imageNext){

            if (numberOfImages==2){

                loadBitmap(positionCounter,2,data);
                imageNext.setVisibility(View.INVISIBLE);
                imagePrevious.setVisibility(View.VISIBLE);
            }
            else if(numberOfImages==3)
            {
                if(imageCounter == 1){

                    loadBitmap(positionCounter,2,data);
                    imagePrevious.setVisibility(View.VISIBLE);
                    imageCounter++;
                }
                else if (imageCounter ==2){

                    loadBitmap(positionCounter,3,data);
                    imageCounter++;
                    imageNext.setVisibility(View.INVISIBLE);
                    imagePrevious.setVisibility(View.VISIBLE);
                }
            }
        }
        else if (view==imagePrevious){

            if(numberOfImages==2){

                loadBitmap(positionCounter,1,data);
                imagePrevious.setVisibility(View.INVISIBLE);
                imageNext.setVisibility(View.VISIBLE);
            }
            else if (numberOfImages ==3){
                if(imageCounter==2){

                    loadBitmap(positionCounter,1,data);
                    imageCounter--;
                    imagePrevious.setVisibility(View.INVISIBLE);
                    imageNext.setVisibility(View.VISIBLE);
                }
                else if (imageCounter==3){

                    loadBitmap(positionCounter,2,data);
                    imageNext.setVisibility(View.VISIBLE);
                    imageCounter--;
                }
            }
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

    public void loadBitmap(int positionCounter,int imageNumber, List<WaterQualityModel> data) {
        String imageKey ;

        if (imageNumber ==1){
            imageKey = String.valueOf(data.get(positionCounter).getImage1());
            final Bitmap bitmap = getBitmapFromMemCache(imageKey);

            if (bitmap != null) {
                Glide.with(this)
                        .load(bitmap)
                        .into(image);
            } else {
                Bitmap img = BitmapFactory.decodeResource(getResources(),data.get(positionCounter).getImage1());
                Glide.with(this)
                        .load(img)
                        .into(image);
                addBitmapToMemoryCache(imageKey,img);
            }
        }else if (imageNumber ==2){
            imageKey = String.valueOf(data.get(positionCounter).getImage2());
            final Bitmap bitmap = getBitmapFromMemCache(imageKey);

            if (bitmap != null) {
                Glide.with(this)
                        .load(bitmap)
                        .into(image);
            } else {
                Bitmap img = BitmapFactory.decodeResource(getResources(),data.get(positionCounter).getImage2());
                Glide.with(this)
                        .load(img)
                        .into(image);
                addBitmapToMemoryCache(imageKey,img);
            }
        }else if (imageNumber == 3) {
            imageKey = String.valueOf(data.get(positionCounter).getImage3());
            final Bitmap bitmap = getBitmapFromMemCache(imageKey);

            if (bitmap != null) {
                Glide.with(this)
                        .load(bitmap)
                        .into(image);
            } else {
                Bitmap img = BitmapFactory.decodeResource(getResources(),data.get(positionCounter).getImage3());
                Glide.with(this)
                        .load(img)
                        .into(image);
                addBitmapToMemoryCache(imageKey,img);
            }
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
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }

}
