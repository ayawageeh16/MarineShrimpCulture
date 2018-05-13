package com.marine.shrimp.culture.marineshrimpculture.view;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class AboutUs extends AppCompatActivity {

    private TextView tv1, tv2;
    private String aboutUs1, aboutUs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tv1= findViewById(R.id.about_us_tv1);
        tv2= findViewById(R.id.about_us_tv2);

        aboutUs1="We are a group of students create this app to help the farmers taking the right decision, " +
                "increase their awareness, guide them to the best aquaculture management, guide them How to avoid disease " +
                "and How to deal with the diseased/infected shrimp, providing accurate information for shrimp farming technique" +
                "this app also for students and everyone interest in this sector.";
        aboutUs2="Radwa yehia\n" +
                " Mariham El-Sayed\n" +
                "Doaa sobhy\n" +
                "Marihan Mohammed\n" +
                "Soha Nasser\n" +
                "Donia Hussein\n" +
                "Kariem Abd-Elwaeth\n" +
                "Abdelaziz Abdelbar\n" +
                "Under Supervisor\n" +
                " D/Ashraf Youssef El-Dakar\n" +
                "Suez university, faculty of fish resource\n";

        tv1.setText(aboutUs1);
        tv2.setText(aboutUs2);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }

}
