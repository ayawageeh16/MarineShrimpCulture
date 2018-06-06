package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class WaterQualityData {
    Context context;
    ArrayList<WaterQualityModel> list = new ArrayList<>();

    public WaterQualityData(Context context){
        this.context=context;
    }

    public ArrayList<WaterQualityModel> createList(){

        int numberOfImages ;
        String title, description;
        int image1, image2, image3;
        WaterQualityModel model;

        title =context.getString(R.string.water_quality_title1);
        description=context.getString(R.string.water_quality_description1);
        image1= R.drawable.waterquality1;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title =context.getString(R.string.water_quality_title2);
        description="";
        image1 = R.drawable.waterquality2f;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        // need images111111111111111111
        title =context.getString(R.string.water_quality_title3);
        description=context.getString(R.string.water_quality_description3);
        image1 =  R.drawable.waterq1;
        image2 = R.drawable.waterq2 ;
        numberOfImages=2;
        model= new WaterQualityModel(title,description,image1,image2,0,numberOfImages);
        list.add(model);

        title =context.getString(R.string.water_quality_title4);
        description=context.getString(R.string.water_quality_description4);
        image1 = R.drawable.waterquality4;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title =context.getString(R.string.water_quality_title5);
        description=context.getString(R.string.water_quality_description5);
        numberOfImages=1;
        image1 = R.drawable.waterqualityexchange;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title =context.getString(R.string.water_quality_title6);
        description=context.getString(R.string.water_quality_description6);
        image1 =  R.drawable.waterquality61;
        image2 =  R.drawable.waterquality62;
        image3 =  R.drawable.waterquality63;
        numberOfImages=3;
        model= new WaterQualityModel(title,description,image1,image2,image3,numberOfImages);
        list.add(model);

        title =context.getString(R.string.water_quality_title7);
        description=context.getString(R.string.water_quality_description7);
        image1 = R.drawable.waterquality71;
        image2 = R.drawable.waterquality72;
        numberOfImages=2;
        model= new WaterQualityModel(title,description,image1,image2,0,numberOfImages);
        list.add(model);

        title =context.getString(R.string.water_quality_title8);
        description=context.getString(R.string.water_quality_description8);
        image1 = R.drawable.crisismanagement;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title =context.getString(R.string.water_quality_title9);
        description="";
        image1 = R.drawable.chemicalfactors;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        return list;

    }
}
