package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class HarvestAndPostHarvestData {

    static Context context;
    static ArrayList<HarvestAndPostHarvestModel> list = new ArrayList<>();
    static HarvestAndPostHarvestModel model;

    public HarvestAndPostHarvestData(Context context) {
        this.context = context;
    }

    public ArrayList<HarvestAndPostHarvestModel> CreateList() {

        String title, description;
        int image1, image2;

        title = "Harvesting techniques\n" +
                "Extensive and semi_intensive ponds \n";
        description = "are harvested by draining the pond at low tide through a bag net installed in the outlet sluice gate.\n" +
                "If the tide does not allow harvesting, the water can be pumped out.\n" +
                "In some larger farms harvesting machine pumps shrimp and water up to the pond bank where they are dewatered\n";
        image1 = R.drawable.harvest1;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "Intensive ponds";
        description = "may be harvested similarly and small 2-6-man seine nets are dragged around the pond to corral shrimp to the side of " +
                "the pond from where they are removed by cast or dip net or perforated buckets.";
        image1 = R.drawable.harvest2;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "In super-intensive systems";
        description = "the shrimp are simply harvested with large scoop nets when required for processing.";
        image1 = R.drawable.harvest3;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "Methods of harvesting \n"+
                "Traditional method-Cast net";
        description = "commonly applied by extensive, semi-extensive, and intensive system of culture in the many regions a world.";
        image1 =R.drawable.method1;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "partial harvest";
        description = "it is not necessary to drain the pond water if the quantity is small; the harvest procedure is " +
                "simply throw over the cast net on the pond surface";
        image1 = R.drawable.method2 ;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "total harvest";
        description = "following steps are followed by semi – intensive and intensive culture:\n\n" +
                "1-\tReduce the water depth to 80 cm one day before the harvest date.\n" +
                "2-\tHarvest net is properly attached and installed into the water gate of the drain canal.\n" +
                "3-\tRemaining prawns left at the pond bottom can be harvested manually by hand picking them up.\n" +
                "4-\tPrepare two tanks half-filled with water, one tank is for washing and the other is for chilling the prawns.\n" +
                "5-\tAfter washing the prawns it must be transferred immediately to the chilling tank.\n" +
                "6-\tFrom the chilling tank, prawns are transferred to the sorting table to classify them according to size.\n" +
                "7-\tClassified prawns are packed in Styrofoam boxes with alternate layers of ice and prawns to preserve temporarily for transportation\ne";
        image1= R.drawable.totalharvest;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "Electric shocker method";
        description = "Is commonly used in Taiwan and Japan especially for prawn harvest. It is composed of metal wire frame and drag-net battery and transformer. Installed in the frame " +
                "are brass wires or rods composed of positive and negative electrodes installed alternately, the wiring is insulated against water";
        image1 =  R.drawable.methodelectric3 ;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "Be careful";
        description = "To avoid soft shell, the harvest time must be within 4 hours only \n" +
                "One day before harvest, check the prawn by using cast net if soft –shell is plenty, " +
                "delay the harvest date 3-5 days to assure better quality\n";
        image1 = R.drawable.becarfulx ;
        model = new HarvestAndPostHarvestModel(1, title, description, image1, 0);
        list.add(model);

        title = "Post-harvest";
        description = "the shrimps should be washed and placed immediately in chilled water (10–15°C) for about 15 minutes. They are then packed in" +
                " Styrofoam box with alternate layers of crushed ice at a ratio of 1:1. Smaller Styrofoam boxes are preferred to facilitate transportation. If bigger styrofoam boxes are used, " +
                "it is better to fill up the box with chilled water, shrimps and ice to avoid physical damage on the shrimps at the bottom.";
        image1 =  R.drawable.postharvest1 ;
        image2 =  R.drawable.postharvest2;
        model = new HarvestAndPostHarvestModel(2, title, description, image1, image2);
        list.add(model);

        return list;
    }
}
