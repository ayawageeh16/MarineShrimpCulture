package com.marine.shrimp.culture.marineshrimpculture.view;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class DiseasesAndBiosecurity extends AppCompatActivity implements View.OnClickListener {

    private Button bacterial_btn, biosecurity_btn, viraldisease_btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases_and_biosecurity);
        bacterial_btn=findViewById(R.id.bacterial_btn);
        biosecurity_btn=findViewById(R.id.biosecurity_btn);
        viraldisease_btn=findViewById(R.id.viral_btn);

        biosecurity_btn.setOnClickListener(this);
        bacterial_btn.setOnClickListener(this);
        viraldisease_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(view == bacterial_btn){
            Intent intent = new Intent(DiseasesAndBiosecurity.this, Diseases.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 0);
            startActivity(intent);
        }
        else if (view == viraldisease_btn){
            Intent intent = new Intent(DiseasesAndBiosecurity.this, Diseases.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 3);
            startActivity(intent);
        }
        else if (view == biosecurity_btn){
            Intent intent = new Intent(DiseasesAndBiosecurity.this,BioSecurity.class);
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
