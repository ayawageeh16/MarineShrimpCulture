package com.marine.shrimp.culture.marineshrimpculture.view;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class ManagementPractice extends AppCompatActivity implements View.OnClickListener{

    private Button firstBtn, secondBtn, thirdBtn, forthBtn, fifthBtn, sixthBtn, seventhBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_practice);

        firstBtn = findViewById(R.id.pond_preparation_btn);
        secondBtn=findViewById(R.id.seed_source_btn);
        thirdBtn=findViewById(R.id.seed_selection_btn);
        forthBtn=findViewById(R.id.seed_count_btn);
        fifthBtn=findViewById(R.id.acclimation_btn);
        sixthBtn=findViewById(R.id.stock_btn);
        seventhBtn=findViewById(R.id.feeding_btn);


        firstBtn.setOnClickListener(this);
        secondBtn.setOnClickListener(this);
        thirdBtn.setOnClickListener(this);
        forthBtn.setOnClickListener(this);
        fifthBtn.setOnClickListener(this);
        sixthBtn.setOnClickListener(this);
        seventhBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == firstBtn){
            Intent intent = new Intent(ManagementPractice.this, ManagementPractice2.class);
            intent.putExtra("number", 0);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (view == secondBtn){
            Intent intent = new Intent(ManagementPractice.this, ManagementPractice2.class);
            intent.putExtra("number", 3);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (view == thirdBtn){
            Intent intent = new Intent(ManagementPractice.this, ManagementPractice2.class);
            intent.putExtra("number", 4);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (view == forthBtn){
            Intent intent = new Intent(ManagementPractice.this, ManagementPractice2.class);
            intent.putExtra("number", 5);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (view == fifthBtn){
            Intent intent = new Intent(ManagementPractice.this, ManagementPractice2.class);
            intent.putExtra("number", 6);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (view == sixthBtn){
            Intent intent = new Intent(ManagementPractice.this, ManagementPractice2.class);
            intent.putExtra("number", 7);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        else if (view ==seventhBtn){
            Intent intent = new Intent(ManagementPractice.this, ManagementPractice2.class);
            intent.putExtra("number", 8);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
