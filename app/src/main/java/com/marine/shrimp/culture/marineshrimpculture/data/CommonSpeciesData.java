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

        title="Penaeus monodon";
        commonName ="Giant tiger prawn that Named for its huge size and banded tail.";
        description="Females can reach about 33 cm (13 in) long and weight 200–320 g." +"\n"+
                "males are slightly smaller at 20–25 cm (8–10 in) long and weighing 100–170 g." +"\n"+
                "the carapace and abdomen are transversely banded with alternative red and white. The antennae are grayish brown. Brown pereiopods and pleopods are present with fringing setae in red.";

        distribution ="its natural distribution is the Indo-Pacific, ranging from the eastern coast of Africa and the Arabian Peninsula, as far as Southeast Asia, the Pacific Ocean, and northern Australia.";
        stocking ="25000-50000/hectare.";
        tolerance ="They tolerate a wide range of salinities and temperatures.";
        protein ="Protein between 40 and 50% gave the best growth.";
        survival ="survivals are low (20 to 30%). Tigers are very susceptible to two of the most lethal shrimp viruses: yellow head and white spot disease.";
        market ="1. Penaeus monodon is the most prominent farmed crustacean product in international trade.\n" +
                "2. p.monodon has driven a significant expansion in aquaculture in many developing countries in Asia.\n" +
                "3. Its price is still higher than L. vannamei.\n";
        spf ="Based on the highly successful development of Specific Pathogen Free (SPF)  of Penaeus vannamei brood stock ,the U.S. shrimp industry develop a stock of SPF P. monodon which is the most important (in volume and value) farm-raised shrimp worldwide.\n" +
                "Major elements of an SPF process include:\n" +
                "1. Capture of apparently healthy wild stock from areas of low disease prevalence.\n" +
                "2.\tIndividual primary quarantine where the shrimp can be individually screened for specific pathogens and the contaminated individuals destroyed.\n" +
                "3.\tThe shrimp are then transferred to secondary quarantine where they are reared to brood stock size and monitored regularly.\n" +
                "4.\tThe disease-free broodstock transferred to the breeding center for production.\n" +
                "5.\tLarvae are then reared in bio secure hatcheries.\n" +
                "\n";
        problems ="shortages of wild broodstock often exist, captive breeding is difficult and hatchery.";
        image= R.drawable.penaeusmonod;
        model = new CommonSpeciesModel(title,commonName,description,distribution,stocking,tolerance,protein,survival,market,spf,problems,image);
        list.add(model);

        title="Penaeus Vannamei";
        commonName ="Western White Shrimp or King prawn.";
        description="Vannamei grows to a maximum length of 230 millimeters (9.1 in), with a carapace length of 90 mm (3.5 in)"+"\n"+
                "Adults live in the ocean, at depths of up to 72 meters (236 ft), while juveniles live in estuaries."+"\n"+
                "The rostrum is moderately long, with 7–10 teeth on the dorsal side and 2–4 teeth on the ventral side";

        distribution ="Native to the Pacific coast of Central and South America";
        stocking ="Can be cultured in high stocking densities up to 60/m2";
        tolerance ="They tolerate a wide range of salinities 0.5 to 45 ppt and low temperatures can reach 15 c.";
        protein ="Can tolerate low protein feed 20%: 35%";
        survival ="high from 50 to 60%.";
        market ="Has a very good market but less than monodon.";
        spf ="Commercial availability of SPF and high health stock is an added advantage.";
        problems ="";
        image= R.drawable.paneousva;
        model = new CommonSpeciesModel(title,commonName,description,distribution,stocking,tolerance,protein,survival,market,spf,problems,image);
        list.add(model);

        return list;
    }
}
