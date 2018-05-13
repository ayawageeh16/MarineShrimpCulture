package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class KnowYourShrimpData {

    static KnowYourShrimpModel model;
    static Context context;
    static int image;
    static String description;
    static ArrayList<KnowYourShrimpModel> list = new ArrayList<>();
    public KnowYourShrimpData (Context context){
        this.context=context;
    }

    public ArrayList<KnowYourShrimpModel> createList(){

        image =R.drawable.firstmorphology;
        description= "Shrimp body is divided into 2 parts, the head and body." +"\n" +
                "The head (6 segments) fused with the chest (8 segments) called the cephalothorax, consists of 13 sections." +"\n" +
                "the abdomen consists of 6 segments, each segment has a pair of swimming feet.";
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        image = R.drawable.secondmorphology;
        description= "The head protected by a shell called a carapace, rostrum at  the front of the carapace, at the top of the rostrum there are serrations which totaled 7-9, while the bottom three serrations.";
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        image =R.drawable.thirdmorphology ;
        description= "the head including: a pair of compound eyes, mouth with jaws (mandibles) are strong, a pair of large antennae, a pair of fins head (scophocerit), a pair of jaws auxiliaries (maxilliped), and 5 pairs of feet road (pereopod).";
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        image = R.drawable.forthmorphology ;
        description= "There are five pairs of swimming legs (pleopods) are attached to the first segment to fifth segment while the sixth segment swimming legs changing its form into a tail fan (urophoda)." +"\n"+
                "Above tail fan there is tail that tapered at the edges is called the telson.";
        model = new KnowYourShrimpModel(image,description);
        list.add(model);

        return list;

    }
}
