package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class CommonSpeciesData {

    Context context;
    ArrayList<CommonSpeciesModel> list = new ArrayList<>();


    public CommonSpeciesData (Context context){
        this.context=context;
    }

    public ArrayList<CommonSpeciesModel> createList (){
        String title, commonName, description, distribution, stocking, tolerance, protein, survival, market, spf, problems;
        int image;
        CommonSpeciesModel model;

        title=context.getString(R.string.Penaeusmonodon);
        commonName =context.getString(R.string.commonName);
        description=context.getString(R.string.commonspeciesdescription);

        distribution =context.getString(R.string.commonspeciesdistribution);
        stocking =context.getString(R.string.commonspeciesstocking);
        tolerance =context.getString(R.string.commonspeciestolerance);
        protein =context.getString(R.string.commonspeciesprotein);
        survival =context.getString(R.string.commonspeciessurvival);
        market =context.getString(R.string.commonspeciesmarket);
        spf =context.getString(R.string.commonspeciesspf);
        problems =context.getString(R.string.commonspeciesproblem);
        image= R.drawable.penaeusmonod;
        model = new CommonSpeciesModel(title,commonName,description,distribution,stocking,tolerance,protein,survival,market,spf,problems,image);
        list.add(model);

        title=context.getString(R.string.PenaeusVannameititle);
        commonName =context.getString(R.string.PenaeusVannameicommonname);
        description=context.getString(R.string.vdescription);

        distribution =context.getString(R.string.vdiscription2);
        stocking =context.getString(R.string.vstocking);
        tolerance =context.getString(R.string.vtolerance);
        protein =context.getString(R.string.vprotein);
        survival =context.getString(R.string.vsurvival);
        market =context.getString(R.string.vmarket);
        spf =context.getString(R.string.vspf);
        problems ="";
        image= R.drawable.paneousva;
        model = new CommonSpeciesModel(title,commonName,description,distribution,stocking,tolerance,protein,survival,market,spf,problems,image);
        list.add(model);

        return list;
    }
}
