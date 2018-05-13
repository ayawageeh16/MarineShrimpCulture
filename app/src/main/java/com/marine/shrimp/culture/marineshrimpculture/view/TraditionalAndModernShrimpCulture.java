package com.marine.shrimp.culture.marineshrimpculture.view;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.marine.shrimp.culture.marineshrimpculture.R;

public class TraditionalAndModernShrimpCulture extends AppCompatActivity implements View.OnClickListener {

    private Button modern, traditional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traditional_and_modern_shrimp_culture);

        modern=findViewById(R.id.modern_btn);
        traditional=findViewById(R.id.traditional_btn);

        modern.setOnClickListener(this);
        traditional.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == modern){
            Intent intent = new Intent(TraditionalAndModernShrimpCulture.this, TraditionalAndModernShrimpCulture2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 0);
            startActivity(intent);
        }
        else if (view == traditional){
            Intent intent = new Intent(TraditionalAndModernShrimpCulture.this,TraditionalAndModernShrimpCulture2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("number", 4);
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
