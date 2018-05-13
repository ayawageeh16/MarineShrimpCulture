package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class ManagementPracticeData {
    static Context context;
    static ArrayList<ManagementPracticeModel> list = new ArrayList<>();
    static ManagementPracticeModel model ;
    public ManagementPracticeData(Context context){
        this.context=context;
    }

    public ArrayList<ManagementPracticeModel> CreateList (){

        String title, description;
        int image1, image2, image3;

        title ="Management practices \n" +
                "Pond preparation";
        description ="Shrimp are benthic animals and live on the pond bottom.\n" +
                "Each type of farm has different stages with each other. To reduce the risks and constraints to disease at the time of culture period, " +
                "preparation must be done as carefully as possible\n";
        image1 = R.drawable.belizelcropped;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);


        title ="For earthen Ponds";
        description ="1-\t pond bottoms should be completely sun dried to oxidize organic matter in pond mud before stocking shrimp, drying and cracking of pond bottom enhances aeration and reducing organic material and improves water quality. \n" +
                "2-\tthe pond dike should be strengthening with soil wherever it has become weak and the inner slope of the dike should also be consolidated with soil.\n" +
                "3-\tploughing bottom soils with disk plough for 5-10 cm can enhance drying to increase aeration and accelerate organic matter decomposition and oxidation of organic matter.\n" +
                "4-\tleveling and compaction must be followed after ploughing.\n" +
                "5-\tliming of shrimp ponds is done to neutralize soil acidity, increase the total alkalinity, total hardness concentration and enhance the primary food productivity in the pond water.\n" +
                "6-\tIn case of slight adjustment of pH during pre_stocking preparation, dolomite can be used this also would help in plankton development \n" +
                "7-\tIn low saline water liming can improve phosphorus availability and enhance pond productivity  \n";
        image1 =  R.drawable.ponddryout ;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);


        title ="For ponds with full HDPE";
        description ="pond preparation includes:\n \n" +
                "1-\tcleaning the pond bottom and walls of the rest of the dirt (mud, tritip, shellfish and others)\n" +
                "2-\tcleaning and repair of plastic and Paddle Wheel Aerator (PWA)\n" +
                "3-\tsterilization using chlorine at the bottom of the pond and in the pipe.\n";
        image1 = R.drawable.p11;
        image2 = R.drawable.p22;
        image3 = R.drawable.p33;
        model = new ManagementPracticeModel(3,title,description,image1,image2,image3);
        list.add(model);

        title ="Shrimp Seeds source \n" +
                "from captures\n";
        description ="small shrimp (post larvae) for stocking ponds can be captured from the wild. \n" +
                "Small mesh push nets are used in the shallow estuaries to capture post larvae. \n" +
                "Post larvae captured in the wild often have both desirable and undesirable shrimp species along with small predacious fishes. \n" +
                "Difficult to separate desirable and undesirable shrimp PLs\n" +
                "Shrimp post larvae from hatcheries\n" +
                "(from captivity).\n" +
                "Numerous larval stages are passed before reaching the post larval stage.\n" +
                "Natural food (phytoplankton) must be provided to the larval stages grown in the hatchery.\n" +
                "However, only desirable shrimp species are raised and contamination with undesirable organisms is not a problem.\n";
        image1 = R.drawable.wild1;
        image2 = R.drawable.seedcource21;
        model = new ManagementPracticeModel(2,title,description,image1, image2, 0);
        list.add(model);


        title ="Seed selection\n" +
                "Seed selection depend on\n";
        description ="Gross examination \n" +
                "(size, color, activity, behavior, feeding and gut fullness)\n" +
                "Microscopic examination (x40)\n" +
                "(gut condition, fouling, deformity) \n" +
                "Stress test\n" +
                "Salinity (28:32ppt)\n" +
                "Vibrio test\n" +
                "(To check the potentially harmful vibrio spp in PL)\n" +
                "PCR \n" +
                "Testing for WSSV.\n";
        image1 = R.drawable.seedselection2;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);

        title ="Seed counting";
        description ="1-\tSelect any one bag and count the fry head.\n" +
                "2-\tThe total number of fry counted from this bag represent the quantity of the other uncounted bags\n";
        image1= R.drawable.seedcount1;
        model = new ManagementPracticeModel(1,title,description,image1,0,0);
        list.add(model);

        title ="Acclimation of the fry";
        description ="Important step before stocking fry to pond\n" +
                "purpose is to make the both transport and pond water condition (temperature and salinity) to be same (or almost same) to minimize stress on the fry\n" +
                "Water salinity, maximum difference in salinity is 2 ppt.\n" +
                "Water temperature, the maximum difference is 2°C.\n" +
                "Time of stocking\n" +
                "morning (6-9 am) [preferable]\n" +
                "Afternoon (5-9 pm).\n" +
                "Paddle wheel must be activated; at least 3 – 4 hours a day for 2-3 days before stocking date, " +
                "and 3-4 hours before the stocking of fry, to ensure adequate D.O.\n";
        image1 = R.drawable.acclim1;
        image2 = R.drawable.acclim2;
        model = new ManagementPracticeModel(2,title,description,image1, image2,0);
        list.add(model);

        title ="Stocking procedure";
        description ="Stocking time between 6-9 AM when the water temperature is low (around 26°C). \n" +
                "Avoid stocking during cloudy and rainy days to prevent D.O. problems. \n" +
                "Float the plastic bags containing fry in the pond water for at least 15:20 minutes to equalize the water temperature in the bag and in the pond. \n" +
                "Open the bags carefully once the temperature difference is 1 – 2°C.\n" +
                "check the salinity If the salinity difference is within the range of 3- 5 ppt, then the fry are ready to be released into the pond\n";
        image1= R.drawable.stock;
        model = new ManagementPracticeModel(0,title,description,image1,0,0);
        list.add(model);

        title ="Feeding";
        description ="Shrimp are benthic feeders and will not rise to the water surface to eat floating pellets\n" +
                "Shrimp are fed sinking pellets which are distributed over the pond surface. \n" +
                "Shrimp are unable to consume a whole pellet but slowly nibble the pellet, consuming small particles. \n" +
                "Feed can be placed on trays to help determine shrimp appetite.\n" +
                "Trays are checked 1 to 2 hours after feeding to see if the daily allotment of feed is consumed by the shrimp. \n" +
                "In the first month, fries are very dependent on natural food, but for intensive culture systems, natural food available is not enough. Therefore, the first month feeding program assumes that natural food is not enough. \n" +
                "After the first month, feeding on the next month following the feed trays control. \n" +
                "For the pond with an area of 0.5 ha, the recommended amount of feed trays is 3-4 units.  \n" +
                "Addition and reduction in feed made in accordance with the results obtained in the feed trays.\n" +
                "If the feed on feed trays expires, the feed for the next day can be added up to 5% of the feed today.  \n" +
                "if the feed in feed trays not exhausted, the feed for the next day can be cut to 40%. \n" +
                "\n";
        image1= R.drawable.feeding;
        model = new ManagementPracticeModel(1,title,description,image1, 0, 0);
        list.add(model);

        return list;
    }
}
