package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by pee on 1/5/2016.
 */


/**
 * Created by pee on 2/3/2016.
 */
  public  class  LATEST_MESSAGE extends Activity implements  View.OnClickListener {
    public LATEST_MESSAGE() {
        super();
    }

    String firstsermon, secondsermon, thirdsermon, fourthsermon;

    final String songs_urls[] = {
            firstsermon, secondsermon, thirdsermon, fourthsermon

    };

    Button PLAY = (Button) findViewById(R.id.PLAYEE);
    TextView sermono = (TextView) findViewById(R.id.sermono);
    MediaPlayer OurSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalle);


        firstsermon ="http://www.sermonaudio.com/sermoninfo.asp?sermonID=12161921362";
        secondsermon ="http://www.sermonaudio.com/sermoninfo.asp?SID=12161921362LO=true";
        thirdsermon= "http://www.sermonaudio.com/sermoninfo.asp?SID=1221151626108LO=true";
        fourthsermon = "http://www.playvideo.sa-media.com/media/1221151626108/1221151626108.mp4";







        Button PLAY = (Button) findViewById(R.id.PLAYEE);
        PLAY.setOnClickListener(this);

        OurSong = MediaPlayer.create(LATEST_MESSAGE.this, Uri.parse(songs_urls[0]));
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxvolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


    }

    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.PLAYEE:
                MediaPlayer OurSong = new MediaPlayer();
                OurSong.setAudioStreamType(AudioManager.STREAM_MUSIC);

                try {
                    OurSong.setDataSource(String.valueOf(songs_urls[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    OurSong.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                OurSong.start();

                if (OurSong.isPlaying()) {
                    OurSong.pause();
                    sermono.setText(songs_urls[0] + "paused");
                    PLAY.setText("PAUSE");
                } else {

                    OurSong.start();
                    PLAY.setText("PLAY");
                     sermono.setText(songs_urls[0]);
                }


        }
    }}

