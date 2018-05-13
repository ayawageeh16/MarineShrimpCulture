package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class SiteSelectionData {

    static Context context;
    static  SiteSelectionModel model ;

    public SiteSelectionData(Context context){
        this.context=context;
    }

    public SiteSelectionModel createList(){
        String description, criteria, waterQuality, tidal, soil, topography, vegetation, sourceOfSeed, accessibilty, factors, source;
        int image;


        description= "The selection of a suitable site always play a major role in shrimp farming. \n" +
                "\n" +
                "The determination of a site for shrimp farming is made only after through analysis of information on topography, ecosystem, meteorological and socioeconomic conditions.\n";

        criteria = "1. Water quality\n" +
                "2.\tTidal fluctuations\n" +
                "3.\tSoil\n" +
                "4.\tTopography\n" +
                "5.\tVegetation\n" +
                "6.\tSource of seed\n" +
                "7.\tAccessibility\n" +
                "8.\tOther factor\n";

        waterQuality ="Water quality includes all the inherent physico-chemical and microbiological characteristics of water.\n" +
                "\n" +
                "pH is generally considered as one of the most important factors. In any chosen site, the pH of the water preferably range from 7.5 to 8.5.\n" +
                "\n" +
                "the oxygen level is preferably not lower than 4 ppm.\n" +
                "the water must not be too turbid. \n" +
                "\n" +
                "The water is preferably to be rich in microorganisms.\n" +
                "\n" +
                "Salinity variation is considered a determinant factor in shrimp production.\n" +
                " \n" +
                "Optimal level varies from species to species. For instance, the tiger shrimp (Penaeus monodon) grows faster at 15–30 ppt. The white shrimp (P. indicus and P. merguiensis) tolerate higher salinity ranges (25–40 ppt).\n";

        tidal = "The tidal characteristics are of extreme importance in determining pond bottom elevation of dike, slope ratio and drainage system.\n" +
                "\n" +
                "Areas best suited for shrimp farming should have moderate tidal fluctuations preferably 2–3 meters. \n" +
                "\n" +
                "In areas where the tidal range is greater than 4 meters, the site may prove uneconomical to develop or operate as large and high pond dikes will be required.\n" +
                "In areas where tidal range is less than one meter, water management will be expensive requiring the use of pumps.\n" +
                "\n" +
                "knowledge of the occurrence of highest high and lowest low water levels. This should be known so that the size and height of the perimeter dike can prevent flooding.\n" +
                "\n" +
                "direction and strength of water current should be known for provisions on dikes construction to reduce erosion.\n";

        soil = "The soil at the proposed site should have enough clay contest to ensure that the ponds constructed will hold water.\n" +
                "\n" +
                "Good quality dikes are usually built from sandy clay or sandy loam materials which harden and easily compacted.\n" +
                "\n" +
                "Clay-loam or silty-clay loam at pond bottom promotes growth of natural food organisms.\n" +
                "During pond construction, the subsoils are dug for dikes and the pond bottom levelled, the pyrites become oxidized producing sulphuric acid which acidifies the soil.\n" +
                "\n" +
                " The pH of water becomes extremely low and hence affecting water quality and correspondingly reduced natural productivity.\n" +
                "\n" +
                "Alleviating acid sulphate conditions in ponds requires the use of lime and removal of acid by leaching and flushing.\n";

        topography = "It is essential to have a detail topography of the selected site for pond design and farm layout.\n" +
                "\n" +
                " Coastal sites where the slopes run gently towards the sea are easier for pond development requiring less financial inputs since excavation is minimal.\n" +
                "\n" +
                "In areas where the above conditions are not available, the use of mechanical pumps may be resorted.\n" +
                " Associated with topography related constraints are the availability of sufficient quantity of soil for dike construction obtained from excavation of ponds or from above ground bunds.\n" +
                "\n" +
                "\n" +
                "It may prove uneconomical if the site to be developed would require diking material to be transported from outside the chosen area.\n";

        vegetation = "The type of vegetation in the area can be, to some extend, indicative of physical elevation and soil type. \n" +
                "\n" +
                "Dominance of the mangrove plants Avicennia spp. is an indication of good and productive soil. \n" +
                "\n" +
                "Outgrowths of Rhizophora spp. which are usually characterized by dense prop root systems usually signifies soil types that are coarse and acidic.\n" +
                "It is of primary importance to consider density of shrubs at the site.\n" +
                "These have to be cleared first before any land development can take place. \n" +
                "Clearing operation can add up to the capital outlay.\n";

        sourceOfSeed = "Close proximity of the site to the fry ground is advantageous in that the animals being collected for stocking are not subjected to too much transport and handling stress.\n";

        accessibilty = "Accessibility is an important consideration in site selection. Overhead cost and delay in the transport of materials and products can be minimized\n";


        factors = " Adequate consideration should be given to a number of farm related matters such as :\n\n" +
                "1.\tthe availability and quality of labor, \n" +
                "2.\tpeace and order situation \n" +
                "3.\tthe area concerned, \n" +
                "4.\tavailability and source of electricity and water supply,\n" +
                "5.\tmarketing channels and facilities\n" +
                "The availability of technical assistance near the site is another advantage of a site is chosen in an aquaculture research institution.\n";

        source = "http://www.fao.org/docrep/field/003/ac210e/AC210E03.htm\n";
        image = R.drawable.siteselectiontopic;
        model = new SiteSelectionModel(description, criteria,waterQuality, tidal, soil, topography, vegetation, sourceOfSeed, accessibilty, factors, source,image);

        return model;
    }
}
