package com.marine.shrimp.culture.marineshrimpculture.utils;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.marine.shrimp.culture.marineshrimpculture.data.IconModel;
import com.marine.shrimp.culture.marineshrimpculture.data.IconSet;

import java.util.ArrayList;
import java.util.List;

public class IconsAsyncLoader extends AsyncTaskLoader<List<IconModel>> {

    Context context;
    List<IconModel> icons = new ArrayList<>();
    IconSet entry;

    public IconsAsyncLoader(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public List<IconModel> loadInBackground() {
        entry = new IconSet(context);
        icons = entry.createList();
        return icons;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public void deliverResult(List<IconModel> data) {
        super.deliverResult(data);
    }

}
