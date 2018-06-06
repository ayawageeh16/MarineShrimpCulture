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

        title1=context.getString(R.string.Aquamimicrytitle1);
        description1=context.getString(R.string.Aquamimicrydescription1);
        title2=context.getString(R.string.Aquamimicrytitle2);
        description2=context.getString(R.string.Aquamimicrydescription2);
        title3=context.getString(R.string.Aquamimicrytitl3);
        description3=context.getString(R.string.Aquamimicrydescription3);
        title4=context.getString(R.string.blank);
        description4=context.getString(R.string.blank);
        title5=context.getString(R.string.blank);
        description5=context.getString(R.string.blank);
        image1 = R.drawable.aquax;
        image2 =R.drawable.aquamimcryx;
        model= new TraditionalAndModernModel(2,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,0);
        list.add(model);

        title1=context.getString(R.string.Biofloctitle1);
        description1= context.getString(R.string.Bioflocdescription1);
        title2=context.getString(R.string.Biofloctitle2);
        description2=context.getString(R.string.Bioflocdescription2);
        title3=context.getString(R.string.Biofloctitle3);
        description3=context.getString(R.string.Bioflocdescription3);
        title4=context.getString(R.string.Biofloctitle4);
        description4=context.getString(R.string.Bioflocdescription4);
        title5=context.getString(R.string.blank);
        description5=context.getString(R.string.blank);
        image1 =R.drawable.biofloc1;
        image2 =R.drawable.biofloc2;
        model= new TraditionalAndModernModel(2,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,0);
        list.add(model);


        title1=context.getString(R.string.Zerotitle1);
        description1=context.getString(R.string.Zerodescription1);
        title2=context.getString(R.string.Zerotitle2);
        description2=context.getString(R.string.Zerodescription2);
        title3=context.getString(R.string.Zerotitle3);
        description3=context.getString(R.string.Zerodescription3);
        title4=context.getString(R.string.Zerotitle4);
        description4=context.getString(R.string.Zerotitle4);
        title5=context.getString(R.string.blank);
        description5=context.getString(R.string.blank);
        image1=R.drawable.ras;
        image2=R.drawable.ras2;
        model= new TraditionalAndModernModel(2,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,0);
        list.add(model);

        title1=context.getString(R.string.Sustainabletitle1);
        description1=context.getString(R.string.Sustainabledescription1);
        title2=context.getString(R.string.Sustainabletitle2);
        description2=context.getString(R.string.Sustainabledescription2);
        title3=context.getString(R.string.Sustaunabletitle3);
        description3=context.getString(R.string.Sustainabledescription32);
        title4=context.getString(R.string.Sustainabletitle4);
        description4=context.getString(R.string.Sustainabledescription4);
        title5=context.getString(R.string.blank);
        description5=context.getString(R.string.blank);
        image1= R.drawable.undergroundhouse;
        model= new TraditionalAndModernModel(1,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,0,0);
        list.add(model);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        title1=context.getString(R.string.Extensivetitle1);
        description1=context.getString(R.string.Extensivedescription1);
        title2=context.getString(R.string.Extensivetitle2);
        description2=context.getString(R.string.Extensivedescription2);
        title3=context.getString(R.string.Extensivetitle3);
        description3=context.getString(R.string.Extensivedescription3);
        title4=context.getString(R.string.blank);
        description4=context.getString(R.string.blank);
        title5=context.getString(R.string.blank);
        description5=context.getString(R.string.blank);
        image1=R.drawable.extensive;
        image2=R.drawable.semi;
        image3=R.drawable.intensive1;
        model= new TraditionalAndModernModel(3,title1,description1,title2,description2,title3,description3,
                title4,description4,title5,description5,image1,image2,image3);
        list.add(model);

        return list;
    }
}

