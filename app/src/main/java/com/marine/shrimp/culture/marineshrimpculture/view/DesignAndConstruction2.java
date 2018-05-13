package com.marine.shrimp.culture.marineshrimpculture.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.data.DesginAndConstructionData;
import com.marine.shrimp.culture.marineshrimpculture.data.DesignAndDestructionModel;

import java.util.ArrayList;

public class DesignAndConstruction2 extends AppCompatActivity {

    private ImageView image;
    private TextView title, description;
    private DesginAndConstructionData desginAndConstructionData;
    private ArrayList<DesignAndDestructionModel> data = new ArrayList<>();
    private  int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_and_construction2);

        image = findViewById(R.id.design_construction_img);
        title = findViewById(R.id.design_construction_title_tv);
        description = findViewById(R.id.design_construction_description_tv);
        desginAndConstructionData = new DesginAndConstructionData(DesignAndConstruction2.this);
        data= desginAndConstructionData.CreateList();

        Bundle extras = getIntent().getExtras();
        position = extras.getInt("number");

        setView(position,data);
    }

    public void setView (int position, ArrayList<DesignAndDestructionModel> data){

        Glide.with(this)
                .load(data.get(position).getImage1())
                .into(image);
        title.setText(data.get(position).getTitle());
        description.setText(data.get(position).getDescription());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }
}

