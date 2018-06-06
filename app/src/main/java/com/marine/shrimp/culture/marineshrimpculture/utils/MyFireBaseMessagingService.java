package com.marine.shrimp.culture.marineshrimpculture.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.support.v4.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.view.WeatherActivity;

import java.util.Objects;

public class MyFireBaseMessagingService extends FirebaseMessagingService {

        @Override
        public void onMessageReceived(RemoteMessage remoteMessage) {
            super.onMessageReceived(remoteMessage);

            if(remoteMessage.getData().size() > 0){
                //handle the data message here
            }

            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();

        }

}
