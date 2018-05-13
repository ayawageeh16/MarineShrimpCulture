package com.marine.shrimp.culture.marineshrimpculture.view;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class HarvestAndPostHarvest extends AppCompatActivity implements View.OnClickListener{

    private Button harvest, methods_btn, becareful_btn, postharvest_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harvest_and_post_harvest);
        harvest =findViewById(R.id.harvest_btn);
        methods_btn=findViewById(R.id.methods_harvest_btn);
        becareful_btn=findViewById(R.id.be_careful_btn);
        postharvest_btn=findViewById(R.id.post_harvest_btn);

        harvest.setOnClickListener(this);
        methods_btn.setOnClickListener(this);
        becareful_btn.setOnClickListener(this);
        postharvest_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == harvest){
            Intent intent = new Intent(HarvestAndPostHarvest.this, HarvestAndPostHarvest2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 0);
            startActivity(intent);
        }
        else if (view == methods_btn){
            Intent intent = new Intent(HarvestAndPostHarvest.this, HarvestAndPostHarvest2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 3);
            startActivity(intent);
        }
        else if (view == becareful_btn){
            Intent intent = new Intent(HarvestAndPostHarvest.this, HarvestAndPostHarvest2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 7);
            startActivity(intent);
        }
        else if (view == postharvest_btn){
            Intent intent = new Intent(HarvestAndPostHarvest.this, HarvestAndPostHarvest2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 8);
            startActivity(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }

    @Override
    public void onBackPressed() {
        NavUtils.navigateUpFromSameTask(this);
        super.onBackPressed();
    }

}
