package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class ManagementPracticeData {

     Context context;
     ArrayList<ManagementPracticeModel> list = new ArrayList<>();
     ManagementPracticeModel model ;
    public ManagementPracticeData(Context context){
        this.context=context;
    }

    public ArrayList<ManagementPracticeModel> CreateList (){

        String title, description;
        int image1, image2, image3;

        title =context.getString(R.string.management_practice_Data_title1);
        description = context.getString(R.string.management_practice_data_description1);
        image1 = R.drawable.belizelcropped;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);


        title =context.getString(R.string.managment_practice_data_title2);
        description =context.getString(R.string.managment_practice_data_description2);
        image1 =  R.drawable.ponddryout ;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);


        title =context.getString(R.string.mangement_practice_data_title3);
        description =context.getString(R.string.managment_practice_data_description3);
        image1 = R.drawable.p11;
        image2 = R.drawable.p22;
        image3 = R.drawable.p33;
        model = new ManagementPracticeModel(3,title,description,image1,image2,image3);
        list.add(model);

        title =context.getString(R.string.managment_practice_data_title4);
        description =context.getString(R.string.managment_practice_data_description4);
        image1 = R.drawable.wild1;
        image2 = R.drawable.seedcource21;
        model = new ManagementPracticeModel(2,title,description,image1, image2, 0);
        list.add(model);


        title =context.getString(R.string.managment_practice_data_title5);
        description =context.getString(R.string.management_practice_data_description5);
        image1 = R.drawable.seedselection2;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);

        title =context.getString(R.string.managment_practice_data_title6);
        description =context.getString(R.string.managment_practice_data_description6);
        image1= R.drawable.seedcount1;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);

        title =context.getString(R.string.managment_practice_data_title7);
        description =context.getString(R.string.managment_practice_data_description7);
        image1 = R.drawable.acclim1;
        image2 = R.drawable.acclim2;
        model = new ManagementPracticeModel(2,title,description,image1, image2,0);
        list.add(model);

        title =context.getString(R.string.managment_practice_data_title8);
        description =context.getString(R.string.managment_practice_data_description8);
        image1= R.drawable.stock;
        model = new ManagementPracticeModel(0,title,description,image1,0,0);
        list.add(model);

        title =context.getString(R.string.managment_practice_data_title9);
        description =context.getString(R.string.managment_practice_data_description9);
        image1= R.drawable.feeding;
        model = new ManagementPracticeModel(1,title,description,image1, 0, 0);
        list.add(model);

        return list;
    }
}
