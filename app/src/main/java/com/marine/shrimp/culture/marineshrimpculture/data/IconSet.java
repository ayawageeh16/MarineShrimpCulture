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
        iconModel = new IconModel(1,context.getString(R.string.knoeYourShrimpLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.commonspeciesgx);
        iconModel = new IconModel(2,context.getString(R.string.commonSpeciesLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.siteselectiongx);
        iconModel = new IconModel(3,context.getString(R.string.siteSelectionLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.waterqualitygx);
        iconModel = new IconModel(4,context.getString(R.string.waterQualityLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.designgx);
        iconModel = new IconModel(5,context.getString(R.string.designandeConstruvtionLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.mangementgx);
        iconModel = new IconModel(6,context.getString(R.string.managementPractiveLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.harvestgx);
        iconModel = new IconModel(7,context.getString(R.string.harvesandpostharvestLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.diseasegx);
        iconModel = new IconModel(8,context.getString(R.string.DiseasesLabel),bitmap);
        returnedList.add(iconModel);

        bitmap= BitmapFactory.decodeResource(context.getResources(),R.drawable.traditionalandmoderngx);
        iconModel = new IconModel(9,context.getString(R.string.traditonalLabel),bitmap);
        returnedList.add(iconModel);

        return returnedList;

    }
}
