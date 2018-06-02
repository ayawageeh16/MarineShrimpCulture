package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;
import java.util.List;

public class DiseasesAndViralDiseaseData {

    static Context context ;
    static List<DiseasesAndViralDiseaseModel> list = new ArrayList<>();
    static DiseasesAndViralDiseaseModel model;
    public DiseasesAndViralDiseaseData(Context context){
        this.context=context;
    }

    public List<DiseasesAndViralDiseaseModel> createList (){

        int image;
        String title, summary, title1, description1, title2, description2, title3, description3;


        title="Bacterial shell disease";
        summary="This disease is also called as brown spot shell disease / burned spot disease / rust disease /" +
                " shell disease or blackspot disease";
        title1="clinical signs ";
        description1="•\tLesions - brownish to black in color.\n" +
                "•\tSingle or multiple eroded areas on the general body cuticle, appendages, or gills\n" +
                "•\tLesions begin as small local lesions (due to abrasions, puncture wounds, chemical trauma or other causes) that rapidly enlarge\n" +
                "•\tcause erosions and ulcerations of the cuticle by lipases, proteases, and chitinases.\n" +
                "•\tblack pigment in the lesions is melanin - end product of the crustacean inflammatory response.\n" +
                "•\tIf not resolved by the shrimp defense, septicemia and death will result.\n";
        title2="Control measures";
        description2="•\tProvision of better water quality, removal of infected and dead prawns, reducing the stock and adequate nutrition\n" +
                "•\tReduce the organic load in the pond by increased water exchange.\n" +
                "•\tFeed terramycin incorporated feed at 0.45 mg/kg of feed for two weeks," +
                " bath treatment using 0.05 to 1.0 mg of malachite green per litre of water are suggested\n";
        title3="Prevention";
        description3="•\tMaintain good water quality and reduce organic load by removing sediments, dead shrimps and moulted exoskeletons which harbour high numbers of bacteria on the lesions.\n" +
                "•\tMinimize handling and avoid overcrowding.\n" +
                "Treatment\t\n" +
                "Treatment with formalin 25 ppm in static condition for 24 hrs is recommended\n";
        image= R.drawable.bactrial;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="EMS";
        summary="";
        title1="Behavioral changes";
        description1="•\t Mortality (up to 100 % 20-30 days after stocking)\n" +
                "•\t Lethargy\n" +
                "•\t low speed in growth rate\n" +
                "•\t Spiral swimming\n" +
                "•\t Swimming sluggishly along the dikes\n" +
                "•\t Reduced preening and feeding \n" +
                "•\t Affected shrimp sank to the pond bottom and die\n";
        title2="Pathological signs:";
        description2="External\n" +
                "•\t Soft texture of the exoskeleton\n" +
                "Internal \n" +
                "•\t whitening of the hepatopancreas\n" +
                "•\t reduction in size of hepatopancreas\n" +
                "•\t Dark spots or streaks on the hepatopancreas\n" +
                "•\t Hardening of hepatopancreas\n";
        title3="";
        description3="";
        image= R.drawable.ems;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Vibrosis in culture ponds";
        summary="";
        title1="Behavioral changes";
        description1="•\tAffected shrimps lost their escape reflexes";
        title2="Pathological signs";
        description2="External signs:\n" +
                "•\t Major symptoms were cloudiness in hepatopancreas in PL, \n" +
                "•\t cloudiness of muscles in sixth abdominal segment\n" +
                "•\t progressive spots on gills and lymphoid organ\n" +
                "•\t The symptoms observed are lethargic swimming of shrimps at the end of the grow out period. Survival was 5-30% with stunted growth of the individuals.\n" +
                "•\t had darkened color and heavy fouling by epibionts. Less affected were pale and opaque, and gills were brown in color.\n" +
                "•\t Body reddening, extended gill covers, slight melanized erosion of uropods, pleopods and periopods.\n" +
                "Internal signs:\n\n" +
                "•\t empty stomach and midgut except for a watery white liquid. Small black spots on the lymphoid organ.\n" +
                "Control of Vibrosis \n" +
                "•\t Salinity and nutrient content of the water\n" +
                "•\t High salinity favors the growth of Vibrio in general. Higher quantities of organic and inorganic fertilizers also contributed to the bloom of Vibrio spp.\n" +
                "•\t Control of Vibrosis in culture ponds\n" +
                "•\t Reduction of biomass by partial harvest or reducing stocking density and increasing the water exchange\n" +
                "•\t For subsequent production cycles, dry the pond bottom soil cracks.\n" +
                "•\t Excessive detritus have to be removed physically by desilting the pond bottom. Quick lime has to be applied at the rate of 0.5 kg/m2 of pond bottom.\n";
        title3="Antibacterial agents used to control vibriosis";
        description3="•\t Oxytetracycline (OTC) medicated feeds were reported to be effective in controlling vibriosis\n" +
                "•\t Administration of 5 or 100 mg/kg of body weight of shrimp per day of OCT in a special feed for 4 to 6 days was found effective.\n";
        image= R.drawable.vibrio;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        title="AHND";
        summary="Acute Hepatopancreatic Necrosis Disease\n" +
                "Early Mortality Syndrome (EMS)\n";
        title1="Susceptible species";
        description1="black tiger shrimp (P.monodon) \n" +
                "American white leg shrimp (L. Vannamei)\n";
        title2="Clinical signs";
        description2="This disease specified with mass mortality (up to100%) 20-30 days after stocking.\n" +
                "Most important\n" +
                "•\t lethargy \n" +
                "•\t low speed in slow growth rate\n" +
                "•\t spiral swimming, as well as empty or interrupted gut.\n" +
                "•\t abnormal hepatopancreas (Emaciated, small, distended, pale or black coloration).\n" +
                "•\t Therefore, some of the behavioral changes such as lethargy, swimming sluggishly along the dikes, spiral swimming and reduced preening and feeding are also observed in EMS.\n" +
                "Prevention and control:\n\n" +
                "•\t Full compliance with the principles of pond preparation (washing, spraying lime, plowing, etc.)\n" +
                "•\t Due to the increasing incidence of disease in high pH water, decreasing or pH control can be considered as a strategy for disease prevention. However, in this case, hydrogen sulfide toxicity possibility increases\n" +
                "\n";
        title3="";
        description3="";
        image = R.drawable.ahda;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Infectious hypodermal and hematopoietic necrosis virus (IHHNV)";
        summary="";
        title1= "Susceptible species";
        description1="P. monodon (black tiger shrimp/prawn) \n" +
                "P. vannamei (Pacific white shrimp)\n" +
                "P. stylirostris (Pacific blue shrimp).\n";
        title2="Clinical signs";
        description2="Certain cuticular deformities (specifically a deformed rostrum bent to the left or right),which may be presented by P. Vannamei and P. stylirostris with RDS, are pathognomonic for infection by IHHNV as P. Vannamei, P. stylirostris, and P. monodon can be infected by IHHNV and not present obvious signs of infection (e.g. they may only show markedly reduced growth rates or ‘runting’)\n" +
                " \n" +
                "IHHN disease in Penaeus Vannamei \n\n" +
                "•\t prevalence of RDS in infected populations of juvenile or older Vannamei may be related to infection during the larval or early PL stages.\n" +
                "•\t Juvenile shrimp with RDS may display a bent (45° to 90° bend to left or right) otherwise deformed rostrum, a deformed sixth abdominal segment \n" +
                "•\t wrinkled antennal flagella\n" +
                "•\t cuticular roughness\n" +
                "•\t bubble-heads \n" +
                "•\t Populations of juvenile shrimp with RDS display disparate growth with a wide distribution of sizes and many smaller than expected (‘runted’) shrimp.\n";
        title3="Control/Treatment";
        description3="No effective vaccination methods for IHHNV have been developed";
        image = R.drawable.ihhv;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Taura Syndrome (TS)";
        summary="";
        title1= "Susceptible species";
        description1="Penaeus Vannamei\n" +
                "Penaeus monodon\n";
        title2="Clinical signs";
        description2="Acute phase: \n\n" +
                "pale reddish colouration with the tail fan and pleopods appearing distinctly reddish due to the expansion of the red chromatophores typically the cutical is soft and the gut empty, \n" +
                "Chronic/recovery phase:\n\n" +
                " shrimp may or may not have reddish colouration and soft cuticles but often show multifocal, melanized cuticular lesions typical of bacterial shell disease which are resolved after successful molting\n" +
                "Control/Treatment\n\n" +
                "•\t These methods are dependent on the total depopulation of infected stocks \n" +
                "•\t disinfection of the culture facility\n" +
                "•\t avoidance of re-introduction of the virus from other nearby culture facilities, wild shrimp, etc. \n" +
                "•\t re-stocking with TS-free postlarvae that have been produced from TS-free broodstock.\n";
        title3="";
        description3="";
        image= R.drawable.tura;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="White-spot syndrome virus (WSSV)";
        summary="";
        title1= "Susceptible species";
        description1="All penaeid shrimps (monodon, Vannamei, Indicus.etc)";
        title2="Clinical signs";
        description2="•\t Affected shrimp exhibit\n\n" +
                "•\t Anorexia\n" +
                "•\t lethargy\n" +
                "•\t reddish discoloration and presence of circular.\n" +
                "•\t white spots on the carapace and other exoskeletal parts.\n" +
                "•\t Vannamei shrimp, white spots may not be clearly visible.\n" +
                "•\t Mortality of shrimp may start 2-3 days after infection and\n" +
                "reach 80-90 percent within 5-7 days of onset of first mortalities,\n" +
                "necessitating emergency harvest.\n";
        title3="Prevention and control";
        description3="•\t WSSV can persist in wet soil, carry out pond preparation properly by drying, applying lime etc. Provide sufficient time of at least three to four weeks between the culture cycles to enable the pond soil to completely dry\n" +
                "\n" +
                "•\t Stock only post larvae (PL) of at least PL15 stage. \n" +
                "•\t Select healthy PL using stress tests and make sure that the PL are negative for WSSV by PCR testing.\n" +
                "\n" +
                "•\t Adopt strict biosecurity measures by providing reservoir ponds, bird and crab fencing, proper sanitation of men, material and machines\n" +
                "\n" +
                "•\t Usages of probiotics and immunostimulant may be helpful.\n" +
                "•\t However, avoid using too many chemicals / unauthorized\n" +
                "•\t Products without knowing their exact effect.\n" +
                "\n";
        image= R.drawable.wssv;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);


        title="Yellow-head Virus Disease (YHD)";
        summary="";
        title1= "Susceptible species";
        description1="Penaeus Vannamei\n" +
                "Penaeus stylirostris\n" +
                "Penaeus monodon\n";
        title2="Clinical signs";
        description2="•\t feeding increases followed by reduced feeding in later stages of the disease. \n" +
                "•\t Pale body\n" +
                "•\t yellowish swollen cephalothorax and hepatopancreas\n" +
                "•\t whitish-yellowish-brownish gills\n";
        title3="Methods of control";
        description3="•\t tNo known treatment\n" +
                "•\t Early detection and emergency harvest followed by thorough disinfection.\n" +
                "•\t lessening stress by maintaining optimal pond environment and rearing conditions may help\n" +
                "•\t maintain consistent phytoplankton blooms at 25-35 cm transparency  \n" +
                "•\t maintaining stable pH in the pond. \n" +
                "•\t After harvesting the shrimp, the accumulated sediments and organic material should be removed followed by      careful pond preparation.\n" +
                "•\t A semi-closed or closed culture system which restricts inflow of new water and recirculates treated water is another method which is sometimes useful. \n" +
                "•\t Waterborne infection is possible and cell-free virus was found to be virulent in water up to 72 hours. \n" +
                "•\t .Chlorine at 20-30 ppm is an effective disinfectant in laboratory conditions. \n" +
                "•\t The use of probiotics and immuno-enhancers is being investigated\n" +
                "\n";
        image= R.drawable.yellow;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        title="Biosecurity Defined";
        summary="All of the proactive strategies that are used to lessen the potential impact of pathogenic organisms on your crop.”\n" +
                "Disease is the outcome of the relationship between the host, the pathogen and the environment\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image = R.drawable.biosecurity1;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Water source";
        summary="•\tClean water from sources free of pollution and contamination.\n" +
                "•\tWater from oceanic source typically very clean with low pathogen loads and low nutrient loads.\n" +
                "•\tWater from estuaries generally has higher nutrient loads, high bacterial loads and higher vector loads. Typically, a source of vibrio and other potential problems.\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image = R.drawable.watersource;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Filtration of incoming water";
        summary="Filtering the water where-ever it can is a best practice";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image = R.drawable.filteration;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Pond preparation";
        summary="•\tPond preparation is to be started with the drying of the pond bottom till it cracks and surface soil scraped to remove the black soil accumulated from the previous crop since it results in the deposition of considerable load of organic matter.\n" +
                "•\tSoil amendment measures like lime application must be practiced (depending on soil pH) similar to any other conventional shrimp farms\n" +
                "•\tProper treatment of discharge water is essential\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image= R.drawable.pondpreparation;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Pond Bottom Preparation and Water Management Prior to Stocking";
        summary="•\t Removal of bottom sludge, particularly in ponds stocking higher densities (up to 8 PL/m2).\n" +
                "•\t Plowing on wet soil if the sludge has not been removed completely.\n" +
                "•\t Use of lime in pond preparation.\n" +
                "•\t Disinfection of pond water\n" +
                "•\t Fertilization reduces the risk of disease outbreak in lower stocking density farms.\n" +
                "•\t Water filtration using twin bag filters of 250 μm mesh size.\n" +
                "•\t Water conditioning for 10–15 days before stocking.\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image = R.drawable.pondpre2;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=" Seed Selection and Stocking";
        summary="•\t Uniform size and color post-larvae (PLs), actively swimming against the water current. Stocking of poor\n" +
                "•\t Quality of seed (less active, more mortality during transportation and size of less than 16 mm in case of nursery\n" +
                "•\t reared juveniles increase the risk of shrimp disease outbreak.\n" +
                "•\t Stocking Pathogen Free (SPF) Larvae (SPF shrimp stocks are available in some countries)\n" +
                "•\t Longer transport time (>6 hours) of the seed from hatchery or nursery to the pond also increases the likelihood of a subsequent disease outbreak.\n" +
                "•\t Weak PL elimination before stocking using formalin (100 ppm) stress for 15–20 minutes in continuously aerated water.\n" +
                "•\t On-farm nursery rearing of PLs for 15–20 days.\n" +
                "•\t Stocking into green water and avoiding transparent water during stocking\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image =  R.drawable.pondpre3;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Other technologies technique";
        summary="•\t The use of SPF shrimp is an important component of any biosecurity plan and the stocking of SPF post larvae can prevent the introduction of specifically listed pathogens from infected seed.\n" +
                "\n" +
                "•\t A commercial shrimp farm that relied on zero water exchange, low protein feeds, deep ponds, and heavy aeration \n" +
                "\n" +
                "•\t BFT systems typically are stocked at high densities (>100 shrimp/m2) and experience little or no water exchange. Initial fill water may pass through a 250-lm screen to " +
                "exclude crustacean vectors and may be held in a reservoir and treated with chlorine or crustacides before filling the ponds.\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image =  R.drawable.othertechnologies;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="Before disease hits your farm";
        summary="1.\tObserve GMP or good management practices\n" +
                "2.\tProvide settling and treatment pond\n" +
                "3.\tProvide reservoir with fish (tilapia is popular)\n" +
                "4.\tUse good quality fry (or WSSV-negative fry as certified by a disease diagnostic lab)\n" +
                "5.\tInstall biosecurity measures such as: -\n" +
                "Tire bath at the farm entrance\n" +
                "Footbath and hand disinfection at the pond entrance\n" +
                "Nets and high-density polyethylene liners as crab fence\n" +
                "Bird scaring device\n" +
                "Individual paraphernalia (feeding trays and boat, secchi disc, refractometer, basins, sampling materials) for each pond\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image = R.drawable.beforedisease;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title="AFTER disease outbreak";
        summary="To avoid recurrence:\n" +
                "1-\t Review your operations.\n" +
                "2-\t Did you do GMPs? \n" +
                "3-\t Were the Biosecurity measures in place?\n" +
                "4-\t Was your monitoring adequate?\n" +
                "5-\t Modify culture system (use of green water, reservoir; closed/semi-closed system; crop rotation; screening and filtration)\n" +
                "6-\t Monitor the presence of viruses by sending tissue samples regularly to a disease diagnostic laboratory\n" +
                "\n";
        title1= "";
        description1="";
        description2="";
        title3="";
        description3="";
        image = R.drawable.afterdiseases;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        return list;
    }
}
