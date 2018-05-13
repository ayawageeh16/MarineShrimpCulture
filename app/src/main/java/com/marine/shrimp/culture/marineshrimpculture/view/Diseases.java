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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.data.DiseasesAndViralDiseaseData;
import com.marine.shrimp.culture.marineshrimpculture.data.DiseasesAndViralDiseaseModel;

import java.util.ArrayList;
import java.util.List;

public class Diseases extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private ImageButton next, previous;
    private TextView title, summery, title1, description1, title2, description2, title3, description3;
    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private DiseasesAndViralDiseaseData diseasesAndViralDiseaseData;
    private List<DiseasesAndViralDiseaseModel> data = new ArrayList<>();
    private int numberOfPages = 0, counter = 0, position;
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        image = findViewById(R.id.diseases_img);
        next = findViewById(R.id.diseases_next_btn);
        previous = findViewById(R.id.diseases_previous_btn);
        title = findViewById(R.id.diseases_title_tv);
        summery = findViewById(R.id.diseases_summery_tv);
        title1 = findViewById(R.id.diseases_title1_tv);
        description1 = findViewById(R.id.diseases_description1_tv);
        title2 = findViewById(R.id.diseases_title2_tv);
        description2 = findViewById(R.id.diseases_description2_tv);
        title3 = findViewById(R.id.diseases_title3_tv);
        description3 = findViewById(R.id.diseases_description3_tv);
        linearLayout=findViewById(R.id.diseases_linearlayout1);
        scrollView=findViewById(R.id.diseases_scrollview);

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

        diseasesAndViralDiseaseData = new DiseasesAndViralDiseaseData(Diseases.this);
        data = diseasesAndViralDiseaseData.createList();

        Bundle extras = getIntent().getExtras();
        position = extras.getInt("number");
        if (position == 0) {
            numberOfPages = 3;
        } else if (position == 3) {
            numberOfPages = 5;
        } else if (position == 8){
            numberOfPages = 9;
        }

        loadBitmap(position,data);
        title.setText(data.get(position).getTitle());
        previous.setVisibility(View.INVISIBLE);
        if(data.get(position).getSummary().equals("")){
            linearLayout.removeView(summery);
        }else {
            summery.setText(data.get(position).getSummary());
        }
        title1.setText(data.get(position).getTitle1());
        description1.setText(data.get(position).getDescription1());
        title2.setText(data.get(position).getTitle2());
        description2.setText(data.get(position).getDescription2());
        if(data.get(position).getTitle3().equals("")){
            linearLayout.removeView(title3);
            linearLayout.removeView(description3);

        }else {
            title3.setText(data.get(position).getTitle3());
            description3.setText(data.get(position).getDescription3());
        }
        next.setOnClickListener(this);
        previous.setOnClickListener(this);

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
                loadBitmap(position,data);
                title.setText(data.get(position).getTitle());
                if(data.get(position).getSummary().equals("")){
                    linearLayout.removeView(summery);
                    title1.setText(data.get(position).getTitle1());
                    description1.setText(data.get(position).getDescription1());
                    title2.setText(data.get(position).getTitle2());
                    description2.setText(data.get(position).getDescription2());
                    if(data.get(position).getTitle3().equals("")){
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                    }else {
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                        linearLayout.addView(title3,6);
                        linearLayout.addView(description3,7);
                        title3.setText(data.get(position).getTitle3());
                        description3.setText(data.get(position).getDescription3());
                    }
                }else {
                    linearLayout.removeView(summery);
                    linearLayout.addView(summery);
                    summery.setText(data.get(position).getSummary());

                    title1.setText(data.get(position).getTitle1());
                    description1.setText(data.get(position).getDescription1());
                    title2.setText(data.get(position).getTitle2());
                    description2.setText(data.get(position).getDescription2());
                    if (data.get(position).getTitle3().equals("")) {
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                    } else {
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                        linearLayout.addView(title3, 7);
                        linearLayout.addView(description3, 8);
                        title3.setText(data.get(position).getTitle3());
                        description3.setText(data.get(position).getDescription3());
                    }
                }
                setScrollViewPosition();
            }

        } else if (view == previous) {
            if (counter > 0) {
                if (counter == 1) {
                    previous.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                    linearLayout.removeView(summery);
                }
                counter--;
                position--;
                next.setVisibility(View.VISIBLE);
                loadBitmap(position,data);
                title.setText(data.get(position).getTitle());
                if(data.get(position).getSummary().equals("")){
                    linearLayout.removeView(summery);title1.setText(data.get(position).getTitle1());
                    description1.setText(data.get(position).getDescription1());
                    title2.setText(data.get(position).getTitle2());
                    description2.setText(data.get(position).getDescription2());
                    if(data.get(position).getTitle3().equals("")){
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                    }else {
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                        linearLayout.addView(title3,6);
                        linearLayout.addView(description3,7);
                        title3.setText(data.get(position).getTitle3());
                        description3.setText(data.get(position).getDescription3());
                    }

                }else {
                    linearLayout.removeView(summery);
                    linearLayout.addView(summery,2);
                    summery.setText(data.get(position).getSummary());

                    title1.setText(data.get(position).getTitle1());
                    description1.setText(data.get(position).getDescription1());
                    title2.setText(data.get(position).getTitle2());
                    description2.setText(data.get(position).getDescription2());
                    if(data.get(position).getTitle3().equals("")){
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                    }else {
                        linearLayout.removeView(title3);
                        linearLayout.removeView(description3);
                        linearLayout.addView(title3,7);
                        linearLayout.addView(description3,8);
                        title3.setText(data.get(position).getTitle3());
                        description3.setText(data.get(position).getDescription3());
                    }
                }
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
