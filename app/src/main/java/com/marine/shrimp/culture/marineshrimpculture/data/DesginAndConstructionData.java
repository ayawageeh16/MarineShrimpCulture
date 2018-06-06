package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;

public class DesginAndConstructionData {


     Context context;
     ArrayList<DesignAndDestructionModel> list = new ArrayList<>();
     DesignAndDestructionModel model ;
    public DesginAndConstructionData(Context context){
        this.context=context;
    }

    public ArrayList<DesignAndDestructionModel> CreateList (){

        String title, description;
        int image1;

        title =context.getString(R.string.design1title);
        description ="There is no standard design for a shrimp rearing pond.\n" +
                " Present day farming practices still heavily rely on the experience of individual farmers, financial capability and the environmental condition prevailing at the site.\n" +
                " A shrimp pond from the engineering view point is essential an improved finfish culture pond.\n" +
                "The improved structural design is largely due to the behavior of the Penaeid shrimps.\n" +
                "Penaeid shrimps are benthic animals and it has a habit of gathering along tank walls. \n" +
                "Any design to increase the wall surface eg. adding substrates or an elevated earthen platform extending along the edges of a pond, can promote high stocking densities.\n" +
                "An ideal shrimp farm is a complex establishment consisting of: \n" +
                "1- various size ponds for nursery and grow-out\n" +
                "2- water control structures including embankments, supply and drainage canals and sluice gates\n" +
                "3- support facilities such as roads, bridges, living quarters, workshops and warehouses, etc.\n" +
                "Careful layout of the described facilities and appropriate structural design in relation to the physical features of the area ensure smooth and effective operational management.\n" +
                "\n";
        image1 = R.drawable.designandconstruction ;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);

        title ="Size and shape of culture ponds";
        description ="Rectangular or square pond are appropriate for shrimp culture.\n" +
                "The longest axis of a pond should be parallel to the prevailing wind direction, this facilitates water movement generated by wind action thereby increasing dissolved oxygen in the water and minimizing water temperature fluctuations in summer or warmer months.\n" +
                "The breadth of a pond depends largely on the purpose and the operational system employed.\n" +
                "The following are the various sizes recommended:\n\n" +
                "Nursery pond\t500 to 1,000 m2\n" +
                "Grow-out pond\tIntensive\t0.25 to 1.0 ha\n" +
                "Semi-intensive\t0.5 to 2.0 ha\n" +
                "Extensive\t1.0 to 10 ha\n" +
                "The rearing pond must have a minimum depth of 1.0 meter.\n" +
                "Most traditional brackish water ponds for shrimp farming are relatively shallow.\n" +
                "To satisfy depth requirement, a ditch is constructed along the dike or a central canal between two opposite sides of the pond. The average depth is 1.0 – 1.2 meters and depth of the platform is 30–60 cm.\n" +
                "\n" +
                "Such pond design with peripheral ditches and central platform affords several benefits:\n" +
                "a.\tThe ditch provide" +
                "s better living conditions during hot weather.\n" +
                "b.\tThe shallow, centrally located platform serves as growing area for the natural food organisms.\n" +
                "c.\tThe ditch also serves as harvesting canal.\n" +
                "Pond bottom should be as even as possible; free from projecting rocks and tree stumps. The bottom must have a gradual slope from the inlet gate towards the drainage gate.\n";
        image1 = R.drawable.dikess;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);


        title ="Dikes";
        description ="Dikes do not only serve as boundaries to indicate pond size and shape but also function to hold water within the pond as well as protecting other farm facilities from flood.\n" +
                "Diking materials must preferably be tested for load bearing capabilities and compatibility. \n" +
                "In some cases where the quality of the soil is inferior for diking, other materials, viz: concrete or clay must be used as core materials to be placed at the pond bottom \n" +
                "Design and construction of embankment must be based on sound engineering principles and economic feasibility.\n";
        image1 = R.drawable.dikes1;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);


        title ="Height of dike";
        description ="Coastal soil used as diking material usually shrinks initially. As such, the height of perimeter dike should have a free board of 0.6–0.7 meter above the desired water depth. Free board allowance is determined from the occurrence and frequency of flood levels over a period from 5–15 years at the farm site.\n" +
                "To compute for the height of dike, the following formula could be used:\n" +
                " \n" +
                "Where\n" +
                "H\t=\theight of designed dike\n" +
                "Hw\t=\thighest high-water level from past record\n" +
                "G\t=\tground level over mean sea level\n" +
                "FB\t=\theight of free board\n" +
                "%\t=\tpercent shrinkage\n" +
                "To give a concrete example, let us assume that a proposed shrimp farm has a ground elevation of 1.0 meter above mean sea level and normal high tide of 2 meters. Previous records indicate that the highest tide occurring every 10 years is 2.8 meters. The rate of soil shrinkage after the embankment have been consolidated is 20% and the estimated free board allowed is 0.60 meter. Height of dike is then calculated from the formula:\n" +
                " \n" +
                "H = 3 meters\n";
        image1 =  R.drawable.dikes2;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);


        title ="Slope";
        description ="The slope of perimeter dike is maintained at an average ratio of 2:1 to 3:1. Very often, external slopes are made at a ratio of 2.5:1 to 3:1. Dikes with steep slopes are always subjected to erosion and require higher maintenance cost \n" +
                "Slope of a dike also highly depends on soil quality. For good clay soil, the recommended slopes are:\n" +
                "1:2 when dike height is above 4.26 m and exposed to wave action;\n" +
                "1:1 when dike is less than 4.26 and the tidal range is greater than 2 meters;\n" +
                "2:1 when the tidal range is 1.0 m or less and the dike height is less than 1.0 meter.\n" +
                "The crown of the dike between ponds should be 1–5 meters. It would be advantageous if fast growing grass species are planted on the dikes to control soil erosion.\n";
        image1 = R.drawable.dikes3;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);


        title ="Supply and drainage canal";
        description ="Not all shrimp farms are located close to the coast or estuaries. For those that are located far away from the water sources, it is necessary to construct supply and drainage canals.\n" +
                "Conceptually, a shrimp pond must possess separate canals for drainage and supply and for avoiding probable contamination of the water supply. Both supply and drainage canals would likewise serve as water level control in the pond and as temporary holding areas for shrimps. It is important that the siting of the canal systems takes advantage of the natural waterways within the proposed site.\n" +
                "Dimensions of supply and drainage canals are calculated by using the following equation:\n" +
                "Q = AV\n" +
                "Where:\n" +
                "Q\t=\tvolume of water discharge\n" +
                "A\t=\tcross-sectional area of the canal\n" +
                "V\t=\tvelocity of water flow\n" +
                "V value can be calculated by the following formula:\n" +
                "V = R⅔ × S½ × 1/n\n" +
                "where:\n \n" +
                "R\t=\tdepth of water flow\n" +
                "S\t=\tcanal bed gradient\n" +
                "N\t=\tcoefficient of roughness (0.02)\n\n " +
                "Example 1:\n" +
                "Assume that R = 1.25 m\n" +
                "S\t=\t1/5000\n" +
                "then\tV\t=\t[1.25]⅔ × [1/5000]½ × 1/0.02\n" +
                "V\t=\t0.82 m/sec\n\n" +
                "Example 2:\n" +
                "Assume that the pond is 50 ha with an average depth of 1.0 meter and that 10 hours is required to drain the water completely, then\n" +
                "volume of water discharge/second = 13.89 m3/sec\n" +
                "from the equation Q = AV \n " +
                "= 16.94 m2\n" +
                "The width of the canal can then be calculated from the equation:\n\n" +
                "A = R (b + 2R)\n" +
                "Slope of the canal is 1:2, R = 1.25\n" +
                "Substituting\n" +
                "16.9 = 1.25 (b + 2 × 1.25)\n" +
                " \n" +
                "= 11.02 m\n" +
                "Therefore, for a pond farm covering 50 hectares, width of the canal at the bedline should be 11.0 meters.\n";
        image1 = R.drawable.supplyx;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);


        title ="Water control gate (sluice type)";
        description ="When designing a sluice gate, it is essential to consider tidal fluctuations and gravity in order to ensure effective control of the inflow and outflow of water within a given period of time.\n" +
                "The water gates are classified according to function as main (primary) gate or secondary gate. Main gates are strategically situated at the perimeter and are usually constructed of reinforced concrete. These are the main structure controlling the quantity of water for distribution to the shrimp farm.\n" +
                "Irrespective of the material to be used to construct the water gates (eg., wood, reinforced concrete, ferrocement), the following requirements should be met:-\n" +
                "a.\ta gate should have adequate capacity for the required amount of water to be taken in or drained out;\n" +
                "b.\ta gate should be constructed in a position that water can be totally discharged;\n" +
                "c.\ta gate should have sufficient grooves for placement of filter screens, slabs and harvest nets;\n" +
                "d.\ta gate should be firmly placed at the pond bottom and properly linked with the dikes to prevent seepage and possible collapse.\n";
        image1 = R.drawable.gatex;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);


        title ="Water control gate (sluice type)";
        description = "A standard gate design consists of tide stern wing, side walls and bed structure. The side walls are often designed in accordance with the slope of the earthen dike. Grooves for slabs are usually set at the inner side of the gate \n" +
                "The size of the gate is based on the total water requirement of a pond. Water intake volume is calculated using the equation:\n" +
                "Q = CA [2g(H - h)]½\n" +
                "where:\n\n" +
                "Q\t=\trate of flow (m/sec)\n" +
                "C\t=\tcross section of the flux (calculated by multiplying the width of gate opening and its depth)\n" +
                "A\t=\tcoefficient of discharge (0.61)\n" +
                "g\t=\tgravitational constant (9.8 m/sec2)\n" +
                "H\t=\ttidal level of the river or sea\n" +
                "w\t=\twater level in the canal or pond\n" +
                "\n";
        image1 = R.drawable.gate2;
        model = new DesignAndDestructionModel(title,description,image1);
        list.add(model);

        return list;
    }
}
