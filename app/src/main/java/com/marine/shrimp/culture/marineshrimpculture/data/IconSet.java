package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;
import java.util.List;

public class IconSet {

    Context context ;
    IconModel iconModel ;

    public IconSet(Context context){ this.context =context; }

    public List<IconModel> createList(){

        Bitmap bitmap;
        List<IconModel> returnedList = new ArrayList<>();

        bitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.knowyourshrimpgx);
        iconModel = new IconModel(1,"Know Your Shrimp",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.commonspeciesgx);
        iconModel = new IconModel(2,"Common Species",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.siteselectiongx);
        iconModel = new IconModel(3,"Site Selection",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.waterqualitygx);
        iconModel = new IconModel(4,"Water Quality",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.designgx);
        iconModel = new IconModel(5,"Design and Construction",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.mangementgx);
        iconModel = new IconModel(6,"Management Practice",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.harvestgx);
        iconModel = new IconModel(7,"Harvest and Postharvest",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.diseasegx);
        iconModel = new IconModel(8,"Diseases and Biosecurity",bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.traditionalandmoderngx);
        iconModel = new IconModel(9,"Traditional and Modern Shrimp Culture",bitmap);
        returnedList.add(iconModel);

        return returnedList;

    }
}
