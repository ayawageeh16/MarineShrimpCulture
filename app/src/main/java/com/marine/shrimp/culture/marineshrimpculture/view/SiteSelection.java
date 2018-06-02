package com.marine.shrimp.culture.marineshrimpculture.view;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.data.SiteSelectionData;
import com.marine.shrimp.culture.marineshrimpculture.data.SiteSelectionModel;

public class SiteSelection extends AppCompatActivity {

    private TextView description_tv, criteria_tv, waterQuality_tv, tidal_tv, soil_tv, topo_tv, vegetation_tv, sourceofseed_tv
            ,accessibility_tv, factors_tv;
    private ImageView image;
    private SiteSelectionModel data ;
    private SiteSelectionData siteSelectionData;
    private ScrollView scrollView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_selection);
        description_tv= findViewById(R.id.site_description_tv);
        criteria_tv= findViewById(R.id.site_criteria_tv);
        waterQuality_tv= findViewById(R.id.site_water_tv);
        tidal_tv= findViewById(R.id.site_tidal_tv);
        soil_tv= findViewById(R.id.site_soil_tv);
        topo_tv= findViewById(R.id.site_topography_tv);
        vegetation_tv= findViewById(R.id.site_vegetation_tv);
        sourceofseed_tv= findViewById(R.id.site_seed_tv);
        accessibility_tv= findViewById(R.id.site_accessibility_tv);
        factors_tv= findViewById(R.id.site_factors_tv);
        image= findViewById(R.id.topic_img);
        scrollView=findViewById(R.id.site_scrollview);

        if (savedInstanceState !=null){
            final int[] position = savedInstanceState.getIntArray("ARTICLE_SCROLL_POSITION");
            if(position != null)
                scrollView.post(new Runnable() {
                    public void run() {
                        scrollView.scrollTo(position[0], position[1]);
                    }
                });
            data= savedInstanceState.getParcelable("data");
            setView(data);

        }else {

            siteSelectionData = new SiteSelectionData(SiteSelection.this);
            data = siteSelectionData.createList();
            setView(data);
        }
    }

    public void setView (SiteSelectionModel data){
        Glide.with(this)
                .load(data.getImage())
                .into(image);
        description_tv.setText(data.getDescription());
        criteria_tv.setText(data.getCriteria());
        waterQuality_tv.setText(data.getWaterQuality());
        tidal_tv.setText(data.getTidal());
        soil_tv.setText(data.getSoil());
        topo_tv.setText(data.getTopography());
        vegetation_tv.setText(data.getVegetation());
        sourceofseed_tv.setText(data.getSourceOfSeed());
        accessibility_tv.setText(data.getAccessibilty());
        factors_tv.setText(data.getFactors());
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
        super.onSaveInstanceState(outState);
        outState.putParcelable("data",data);
        outState.putIntArray("ARTICLE_SCROLL_POSITION",
                new int[]{ scrollView.getScrollX(), scrollView.getScrollY()});
    }
}

