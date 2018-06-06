package com.marine.shrimp.culture.marineshrimpculture.data;

import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.R;

import java.util.ArrayList;
import java.util.List;

public class DiseasesAndViralDiseaseData {

     Context context ;
     List<DiseasesAndViralDiseaseModel> list = new ArrayList<>();
     DiseasesAndViralDiseaseModel model;
    public DiseasesAndViralDiseaseData(Context context){
        this.context=context;
    }

    public List<DiseasesAndViralDiseaseModel> createList (){

        int image;
        String title, summary, title1, description1, title2, description2, title3, description3;


        title=context.getString(R.string.DiseasesAndViralDiseaseDatatitle);
        summary=context.getString(R.string.DiseasesAndViralDiseaseSummery1);
        title1=context.getString(R.string.DiseasesandViralDiseasesTitle1);
        description1=context.getString(R.string.DiseaseaandViralDiseasesdescription1);

        title2=context.getString(R.string.DiseasesAndViralDiseaseDatatitle2);
        description2=context.getString(R.string.DiseaseaandViralDiseasesdescription2);

        title3=context.getString(R.string.diseasesandviraltitle3);
        description3=context.getString(R.string.DiseaseaandViralDiseasesdescription3);

        image= R.drawable.bactrial;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.EmsTitle);
        summary=context.getString(R.string.blank);
        title1=context.getString(R.string.EmsTitle1);
        description1=context.getString(R.string.Emsdescription1);
        title2=context.getString(R.string.emsTitle2);
        description2=context.getString(R.string.Emsdescription2);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image= R.drawable.ems;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.virbosistilte);
        summary=context.getString(R.string.blank);
        title1=context.getString(R.string.virbosisTitle2);
        description1=context.getString(R.string.virbosisdescription1);
        title2=context.getString(R.string.virbosisititle2);
        description2=context.getString(R.string.virbosisdescription2);
        title3=context.getString(R.string.virbosistitle3);
        description3=context.getString(R.string.virbosisdescription3);
        image= R.drawable.vibrio;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        title=context.getString(R.string.AHNDtitle);
        summary= context.getString(R.string.AHNDsummery);
        title1=context.getString(R.string.AHNDtitle1);
        description1=context.getString(R.string.AHNDdescription1);
        title2=context.getString(R.string.AHNDtitle2);
        description2=context.getString(R.string.AHNDdescription2);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image = R.drawable.ahda;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.IHHNVtitle);
        summary=context.getString(R.string.blank);
        title1= context.getString(R.string.IHHNVtitle1);
        description1=context.getString(R.string.IHHNVdesvription1);
        title2=context.getString(R.string.IHHNVdesvription2);
        description2=context.getString(R.string.IHHNVdesvription2);

        title3=context.getString(R.string.IHHNVtitle3);
        description3=context.getString(R.string.IHHNVdescription3);
        image = R.drawable.ihhv;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.tauratitle);
        summary="";
        title1= context.getString(R.string.tauratitle1);
        description1=context.getString(R.string.tauradesvription1);
        title2=context.getString(R.string.tauratitle2);
        description2=context.getString(R.string.tauradesvription2);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image= R.drawable.tura;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.WSSVtitle);
        summary=context.getString(R.string.blank);
        title1= context.getString(R.string.WSSVtitle1);
        description1=context.getString(R.string.WSSVdesvription1);
        title2=context.getString(R.string.WSSVtitle2);
        description2= context.getString(R.string.WSSVdesvription2);
        title3=context.getString(R.string.WSSVtitle3);
        description3=context.getString(R.string.WSSVdescription3);
        image= R.drawable.wssv;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);


        title=context.getString(R.string.YHDtitle);
        summary="";
        title1= context.getString(R.string.YHDtitle1);
        description1=context.getString(R.string.YHDdesvription1);
        title2=context.getString(R.string.YHDtitle2);
        description2=context.getString(R.string.YHDdesvription2);
        title3=context.getString(R.string.YHDtitle3);
        description3=context.getString(R.string.YHDdescription3);
        image= R.drawable.yellow;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        title=context.getString(R.string.biosecuritytitle);
        summary=context.getString(R.string.biosecuitytitle1);
        title1=context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image = R.drawable.biosecurity1;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.watersourcetitle);
        summary=context.getString(R.string.watersourcetitle1);
        title1=context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image = R.drawable.watersource;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.filtrationtitle);
        summary=context.getString(R.string.filtrationtitle1);
        title1=context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image = R.drawable.filteration;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.pondtitle);
        summary=context.getString(R.string.pondtitle1);
        title1= context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image= R.drawable.pondpreparation;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.pondbottomtitle);
        summary=context.getString(R.string.pondbottomtitle1);
        title1=context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image = R.drawable.pondpre2;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.seedselectiontitle);
        summary=context.getString(R.string.seedselectiontitle1);
        title1=context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image =  R.drawable.pondpre3;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.otherTechtitle);
        summary=context.getString(R.string.otherTechtitle1);
        title1=context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image =  R.drawable.othertechnologies;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.beforetitle);
        summary=context.getString(R.string.beforetitle1);
        title1= context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image = R.drawable.beforedisease;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        title=context.getString(R.string.aftertitle1);
        summary=context.getString(R.string.aftertitle1);
        title1= context.getString(R.string.blank);
        description1=context.getString(R.string.blank);
        description2=context.getString(R.string.blank);
        title3=context.getString(R.string.blank);
        description3=context.getString(R.string.blank);
        image = R.drawable.afterdiseases;
        model= new DiseasesAndViralDiseaseModel(title,summary,title1,description1,title2,description2,title3,description3,image);
        list.add(model);

        return list;
    }
}
