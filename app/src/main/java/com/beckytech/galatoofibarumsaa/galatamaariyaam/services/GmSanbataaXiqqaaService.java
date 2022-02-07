package com.beckytech.galatoofibarumsaa.galatamaariyaam.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import com.beckytech.galatoofibarumsaa.R;

public class GmSanbataaXiqqaaService extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.sanbata_dura);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return startId;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}