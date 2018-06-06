package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;
import java.util.List;

public class TraditionalAndModernData {

     Context context;
     List<TraditionalAndModernModel> list = new ArrayList<>();
     TraditionalAndModernModel model;

    public TraditionalAndModernData(Context context){
        this.context=context;
    }

    public List<TraditionalAndModernModel> createList (){


        int image1, image2, image3;
        String title1 , description1, title2 , description2, title3 , description3,
                title4 , description4, title5 , description5 ;

        title1="Aquamimicry Shrimp Farming";
        description1="Aquamimicry is the intersection of aquatic biology and technology (symbiotic) synergistically in mimicking nature of aquatic ecosystems to create living organisms for the well-being development of aquatic animals.\n" +
                "We are accelerating advancement in the field of aquaculture by combining microbial activity with natural feed source in a coordinated fashion; we create living organisms to rebalance our environment for Sustainable Aquaculture.\n" +
                "This is done by fermenting a carbon source, such as rice or wheat bran," +
                "with probiotics (like Bacillus sp.) and releasing their nutrients.\n";
        title2="Fermentation process in aquamimicry";
        description2="A complex carbon source, such as rice, wheat bran or soya bean, is mixed with water (1:5-10 ratio) and probiotics under aeration for 24 hours. If the bran is finely powdered, the entire mixture is added slowly to the pond.\n " +
                "If crumbled, the upper “milk” or “juice” is added to the pond and the bran solids are fed to fish in the biofilter pond.\n" +
                "Stoking density :20 pcs per sqm\n" +
                "Dose 1 ppm of fermented rice bran FRB/day\n";
        title3="Advantages of aquamimicry";
        description3="•\tEliminating disease\n\n" +
                "•\tMaintain water quality\n" +
                "•\tMinimizing water exchanges \n" +
                "•\tDecreasing the feed conversion ratio\n" +
                "•\tDevelopment of health management. \n" +
                "•\tReducing stress associated with fluctuating water quality\n" +
                "•\tMinimizing environmental conditions favorable to pathogens\n" +
                "•\tGreater biosecurity and sourcing of specific pathogen free animals.\n";
        title4="";
        description4="";
        title5="";
        description5="";
        image1 = R.drawable.aquax;
        image2 =R.drawable.aquamimcryx;
        model= new TraditionalAndModernModel(2,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,0);
        list.add(model);

        title1="Biofloc technology (aerated mixed ponds)";
        description1="In recent years the aquaculture industry has come under scrutiny for contributing to environmental degradation.  Interest in closed aquaculture systems for the production of shrimp and fish is increasing," +
                " mostly due to some key environmental and marketing advantages over extensive systems. Bioflocs are aggregates (flocs) of algae, bacteria, protozoans, and other kinds of particulate organic matter such as feces and uneaten feed. Each floc is held together in a loose matrix of mucus that is secreted by bacteria, bound by filamentous microorganism. " +
                "The biofloc community also includes animals that are grazers of flocs, such as some zooplankton and nematodes. Large bioflocs can be seen with the naked eye, but most are microscopic. Flocs in a typical greenwater biofloc system are rather large, around 50 to 200 microns, and will settle easily in calm water.\n" +
                "•\tWhen water is reused, the risk of discharging pollution is reduced This is a benefit for protecting natural resources\n" +
                "•\tEnvironmental regulations and discharge fees are inhibitive in most regions\n" +
                "•\tIntroduction of contaminants and pathogen from the environment to cultured animals is unlikely, especially when biosecurity measures such as source water disinfection are employed. \n\n" +
                "•\tUsing closed systems limits the chance of animal escapement.\n" +
                "•\tHelping to prevent exotic species and disease introductions to the natural environment.\n" +
                "•\tCulturing shrimp in biofloc systems is that multiple external filtration systems are not required.\n" +
                "•\tReducing start up and operational expenses.\n" +
                "•\timproved growth rate.\n" +
                "•\timproved feed conversion ratio.\n" +
                "•\tThe dry-weight protein content of biofloc ranges from 25 to 50 percent.\n" +
                "•\tTreatment of waste organic.\n" +
                "Biofloc also has disadvantages such as\n\n" +
                "•\tHigh electricity required\n" +
                "•\tProfessional workers.\n" +
                "Suitable culture species for biofloc: \n \n" +
                "A basic factor in designing a biofloc system is the species to be cultured. Biofloc systems work best with species that are able to derive some nutritional benefit from the direct consumption of floc. Biofloc systems are also most suitable for species that can tolerate high solids concentration in water and are generally tolerant of poor water quality. Species such as shrimp and tilapia have physiological adaptations that allow them to consume biofloc and digest microbial protein, thereby taking advantage of biofloc as a food resource. " +
                "Nearly all biofloc systems are used to grow shrimp, tilapia, or carps. Channel catfish and hybrid striped bass.\n";
        title2="Basic types of biofloc systems";
        description2="Few types of biofloc systems have been used in commercial aquaculture. The two basic types are those that are exposed to natural light and biofloc systems not exposed to natural light. include outdoor, lined ponds or tanks for the culture of shrimp or lined raceways for shrimp culture in greenhouses. Most biofloc systems in commercial use are greenwater. However, some biofloc systems (raceways and tanks) have been" +
                "installed in closed buildings with no exposure to natural light. These systems are operated as “brown- water” biofloc " +
                "systems.";
        title3="Densities";
        description3="The optimal shrimp density for a super-intensive system will depend on management and production goals.\n" +
                "dense biomass of L. Vannamei (300-800 shrimp/m3 can be controlled.\n";
        title4="Aeration";
        description4="When selecting aeration devices it is important to take into account system size as well the density of animals\n" +
                "Air blowers are commonly used in super-intensive systems.\n" +
                "Air lift mechanisms are commonly used to move and aerate water\n";
        title5="";
        description5="";
        image1 =R.drawable.biofloc1;
        image2 =R.drawable.biofloc2;
        model= new TraditionalAndModernModel(2,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,0);
        list.add(model);


        title1="Zero water exchange system";
        description1="Defined as recirculation technology implemented by cycles water through filtration processes and " +
                "returns it back into the aquaculture system.";
        title2="Advantages";
        description2="1.\tCan control disease outbreaks and environmental pollution more easily.\n" +
                "2.\tRecycle strategy to reduce the effluents and sediments that would be released in to the environment by a typical intensive shrimp farm.\n" +
                "3.\tincreased biosecurity and reduced feed costs and water use.\n";
        title3="Disadvantages";
        description3="1.\tProduction costs of closed systems are much higher than those of open systems.\n" +
                "2.\tenvironmental problems still remain when waste water is discharged from such farming systems.\n";
        title4="THE RAS DESIGN";
        description4="1.\tGrowing tank \n\n" +
                "2.\tSump of particulate removal device,\n" +
                "3.\tBiofilter,\n" +
                "4.\tOxygen injection with U-tube aeration and,\n" +
                "5.\tWater circulation pump.\n" +
                "6.\tOzone and ultraviolet sterilization to reduce organic and bacteria loads.\n" +
                "\n" +
                "These systems have high stocking densities (greater than 300 shrimp/m3) resulting in high biomass (greater than 3-6 kg/m3).\n" +
                "A 2009 study at the lab showed that high yields (9.29 kg/m3) and survival (88%) could be achieved with no water exchange and a density of 500 shrimp/m3 while using foam fractionators or settling tanks (STs) to regulate levels of particulate matter in the culture medium.\n" +
                "Zero water exchange system:\n\n" +
                "\n" +
                "1.\tThe study was conducted in six 40-m3 raceways.\n" +
                "2.\tEach25.4x2.7(68.5m2) raceway was lined with EPDM(ethylenepropylenedieneterpolymer)\n" +
                "3.\tRaceways were equipped with a center longitudinal partition positioned over a 5.1-centimeter PVC pipe with sprayer nozzles.\n" +
                "4.\tEach raceway had six banks of three 5.1 cm airlift pumps positioned equidistance on both sides of the partition.\n" +
                "5.\tInaddition, each raceway had six 0.91 cm long air diffusers.\n" +
                "\n";
        title5="";
        description5="";
        image1=R.drawable.ras;
        image2=R.drawable.ras2;
        model= new TraditionalAndModernModel(2,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,0);
        list.add(model);

        title1="Sustainable culture of shrimp in green houses";
        description1="Greenhouse technology is the unique technique of providing favorable conditions to shrimp. ";
        title2="Advantages";
        description2="1.\tProtected Environment for Shrimp Cultivation Ponds\n" +
                "2.\tTemperature control enabling:\n\n" +
                "a.\twinter shrimp farming\n" +
                "b.\thigh survival rates\n" +
                "c.\tquality improvement\n\n" +
                "3.\tEarly season harvesting during high market demand in low supply seasons.\n" +
                "4.\tHigh profitability before and after shrimp sales peak.\n" +
                "5.\tGood return of investment\n" +
                "6.\tit brings high income and controls environmental pollution\n";
        title3="Disadvantages";
        description3="1.\tHigh upfront and operating expenses.\n" +
                "2.\tKnowledge and skills required.\n" +
                "3.\tHigh maintenance cost\n" +
                "\n" +
                "This closed, modern model farm white leg shrimp with a density of 200-250 shrimp/m2. After 2.5 to 3 months, " +
                "it is possible to harvest with a capacity of 60-70 tons/ha type 40-45 shrimp/kg. In an area of 60 hectares, each year.\n";
        title4="Green house structure design";
        description4="•\tBased on concrete PVC protected metal columns and polypropylene ropes.\n" +
                "•\tCovering material the plastic polymers materials used to cover the green house to allow maximum heat gain and reduce heat escaped.\n" +
                "\n" +
                "•\tA 60% shade cloth covered the outside of the green house during the summer months. \n" +
                "\n" +
                "•\tA single layer of 200-micron clear UV-resistant polyethylene\n" +
                "•\tPlastic material covers the winter months.\n";
        title5="";
        description5="";
        image1= R.drawable.undergroundhouse;
        model= new TraditionalAndModernModel(1,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,0,0);
        list.add(model);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        title1="Extensive";
        description1="•\tPost larvae enter the pond with the tide or are stocked at < 4/m3. Sometimes the pond entrance is screened to limit entrance of predators.\n" +
                "•\tWater is not fertilized and shrimp are not fed\n";
        title2="Semi-intensive ";
        description2="•\tPost larvae are stocked into ponds at 15 to 25/m3 and are fed daily. Some water exchange is practiced to maintain water quality.\n" +
                "•\tShrimp are fed sinking pellets which are distributed over the pond surface. \n" +
                "•\tFeeding trays are sometimes used to help determine shrimp appetite.\n";
        title3="Intensive";
        description3="Shrimp are stocked at 35 -250/m2 in tanks and small ponds with heavy aeration and water exchange";
        title4="";
        description4="";
        title5="";
        description5="";
        image1=R.drawable.extensive;
        image2=R.drawable.semi;
        image3=R.drawable.intensive1;
        model= new TraditionalAndModernModel(3,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,image3);
        list.add(model);

        return list;
    }
}

