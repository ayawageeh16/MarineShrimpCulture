package com.marine.shrimp.culture.marineshrimpculture.view;

import android.content.res.Resources;
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
import com.marine.shrimp.culture.marineshrimpculture.data.HarvestAndPostHarvestData;
import com.marine.shrimp.culture.marineshrimpculture.data.HarvestAndPostHarvestModel;

import java.util.ArrayList;
import java.util.List;

public class HarvestAndPostHarvest2 extends AppCompatActivity implements View.OnClickListener {

    private ImageView image;
    private TextView title, description;
    private ImageButton next, previous, nextImage, previousImage;
    private LinearLayout linearLayout;
    private ScrollView scrollView;
    private ConstraintLayout constraintLayout;
    private HarvestAndPostHarvestData harvestAndPostHarvestData;
    private ArrayList<HarvestAndPostHarvestModel> data = new ArrayList<>();
    private int numberOfImages = 0, numberOfPages=0, counter=0, position ;
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_and_post_harvest2);

        image = findViewById(R.id.harvest_img);
        title = findViewById(R.id.harvest_title_tv);
        description = findViewById(R.id.harvest_description_tv);
        next = findViewById(R.id.harvest_next_btn);
        previous = findViewById(R.id.harvest_previous_btn);
        nextImage=findViewById(R.id.image_next);
        previousImage=findViewById(R.id.image_previous);
        linearLayout=findViewById(R.id.harvest_linearlayout);
        constraintLayout= findViewById(R.id.image_buttons);
        scrollView=findViewById(R.id.harvest_scrollview);

        harvestAndPostHarvestData = new HarvestAndPostHarvestData(HarvestAndPostHarvest2.this);
        data= harvestAndPostHarvestData.CreateList();

        Bundle extras = getIntent().getExtras();
        position = extras.getInt("number");
        if (position == 0 ){
            numberOfPages=3;
            linearLayout.setVisibility(View.VISIBLE);
        }
        else if (position == 3) {
            numberOfPages=4;
            linearLayout.setVisibility(View.VISIBLE);
        }else {
            linearLayout.setVisibility(View.INVISIBLE);
        }

        if (position == 0 || position == 3 || position == 7 || position == 8){
            previous.setVisibility(View.INVISIBLE);
        }

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

        setView(position,data);


        numberOfImages=data.get(position).getNumberOfImages();
        if (numberOfImages == 2 ){
            constraintLayout.setVisibility(View.VISIBLE);
        }


        next.setOnClickListener(this);
        previous.setOnClickListener(this);
        nextImage.setOnClickListener(this);
        previousImage.setOnClickListener(this);
    }


    public void  setView (int position, ArrayList<HarvestAndPostHarvestModel> data){

        loadBitmap(position, 1, data);
        title.setText(data.get(position).getTitle());
        description.setText(data.get(position).getDescription());
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
                position++;
                numberOfImages= data.get(position).getNumberOfImages();
                if (numberOfImages == 2 ){
                    constraintLayout.setVisibility(View.VISIBLE);
                }
                setView(position,data);
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
                position--;
                next.setVisibility(View.VISIBLE);
                setView(position,data);
                setScrollViewPosition();
            }
        }
        else if(view==nextImage){
            numberOfImages = data.get(position).getNumberOfImages();
            if (numberOfImages==2){
                loadBitmap(position,2,data);
                nextImage.setVisibility(View.INVISIBLE);
                previousImage.setVisibility(View.VISIBLE);
            }
        }
        else if (view==previousImage) {
            if (numberOfImages == 2) {
                loadBitmap(position,1,data);
                previousImage.setVisibility(View.INVISIBLE);
                nextImage.setVisibility(View.VISIBLE);
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

    public void loadBitmap(int positionCounter, int imageNumber,  List<HarvestAndPostHarvestModel> data) {

        String imageKey;

        if (imageNumber == 1) {
            imageKey = String.valueOf(data.get(positionCounter).getImage1());
            final Bitmap bitmap = getBitmapFromMemCache(imageKey);

            if (bitmap != null) {
                Glide.with(this)
                        .load(bitmap)
                        .into(image);
            } else {
                Bitmap img = BitmapFactory.decodeResource(getResources(), data.get(positionCounter).getImage1());
                Glide.with(this)
                        .load(img)
                        .into(image);
                addBitmapToMemoryCache(imageKey, img);
            }
        } else if (imageNumber == 2) {
            imageKey = String.valueOf(data.get(positionCounter).getImage2());
            final Bitmap bitmap = getBitmapFromMemCache(imageKey);

            if (bitmap != null) {
                Glide.with(this)
                        .load(bitmap)
                        .into(image);
            } else {
                Bitmap img = BitmapFactory.decodeResource(getResources(), data.get(positionCounter).getImage2());
                Glide.with(this)
                        .load(img)
                        .into(image);
                addBitmapToMemoryCache(imageKey, img);
            }
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);


        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 2;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }
}
