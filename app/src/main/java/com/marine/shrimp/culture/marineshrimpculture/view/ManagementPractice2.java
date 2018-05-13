package com.marine.shrimp.culture.marineshrimpculture.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
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
import com.marine.shrimp.culture.marineshrimpculture.data.ManagementPracticeData;
import com.marine.shrimp.culture.marineshrimpculture.data.ManagementPracticeModel;

import java.util.ArrayList;
import java.util.List;

public class ManagementPractice2 extends AppCompatActivity implements View.OnClickListener{

    private ImageView image;
    private TextView title, description;
    private ImageButton next, previous, nextImage, previousImage;
    private LinearLayout linearLayout;
    private ConstraintLayout constraintLayout;
    private ScrollView scrollView;
    private ManagementPracticeData managementPracticeData;
    private ArrayList<ManagementPracticeModel> data = new ArrayList<>();
    private int positionCounter = 0, numberOfImages = 0,imageCounter = 1, numberOfPages=0, counter=0, position ;
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_practice2);

        image = findViewById(R.id.management_practice_img);
        title = findViewById(R.id.management_practice_title_tv);
        description = findViewById(R.id.management_practice_description_tv);
        next = findViewById(R.id.management_next_btn);
        previous = findViewById(R.id.management_previous_btn);
        nextImage=findViewById(R.id.image_next);
        previousImage=findViewById(R.id.image_previous);
        linearLayout=findViewById(R.id.management_linearlayout);
        constraintLayout= findViewById(R.id.image_buttons);
        scrollView=findViewById(R.id.management_scrollview);

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

        managementPracticeData = new ManagementPracticeData(ManagementPractice2.this);
        data= managementPracticeData.CreateList();

        Bundle extras = getIntent().getExtras();
        position = extras.getInt("number");
        if (position == 0 ){
            numberOfPages=3;
            linearLayout.setVisibility(View.VISIBLE);
        }
        else if (position !=0 ){
            numberOfPages=0;
            positionCounter= position;
        }

        setView(position,1, data);

        numberOfImages=data.get(position).getNumberOfImages();
        if (numberOfImages == 2 || numberOfImages == 3){
            constraintLayout.setVisibility(View.VISIBLE);
        }

        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        nextImage.setOnClickListener(this);
        previousImage.setOnClickListener(this);
    }

    public void setView (int position , int imageNumber,  ArrayList<ManagementPracticeModel> data){

        loadBitmap(position,imageNumber,data);
        title.setText(data.get(position).getTitle());
        description.setText(data.get(position).getDescription());
    }

    @Override
    public void onClick(View view) {
        if (view== next){

            if (positionCounter < numberOfPages-1){

                if (positionCounter == numberOfPages-2) {
                    next.setVisibility(View.INVISIBLE);
                    previous.setVisibility(View.VISIBLE);
                }

                positionCounter++;

                previous.setVisibility(View.VISIBLE);
                setView(positionCounter,1,data);

                numberOfImages=data.get(positionCounter).getNumberOfImages();
                if (numberOfImages == 2 || numberOfImages == 3){
                    constraintLayout.setVisibility(View.VISIBLE);
                }
                else {
                    constraintLayout.setVisibility(View.INVISIBLE);
                }
                setScrollViewPosition();
            }
        }
        else if (view== previous){

            if (positionCounter > 0){

                if(positionCounter==1){
                    previous.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }

                positionCounter--;

                next.setVisibility(View.VISIBLE);
                setView(positionCounter,1,data);

                numberOfImages=data.get(positionCounter).getNumberOfImages();
                if (numberOfImages == 2 || numberOfImages == 3){
                    constraintLayout.setVisibility(View.VISIBLE);
                }
                else {
                    constraintLayout.setVisibility(View.INVISIBLE);
                }
            }
            setScrollViewPosition();
        }
        else if(view== nextImage){

            if (numberOfImages==2){
                loadBitmap(positionCounter,2,data);
                nextImage.setVisibility(View.INVISIBLE);
                previousImage.setVisibility(View.VISIBLE);
            }
            else if(numberOfImages==3)
            {
                if(imageCounter == 1){
                    loadBitmap(positionCounter,2,data);
                    previousImage.setVisibility(View.VISIBLE);
                    imageCounter++;
                }
                else if (imageCounter ==2){
                    loadBitmap(positionCounter,3,data);
                    imageCounter++;
                    nextImage.setVisibility(View.INVISIBLE);
                    previousImage.setVisibility(View.VISIBLE);
                }
            }
        }
        else if (view==previousImage){

            if(numberOfImages==2){
                loadBitmap(positionCounter,1,data);
                previousImage.setVisibility(View.INVISIBLE);
                nextImage.setVisibility(View.VISIBLE);
            }
            else if (numberOfImages ==3){
                if(imageCounter==2){
                    loadBitmap(positionCounter,1,data);
                    imageCounter--;
                    previousImage.setVisibility(View.INVISIBLE);
                    nextImage.setVisibility(View.VISIBLE);
                }
                else if (imageCounter==3){
                    loadBitmap(positionCounter,2,data);
                    nextImage.setVisibility(View.VISIBLE);
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

    public void loadBitmap(int positionCounter,int imageNumber, List<ManagementPracticeModel> data) {
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
}
