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
import com.marine.shrimp.culture.marineshrimpculture.data.TraditionalAndModernData;
import com.marine.shrimp.culture.marineshrimpculture.data.TraditionalAndModernModel;

import java.util.ArrayList;
import java.util.List;

public class TraditionalAndModernShrimpCulture2 extends AppCompatActivity implements View.OnClickListener{

    private ImageView image;
    private ImageButton nextPage, previousPage, nextImage, previousImage;
    private TextView title1,title2,title3,title4,title5,description1,description2,description3,description4,description5;
    private LinearLayout ButtonslinearLayout , linearLayout ;
    private ConstraintLayout constraintLayout;
    private ScrollView scrollView;
    private List<TraditionalAndModernModel> data = new ArrayList<>();
    private TraditionalAndModernData traditionalAndModelData ;
    private int position, numberOfPages,counter=0, numberOfImages = 0, imageCounter = 1;
    private LruCache bitmapCache ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_and_modern_shrimp_culture2);

        image=findViewById(R.id.traditional_and_modern_img);
        nextPage=findViewById(R.id.traditional_and_modern_next_btn);
        previousPage=findViewById(R.id.traditional_and_modern_previous_btn);
        title1=findViewById(R.id.traditional_and_modern_title1_tv);
        title2=findViewById(R.id.traditional_and_modern_title2_tv);
        title3=findViewById(R.id.traditional_and_modern_title3_tv);
        title4=findViewById(R.id.traditional_and_modern_title4_tv);
        title5=findViewById(R.id.traditional_and_modern_title5_tv);
        description1=findViewById(R.id.traditional_and_modern_description1_tv);
        description2=findViewById(R.id.traditional_and_modern_description2_tv);
        description3=findViewById(R.id.traditional_and_modern_description3_tv);
        description4=findViewById(R.id.traditional_and_modern_description4_tv);
        description5=findViewById(R.id.traditional_and_modern_description5_tv);
        nextImage=findViewById(R.id.image_next);
        previousImage=findViewById(R.id.image_previous);
        ButtonslinearLayout =findViewById(R.id.traditional_and_modern_linearlayout);
        constraintLayout=findViewById(R.id.image_buttons);
        linearLayout=findViewById(R.id.tradiaditional_linearlayout);
        scrollView=findViewById(R.id.tradiaditional_scrollview);

        Bundle extras = getIntent().getExtras();
        position = extras.getInt("number");

        traditionalAndModelData = new TraditionalAndModernData(TraditionalAndModernShrimpCulture2.this);
        data=traditionalAndModelData.createList();

        if (position == 0){
            numberOfPages= 4;
        }else if (position == 4){
            numberOfPages=1;
            ButtonslinearLayout.setVisibility(View.INVISIBLE);
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

        loadBitmap(position,1,data);

        title1.setText(data.get(position).getTitle1());
        description1.setText(data.get(position).getDescription1());
        title2.setText(data.get(position).getTitle2());
        description2.setText(data.get(position).getDescription2());
        title3.setText(data.get(position).getTitle3());
        description3.setText(data.get(position).getDescription3());
        if(data.get(position).getTitle4().equals("")){
            linearLayout.removeView(title4);
            linearLayout.removeView(description4);
        }else{
            linearLayout.removeView(title4);
            linearLayout.removeView(description4);
            linearLayout.addView(title4,8);
            linearLayout.addView(description4,9);
            title4.setText(data.get(position).getTitle4());
            description4.setText(data.get(position).getDescription4());
        }
        if (data.get(position).getTitle5().equals("")){
            linearLayout.removeView(title5);
            linearLayout.removeView(description5);
        }else {
            linearLayout.addView(title4,10);
            linearLayout.addView(description4,11);
            linearLayout.removeView(title5);
            linearLayout.removeView(description5);
            title5.setText(data.get(position).getTitle5());
            description5.setText(data.get(position).getDescription5());
        }

        numberOfImages = data.get(position).getNumberOfImages();

        if (numberOfImages ==1){
            constraintLayout.setVisibility(View.INVISIBLE);
        }else {
            constraintLayout.setVisibility(View.VISIBLE);
        }


        nextPage.setOnClickListener(this);
        previousPage.setOnClickListener(this);
        nextImage.setOnClickListener(this);
        previousImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == nextPage) {
            nextImage.setVisibility(View.VISIBLE);
            previousImage.setVisibility(View.INVISIBLE);
            previousPage.setVisibility(View.VISIBLE);
            if (counter < numberOfPages - 1) {
                if (counter == numberOfPages - 2) {
                    nextPage.setVisibility(View.INVISIBLE);
                    previousPage.setVisibility(View.VISIBLE);
                }
                counter++;
                position++;

                numberOfImages = data.get(position).getNumberOfImages();

                if (numberOfImages ==1){
                    constraintLayout.setVisibility(View.INVISIBLE);
                }else {
                    constraintLayout.setVisibility(View.VISIBLE);
                    previousImage.setVisibility(View.INVISIBLE);
                }
                loadBitmap(position,1,data);

                title1.setText(data.get(position).getTitle1());
                description1.setText(data.get(position).getDescription1());
                title2.setText(data.get(position).getTitle2());
                description2.setText(data.get(position).getDescription2());
                title3.setText(data.get(position).getTitle3());
                description3.setText(data.get(position).getDescription3());

                if(data.get(position).getTitle4().equals("")){
                    linearLayout.removeView(title4);
                    linearLayout.removeView(description4);
                }else{
                    linearLayout.removeView(title4);
                    linearLayout.removeView(description4);
                    linearLayout.addView(title4,8);
                    linearLayout.addView(description4,9);
                    title4.setText(data.get(position).getTitle4());
                    description4.setText(data.get(position).getDescription4());
                }
                if (data.get(position).getTitle5().equals("")){
                    linearLayout.removeView(title5);
                    linearLayout.removeView(description5);
                }else {
                    linearLayout.addView(title4,10);
                    linearLayout.addView(description4,11);
                    linearLayout.removeView(title5);
                    linearLayout.removeView(description5);
                    title5.setText(data.get(position).getTitle5());
                    description5.setText(data.get(position).getDescription5());
                }
                setScrollViewPosition();
            }
        }else if (view == previousPage) {
            if (counter > 0) {
                nextImage.setVisibility(View.VISIBLE);
                if (counter == 1) {
                    previousPage.setVisibility(View.INVISIBLE);
                    nextPage.setVisibility(View.VISIBLE);

                }
                counter--;
                position--;

                numberOfImages = data.get(position).getNumberOfImages();

                if (numberOfImages ==1){
                    constraintLayout.setVisibility(View.INVISIBLE);
                }else {
                    constraintLayout.setVisibility(View.VISIBLE);
                    previousImage.setVisibility(View.INVISIBLE);
                }
                loadBitmap(position,1,data);

                title1.setText(data.get(position).getTitle1());
                description1.setText(data.get(position).getDescription1());
                title2.setText(data.get(position).getTitle2());
                description2.setText(data.get(position).getDescription2());
                title3.setText(data.get(position).getTitle3());
                description3.setText(data.get(position).getDescription3());
                if(data.get(position).getTitle4().equals("")){
                    linearLayout.removeView(title4);
                    linearLayout.removeView(description4);
                }else{
                    linearLayout.removeView(title4);
                    linearLayout.removeView(description4);
                    linearLayout.addView(title4,8);
                    linearLayout.addView(description4,9);
                    title4.setText(data.get(position).getTitle4());
                    description4.setText(data.get(position).getDescription4());
                }
                if (data.get(position).getTitle5().equals("")){
                    linearLayout.removeView(title5);
                    linearLayout.removeView(description5);
                }else {
                    linearLayout.addView(title4,10);
                    linearLayout.addView(description4,11);
                    linearLayout.removeView(title5);
                    linearLayout.removeView(description5);
                    title5.setText(data.get(position).getTitle5());
                    description5.setText(data.get(position).getDescription5());
                }
                setScrollViewPosition();
            }
        } else if(view == nextImage){
            numberOfImages = data.get(position).getNumberOfImages();
            if (numberOfImages==2){
                loadBitmap(position,2,data);

                nextImage.setVisibility(View.INVISIBLE);
                previousImage.setVisibility(View.VISIBLE);
            }
            else if(numberOfImages==3)
            {
                if(imageCounter == 1){
                    Glide.with(this)
                            .load(data.get(position).getImage2())
                            .into(image);
                    // image.setImageBitmap(data.get(position).getImage2());
                    previousImage.setVisibility(View.VISIBLE);
                    imageCounter++;
                }
                else if (imageCounter ==2){
                    Glide.with(this)
                            .load(data.get(position).getImage3())
                            .into(image);
                    //image.setImageBitmap(data.get(position).getImage3());
                    imageCounter++;
                    nextImage.setVisibility(View.INVISIBLE);
                    previousImage.setVisibility(View.VISIBLE);
                }
            }
        }
        else if (view == previousImage) {
            if (numberOfImages == 2) {
                loadBitmap(position,1,data);

                previousImage.setVisibility(View.INVISIBLE);
                nextImage.setVisibility(View.VISIBLE);
            } else if (numberOfImages == 3) {
                if (imageCounter == 2) {
                    loadBitmap(position,1,data);

                    imageCounter--;
                    previousImage.setVisibility(View.INVISIBLE);
                    nextImage.setVisibility(View.VISIBLE);
                } else if (imageCounter == 3) {
                    loadBitmap(position,3,data);

                    nextImage.setVisibility(View.VISIBLE);
                    imageCounter--;
                }
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

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            bitmapCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return (Bitmap) bitmapCache.get(key);
    }

    public void loadBitmap(int positionCounter,int imageNumber, List<TraditionalAndModernModel> data) {
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

}
