package com.marine.shrimp.culture.marineshrimpculture.view;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class DesignAndConstruction extends AppCompatActivity implements View.OnClickListener{

    private Button firstBtn, secondBtn, thirdBtn, forthBtn, fifthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_and_construction);

        firstBtn = findViewById(R.id.design_construction_btn);
        secondBtn=findViewById(R.id.size_shape_btn);
        thirdBtn=findViewById(R.id.dikes_btn);
        forthBtn=findViewById(R.id.supply_drain_btn);
        fifthBtn=findViewById(R.id.water_gate_btn);


        firstBtn.setOnClickListener(this);
        secondBtn.setOnClickListener(this);
        thirdBtn.setOnClickListener(this);
        forthBtn.setOnClickListener(this);
        fifthBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == firstBtn){
            Intent intent = new Intent(DesignAndConstruction.this, DesignAndConstruction2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 0);
            startActivity(intent);
        }
        else if (view == secondBtn){
            Intent intent = new Intent(DesignAndConstruction.this, DesignAndConstruction2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 1);
            startActivity(intent);
        }
        else if (view == thirdBtn){
            Intent intent = new Intent(DesignAndConstruction.this, DesignAndConstruction3.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 2);
            startActivity(intent);
        }
        else if (view == forthBtn){
            Intent intent = new Intent(DesignAndConstruction.this, DesignAndConstruction2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 5);
            startActivity(intent);
        }
        else if (view == fifthBtn){
            Intent intent = new Intent(DesignAndConstruction.this, DesignAndConstruction3.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 6);
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
