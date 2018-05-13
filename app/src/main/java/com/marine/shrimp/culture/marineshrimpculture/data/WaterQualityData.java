package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;
import android.os.Parcel;

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

        title ="Water Source";
        description="\n" +
                "from a sea ,from the deep wells, free from all types of pollution.\n";
        image1= R.drawable.waterquality1;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title ="Water Characteristic";
        description="";
        image1 = R.drawable.waterquality2f;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        // need images111111111111111111
        title ="Water Quality Management ";
        description="1. Liming\n" +
                "\n" +
                "The problem of low alkalinity (<20 mg/l as CaC03) can be abated through application of liming materials such as dolomite and limestone.\n" +
                "\n" +
                "they destroy the initial inoculum of decomposing bacteria which will increase nutrient organic load on pond bottom.\n" +
                "\n" +
                "Liming is done whenever the pH drops below 7.5 or the daily fluctuation in pH is more than 0.5.\n";
        image1 =  R.drawable.waterq1;
        image2 = R.drawable.waterq2 ;
        numberOfImages=2;
        model= new WaterQualityModel(title,description,image1,image2,0,numberOfImages);
        list.add(model);

        title ="Water Quality Management ";
        description="2. Fertilization\n" +
                "Fertilization is required during the course of culture to maintain good algal bloom.\n" +
                "\n" +
                "10% of the original dose of fertilizer should be applied at weekly depending on the percentage of water exchange and the algal bloom.\n" +
                "\n" +
                "It is advisable to check the inherent organic load, plankton and possible contamination in the water source by using Secchi disc.\n" +
                "high value of transparency is indicative of poor plankton density and therefore water should be fertilized.\n" +
                "Low value indicates that the plankton density is high.\n";
        image1 = R.drawable.waterquality4;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title ="Water Quality Management ";
        description="3.\tWater exchange\n" +
                "Regulation of environmental factors is mainly achieved by controlling water exchange.\n" +
                "\n" +
                "In the case of low stocking density, water exchange is not required in well prepared ponds for first 30 days only water Level has to be maintained due to evaporation loss.\n" +
                "\n" +
                " water exchange should be Exchange only be used when necessary to maintain the optimum water quality .\n \n" +
                "- Water exchange should be done only under the following pond conditions:\n\n" +
                "1.\tTransparency greater than 50 cm or less than 20 cm\n" +
                "2.\tpH less than 7.5 or greater than8.5\n" +
                "3.\tpH fluctuation in a day greater than 0.5\n" +
                "4.\tShrimp are noticed on the water surface or on the sides of the pond\n" +
                "5.\tFree ammonia level is greater than 0.1 mg/l\n";
        numberOfImages=1;
        image1 = R.drawable.waterqualityexchange;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title ="Water Quality Management ";
        description="4.\tAeration\n" +
                "is necessary in high stocking densities and to maintain water quality.\n" +
                "\n" +
                "Normally aeration will be required during the following situations:\n\n" +
                "1.\tcloudy and rainy days.\n" +
                "2.\tdissolved oxygen level dropping below 4 mg/l especially during early morning hours when the DO level will be at its minimum.\n" +
                "3.\tExcessive algal blooms & application of water treatment additives. \n" +
                "- Paddle wheel aerators @ 4-6 no/ha are generally used in shrimp ponds.\n";
        image1 =  R.drawable.waterquality61;
        image2 =  R.drawable.waterquality62;
        image3 =  R.drawable.waterquality63;
        numberOfImages=3;
        model= new WaterQualityModel(title,description,image1,image2,image3,numberOfImages);
        list.add(model);

        title ="Water Quality Management ";
        description="5. Feeding\n" +
                "Proper feed management is indispensable for successful and profitable shrimp culture.\n" +
                "\n" +
                "Overfeeding is more dangerous than under feeding as over feeding rate can degrade the pond bottom and can lead to " +
                "excessive phytoplankton, DO depletion and toxic concentration of metabolites.\n";
        image1 = R.drawable.waterquality71;
        image2 = R.drawable.waterquality72;
        numberOfImages=2;
        model= new WaterQualityModel(title,description,image1,image2,0,numberOfImages);
        list.add(model);

        title ="Crisis management";
        description="Effects of various abiotic factors on shrimp farming and their remedial measures are summarized in the following- Tables\n" +
                "\n" +
                "Includes :\n\n" +
                "Chemical factors \n" +
                "Gaseous factors \n";
        image1 = R.drawable.crisismanagement;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        title ="Chemical factors ";
        description="";
        image1 = R.drawable.chemicalfactors;
        numberOfImages=1;
        model= new WaterQualityModel(title,description,image1,0,0,numberOfImages);
        list.add(model);

        return list;

    }
}
