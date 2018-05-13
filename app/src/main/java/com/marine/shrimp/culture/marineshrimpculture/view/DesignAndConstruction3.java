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
import com.marine.shrimp.culture.marineshrimpculture.data.DesginAndConstructionData;
import com.marine.shrimp.culture.marineshrimpculture.data.DesignAndDestructionModel;

import java.util.ArrayList;
import java.util.List;

public class DesignAndConstruction3 extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private TextView title, description;
    private ImageButton next, previous;
    private ScrollView scrollView;
    private int positionCounter = 0, numberOfPages=0, counter=0;
    private DesginAndConstructionData desginAndConstructionData;
    private ArrayList<DesignAndDestructionModel> data = new ArrayList<>();
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_and_construction3);
        image = findViewById(R.id.design_construction_img);
        title = findViewById(R.id.design_construction_title_tv);
        description = findViewById(R.id.design_construction_description_tv);
        next = findViewById(R.id.design_construction_next_btn);
        previous = findViewById(R.id.design_construction_previous_btn);
        scrollView=findViewById(R.id.design_scrollview);

        desginAndConstructionData = new DesginAndConstructionData(DesignAndConstruction3.this);
        data = desginAndConstructionData.CreateList();

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

        Bundle extras = getIntent().getExtras();
        positionCounter = extras.getInt("number");

        if (positionCounter == 2) {
            numberOfPages = 3;
        } else if (positionCounter == 6) {
            numberOfPages = 2;
        }

        setView(positionCounter, data);
        previous.setVisibility(View.INVISIBLE);

        next.setOnClickListener(this);
        previous.setOnClickListener(this);
    }

    public void setView (int positionCounter, ArrayList<DesignAndDestructionModel> data){
        loadBitmap(positionCounter,data);
        title.setText(data.get(positionCounter).getTitle());
        description.setText(data.get(positionCounter).getDescription());
    }

    @Override
    public void onClick(View view) {
        if (view == next) {
            if (counter < numberOfPages-1) {
                if (counter == numberOfPages-2) {
                    next.setVisibility(View.INVISIBLE);
                    previous.setVisibility(View.VISIBLE);
                }
                counter++;
                positionCounter++;
                setView(positionCounter,data);
                previous.setVisibility(View.VISIBLE);
                setScrollViewPosition();
            }

        } else if (view == previous) {
            if (counter > 0) {
                if (counter == 1) {
                    previous.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }
                counter--;
                positionCounter--;
                next.setVisibility(View.VISIBLE);
                setView(positionCounter,data);
                setScrollViewPosition();
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

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            bitmapCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return (Bitmap) bitmapCache.get(key);
    }

    public void loadBitmap(int positionCounter, List<DesignAndDestructionModel> data) {

        final String imageKey = String.valueOf(data.get(positionCounter).getImage1());
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }
}

