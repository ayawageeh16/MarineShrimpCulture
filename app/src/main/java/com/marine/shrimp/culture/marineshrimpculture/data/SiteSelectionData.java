package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class SiteSelectionData {

     Context context;
     SiteSelectionModel model ;

    public SiteSelectionData(Context context){
        this.context=context;
    }

    public SiteSelectionModel createList(){
        String description, criteria, waterQuality, tidal, soil, topography, vegetation, sourceOfSeed, accessibilty, factors, source;
        int image;


        description= context.getString(R.string.site_selection_description);
        criteria = context.getString(R.string.site_selection_criteria);

        waterQuality =context.getString(R.string.site_selection_water_quality);
        tidal = context.getString(R.string.site_selection_tidal);
        soil = context.getString(R.string.site_selection_soil);
        topography = context.getString(R.string.site_selection_topography);
        vegetation = context.getString(R.string.site_selection_vegetation);

        sourceOfSeed = context.getString(R.string.site_selection_source_of_seed);

        accessibilty = context.getString(R.string.site_selection_accessability);


        factors = context.getString(R.string.site_selection_factors);
        source = context.getString(R.string.site_selection_source);
        image = R.drawable.siteselectiontopic;
        model = new SiteSelectionModel(description, criteria,waterQuality, tidal, soil, topography, vegetation, sourceOfSeed, accessibilty, factors, source,image);

        return model;
    }
}
