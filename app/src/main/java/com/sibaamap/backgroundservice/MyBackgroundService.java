package com.sibaamap.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyBackgroundService extends Service {

    private MediaPlayer mediaPlayer;

    public static final String TAG = MyBackgroundService.class.getName();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");

        startMusic();

        return START_NOT_STICKY;
    }

    private void startMusic() {

        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);
        }
        mediaPlayer.start();

    }
}
