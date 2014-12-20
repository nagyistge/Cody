package com.example.cody;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MyService extends Service {

        BroadcastReceiver mReceiver;

        @Override
        public IBinder onBind(Intent arg0) {

                // TODO Auto-generated method stub
                return null;
        }

        @Override
        public void onCreate() {

                KeyguardManager.KeyguardLock k1;
                KeyguardManager km = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
                k1 = km.newKeyguardLock("IN");
                k1.disableKeyguard();
                // There are was unreadable comment
                IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
                // There are was unreadable comment
                filter.addAction(Intent.ACTION_SCREEN_OFF);
                // There are was unreadable comment
                mReceiver = new LockScreenReceiver();
                registerReceiver(mReceiver, filter);
                super.onCreate();
        }

        @Override
        public void onDestroy() {

                unregisterReceiver(mReceiver);
                super.onDestroy();
        }
}