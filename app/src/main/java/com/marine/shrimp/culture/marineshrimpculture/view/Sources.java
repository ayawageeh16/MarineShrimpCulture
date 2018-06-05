package com.marine.shrimp.culture.marineshrimpculture.view;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class Sources extends AppCompatActivity {

    private TextView  tv2, tv3;
    private String text, links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);
        tv2 =findViewById(R.id.sources_description);
        tv3 =findViewById(R.id.sources_links);

        text = "BIOSECURE SHRIMP FARMING TECHNOLOGY (central institute of brackish water aquaculture)\n" +
                "•\tBiosecurity theory and practice on shrimp farms/hatcheries \n" +
                "•\tCRC Handbook of Mariculture (Crustacean Aquaculture, Second Edition, Volume 1)\n" +
                "•\tCIBA\n" +
                "•\tFAO organization\n" +
                "•\tMarine Shrimp Culture. Principles and Practices book\n" +
                "•\tPrevention & Management of White spot disease of shrimp ICAR - Central Institute of Brackish Water Aquaculture (Indian Council of Agricultural Research)\n";
        links ="•\t http://www.vietlinhjsc.com/en/weeklysummary/ws_2016/2016_7_3.asp\n" +
                "\n"+
                "•\t sgnewm@aqua-in-tech.com\n" +
                "\n" +
                "•\t https://www.dspace.espol.edu.ec/bitstream/123456789/8777/1/04_02_greenhouse.pdf\n" +
                "\n" +
                "•\t Ray2012IntensiveShrimpChapBFTBook.pdf\n" +
                "\n" +
                "•\t Biofloc-Production-Systems-for-Aquaculture.pdf\n" +
                "\n" +
                "•\t http://www.bioshrimp.com/Aquamimicry_Und_Shrimp_Und_Farming/56938ff47cc082d82d11d8ce\n" +
                "\n" +
                "•\t https://www.researchgate.net/profile/Nicholas_Romano2/publication/321687020_Vegetarian_Shrimp_Pellet-free_Shrimp_Farming/links/5a2b1fafaca2728e05de864c/Vegetarian-Shrimp-Pellet-free-Shrimp-Farming.pdf\n" +
                "\n" +
                "•\t https://www.slideshare.net/jitenderanduat/zero-water-cultu-sysras-me\n" +
                "\n" +
                "•\t http://shodhganga.inflibnet.ac.in/bitstream/10603/54249/7/07_chapter%201.pdf\n" +
                "\n" +
                "•\t https://www.researchgate.net/publication/266885204_Biosecurity_and_Major_Diseases_in_Shrimp_Culture?enrichId=rgreq-0f10d9841346b76d662513fefbec04d7-XXX&enrichSource=Y292ZXJQYWdlOzI2Njg4NTIwNDtBUzoxNTQzMjI2MDQxMzg0OTZAMTQxMzgwNDc4NDAyOQ%3D%3D&el=1_x_3&_esc=publicationCoverPdf\n" +
                "\n" +
                "•\t https://www.researchgate.net/publication/271833284_Vibriosis_in_Shrimp_Aquaculture?enrichId=rgreq-0f3297533941337704d89540c47bf6ad-XXX&enrichSource=Y292ZXJQYWdlOzI3MTgzMzI4NDtBUzoxOTM0MjAxMDc3NTE0MjRAMTQyMzEyNjM1NTEzNg%3D%3D&el=1_x_3&_esc=publicationCoverPdf\n";

        tv2.setText(text);
        tv3.setText(links);
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }
}
