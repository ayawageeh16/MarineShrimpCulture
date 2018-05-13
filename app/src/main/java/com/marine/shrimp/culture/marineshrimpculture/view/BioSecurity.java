package com.marine.shrimp.culture.marineshrimpculture.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.marine.shrimp.culture.marineshrimpculture.data.DiseasesAndViralDiseaseData;
import com.marine.shrimp.culture.marineshrimpculture.data.DiseasesAndViralDiseaseModel;

import java.util.ArrayList;
import java.util.List;

public class BioSecurity extends AppCompatActivity implements View.OnClickListener{

    private ImageView image ;
    private TextView title, summery;
    private ImageButton next, previous;
    private ScrollView scrollView;
    private List<DiseasesAndViralDiseaseModel> data = new ArrayList<>();
    private DiseasesAndViralDiseaseData diseasesAndViralDiseaseData;
    private int position;
    private int numberOfPages;
    private int counter = 0;
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_security);
        image=findViewById(R.id.biosecurity_img);
        title=findViewById(R.id.biosecurity_title_tv);
        summery=findViewById(R.id.biosecurity_summery_tv);
        next=findViewById(R.id.biosecurity_next_btn);
        previous=findViewById(R.id.biosecurity_previous_btn);
        scrollView=findViewById(R.id.biosecurity_scrollview);

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

        diseasesAndViralDiseaseData = new DiseasesAndViralDiseaseData(BioSecurity.this);
        data= diseasesAndViralDiseaseData.createList();

        Bundle extras = getIntent().getExtras();
        position = extras.getInt("number");

        if (position == 8){
            numberOfPages =9;
        }
        setView(position,data);
        previous.setVisibility(View.INVISIBLE);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    public void setView (int position, List<DiseasesAndViralDiseaseModel>data){
        loadBitmap(position,data);
        title.setText(data.get(position).getTitle());
        summery.setText(data.get(position).getSummary());
    }
    @Override
    public void onClick(View view) {

        if (view == next) {
            previous.setVisibility(View.VISIBLE);
            if (counter < numberOfPages - 1) {
                if (counter == numberOfPages - 2) {
                    next.setVisibility(View.INVISIBLE);
                    previous.setVisibility(View.VISIBLE);
                }
                counter++;
                position++;
                setView(position,data);
                setScrollViewPosition();
            }

        } else if (view == previous) {
            if (counter > 0) {
                if (counter == 1) {
                    previous.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }
                counter--;
                position--;
                next.setVisibility(View.VISIBLE);
                setView(position,data);
                setScrollViewPosition();
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

    public void loadBitmap(int positionCounter, List<DiseasesAndViralDiseaseModel> data) {

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
