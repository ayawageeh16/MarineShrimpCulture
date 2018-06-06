package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class HarvestAndPostHarvestData {

    Context context;
     ArrayList<HarvestAndPostHarvestModel> list = new ArrayList<>();
     HarvestAndPostHarvestModel model;

    public HarvestAndPostHarvestData(Context context) {
        this.context = context;
    }

    public ArrayList<HarvestAndPostHarvestModel> CreateList() {

        String title, description;
        int image1, image2;

        title =  context.getString(R.string.harvesttitle);
        description = context.getString(R.string.harvestdescription);
        image1 = R.drawable.harvest1;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = context.getString(R.string.Intensivettitle);
        description = context.getString(R.string.Intensivedescription);
        image1 = R.drawable.harvest2;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = context.getString(R.string.superintensivettitle);
        description = context.getString(R.string.superintensivedescription);
        image1 = R.drawable.harvest3;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = context.getString(R.string.harvestingtitle);
        description = context.getString(R.string.harvestingdescriotion);
        image1 =R.drawable.method1;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = context.getString(R.string.partialharvestttitle);
        description = context.getString(R.string.partialharvestdescription);
        image1 = R.drawable.method2 ;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title =context.getString(R.string.totalharvestttitle);
        description = context.getString(R.string.totalharvestdescription);
        image1= R.drawable.totalharvest;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = context.getString(R.string.Electricttitle);
        description =  context.getString(R.string.totalharvestdescription);
        image1 =  R.drawable.methodelectric3 ;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = context.getString(R.string.Becarefultitle);
        description = context.getString(R.string.Becarefuldescription);
        image1 = R.drawable.becarfulx ;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = context.getString(R.string.Postharvesttitle);
        description = context.getString(R.string.Postharvestdescription);
        image1 =  R.drawable.postharvest1 ;
        image2 =  R.drawable.postharvest2;
        model = new HarvestAndPostHarvestModel(2, title, description, image1, image2);
        list.add(model);

        return list;
    }
}
