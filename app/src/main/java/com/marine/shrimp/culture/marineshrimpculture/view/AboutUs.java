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

        aboutUs1="We are a group of students who created this app as a graduation project to help shrimp farmers taking the decisions and to guide them to the best aquaculture management ,how avoid diseases and how to deal with the infected shrimp\n" +
                "this app is not only for shrimp farmers but also for students and everyone else interest in this sector";
        aboutUs2="•\tRadwa yehia -"+" Mariham El-Sayed\n"
                +"•\tDoaa sobhy -"+" Marihan Mohammed\n"
                +"•\tSoha Nasser - "+" Donia Hussein\n"
                +"•\tKariem Abd-Elwaeth - "+" Abdelaziz Abdelbar\n\n"
                +"•\tUnder Supervisor: \n" +
                "\tDr/Ashraf Youssef El-Dakar, "+" Suez university,\n" +
                "\tFaculty of Fish Resource\n";

        tv1.setText(aboutUs1);
        tv2.setText(aboutUs2);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }

}
