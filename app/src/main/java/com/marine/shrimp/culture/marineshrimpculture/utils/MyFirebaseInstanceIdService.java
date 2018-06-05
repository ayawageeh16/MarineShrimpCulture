package com.marine.shrimp.culture.marineshrimpculture.utils;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String RED_TOKEN = "RED_TOKEN";

    @Override
    public void onTokenRefresh() {
        String recent_token= FirebaseInstanceId.getInstance().getToken();
        Log.d(RED_TOKEN,recent_token);
        Toast.makeText(this,recent_token,Toast.LENGTH_LONG).show();
    }
}
