package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class KnowYourShrimpData {


     KnowYourShrimpModel model;
     Context context;
     int image;
     String description;
     ArrayList<KnowYourShrimpModel> list = new ArrayList<>();
    public KnowYourShrimpData (Context context){
        this.context=context;
    }

    public ArrayList<KnowYourShrimpModel> createList(){

        image =R.drawable.firstmorphology;
        description= context.getString(R.string.know_your_shrimp_data_firstmorphology_description);
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        image = R.drawable.secondmorphology;
        description= context.getString(R.string.know_your_shrimp_secondmorphology_description);
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        image =R.drawable.thirdmorphology ;
        description= context.getString(R.string.know_your_shrimp_data_thirdmorphology_description);
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        image = R.drawable.forthmorphology ;
        description= context.getString(R.string.know_your_shrimp_data_forthmorphology_description);
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        return list;

    }
}
