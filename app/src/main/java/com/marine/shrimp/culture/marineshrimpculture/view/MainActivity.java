package com.marine.shrimp.culture.marineshrimpculture.view;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;

import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.adapter.MainAdapter;
import com.marine.shrimp.culture.marineshrimpculture.data.IconModel;
import com.marine.shrimp.culture.marineshrimpculture.utils.IconsAsyncLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final static String ACTIVITY_ICON_LIST= "Activity icon list";
    private DrawerLayout drawerLayout ;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<IconModel> iconsList = new ArrayList<>();
    private StaggeredGridLayoutManager sglm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout =findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_menu);
        recyclerView = findViewById(R.id.main_recyclerView);
        setNavigationView();
        if (savedInstanceState !=null){
            if (savedInstanceState.containsKey(ACTIVITY_ICON_LIST)){
                iconsList=savedInstanceState.getParcelableArrayList(ACTIVITY_ICON_LIST);
                setRecyclerView(recyclerView);
                adapter= new MainAdapter(iconsList, new MainAdapter.OnItemClickedListener() {
                    @Override
                    public void OnItemClicked(IconModel iconModel) {
                        int id = iconModel.getId();
                        if (id == 1){
                            Intent intent = new Intent(MainActivity.this, KnowYourShrimp.class);
                            startActivity(intent);
                        }
                      else if (id == 2){
                            Intent intent = new Intent(MainActivity.this, CommonSpecies.class);
                            startActivity(intent);
                        }
                        else if (id == 3){
                            Intent intent = new Intent(MainActivity.this, SiteSelection.class);
                            startActivity(intent);
                        }
                        else if (id == 4){
                            Intent intent = new Intent(MainActivity.this, WaterQuality.class);
                            startActivity(intent);
                        }
                        else if (id ==5){
                            Intent intent = new Intent(MainActivity.this, DesignAndConstruction.class);
                            startActivity(intent);
                        }
                        else if (id ==6){
                            Intent intent = new Intent(MainActivity.this, ManagementPractice.class);
                            startActivity(intent);
                        }
                        else if (id ==7){
                            Intent intent = new Intent(MainActivity.this, HarvestAndPostHarvest.class);
                            startActivity(intent);
                        }
                        else if (id ==8){
                            Intent intent = new Intent(MainActivity.this, DiseasesAndBiosecurity.class);
                            startActivity(intent);
                        }
                        else if (id ==9){
                            Intent intent = new Intent(MainActivity.this, TraditionalAndModernShrimpCulture.class);
                            startActivity(intent);
                        }
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        }

        else {
            getLoaderManager().initLoader(0, null, loaderCallbacks);
            setRecyclerView(recyclerView);
        }

    }
    private void setRecyclerView (RecyclerView recyclerView){

       sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(sglm);

    }

    private LoaderManager.LoaderCallbacks<List<IconModel>> loaderCallbacks = new LoaderManager.LoaderCallbacks<List<IconModel>>() {
        @Override
        public Loader<List<IconModel>> onCreateLoader(int i, Bundle bundle) {
            return new IconsAsyncLoader(MainActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<List<IconModel>> loader, List<IconModel> iconModels) {
            iconsList = iconModels;
            adapter= new MainAdapter(iconsList, new MainAdapter.OnItemClickedListener() {
                @Override
                public void OnItemClicked(IconModel iconModel) {
                    int id = iconModel.getId();
                    if (id == 1){
                        Intent intent = new Intent(MainActivity.this, KnowYourShrimp.class);
                        startActivity(intent);
                    }
                     else if (id == 2){
                        Intent intent = new Intent(MainActivity.this, CommonSpecies.class);
                        startActivity(intent);
                    }
                     else if (id == 3){
                        Intent intent = new Intent(MainActivity.this, SiteSelection.class);
                        startActivity(intent);
                    }
                     else if (id == 4){
                        Intent intent = new Intent(MainActivity.this, WaterQuality.class);
                        startActivity(intent);
                    }
                     else if (id ==5){
                        Intent intent = new Intent(MainActivity.this, DesignAndConstruction.class);
                        startActivity(intent);
                    }
                     else if (id ==6){
                        Intent intent = new Intent(MainActivity.this, ManagementPractice.class);
                        startActivity(intent);
                    }
                     else if (id ==7){
                        Intent intent = new Intent(MainActivity.this, HarvestAndPostHarvest.class);
                        startActivity(intent);
                    }
                     else if (id ==8){
                        Intent intent = new Intent(MainActivity.this, DiseasesAndBiosecurity.class);
                        startActivity(intent);
                    }
                     else if (id ==9){
                        Intent intent = new Intent(MainActivity.this, TraditionalAndModernShrimpCulture.class);
                        startActivity(intent);
                    }
                }
            });
            recyclerView.setAdapter(adapter);
        }
        @Override
        public void onLoaderReset(Loader<List<IconModel>> loader) { }
    };

    private void setNavigationView (){
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open , R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.about_us_item){
            Intent intent = new Intent(MainActivity.this, AboutUs.class);
            startActivity(intent);
        }else if (id==R.id.sources){
            Intent intent = new Intent(MainActivity.this, Sources.class);
            startActivity(intent);
        }
        return false;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(ACTIVITY_ICON_LIST)) {
                iconsList = savedInstanceState.getParcelableArrayList(ACTIVITY_ICON_LIST);
                setRecyclerView(recyclerView);
                adapter= new MainAdapter(iconsList, new MainAdapter.OnItemClickedListener() {
                    @Override
                    public void OnItemClicked(IconModel iconModel) {
                        int id = iconModel.getId();
                        if (id == 1){
                            Intent intent = new Intent(MainActivity.this, KnowYourShrimp.class);
                            startActivity(intent);
                        }
                        else if (id == 2){
                            Intent intent = new Intent(MainActivity.this, CommonSpecies.class);
                            startActivity(intent);
                        }
                        else if (id == 3){
                            Intent intent = new Intent(MainActivity.this, SiteSelection.class);
                            startActivity(intent);
                        }
                        else if (id == 4){
                            Intent intent = new Intent(MainActivity.this, WaterQuality.class);
                            startActivity(intent);
                        }
                        else if (id ==5){
                            Intent intent = new Intent(MainActivity.this, DesignAndConstruction.class);
                            startActivity(intent);
                        }
                        else if (id ==6){
                            Intent intent = new Intent(MainActivity.this, ManagementPractice.class);
                            startActivity(intent);
                        }
                        else if (id ==7){
                            Intent intent = new Intent(MainActivity.this, HarvestAndPostHarvest.class);
                            startActivity(intent);
                        }
                        else if (id ==8){
                            Intent intent = new Intent(MainActivity.this, DiseasesAndBiosecurity.class);
                            startActivity(intent);
                        }
                        else if (id ==9){
                            Intent intent = new Intent(MainActivity.this, TraditionalAndModernShrimpCulture.class);
                            startActivity(intent);
                        }
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
    }
}
