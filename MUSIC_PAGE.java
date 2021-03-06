package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by pee on 1/24/2016.
 */
public class MUSIC_PAGE extends Activity implements View.OnClickListener {
    public MUSIC_PAGE() {
        super();
    }

    final String songs_urls[] = {
            "http://www.sermonaudio.com/sermoninfo.asp?sermonID=12161921362",
            "http://www.sermonaudio.com/sermoninfo.asp?SID=12161921362LO=true",
            "http://www.sermonaudio.com/sermoninfo.asp?SID=1221151626108LO=true",
             "http://www.playvideo.sa-media.com/media/1221151626108/1221151626108.mp4"};
    TextView FirstSongtext = (TextView) findViewById(R.id.firstsongtext);
    TextView Secondsongtext = (TextView) findViewById(R.id.secondsongtext);
    TextView Thirdsongtext = (TextView) findViewById(R.id.thirdsongtext);
    TextView Forthsongtext = (TextView) findViewById(R.id.forthsongtext);
    ImageButton firstimage = (ImageButton) findViewById(R.id.firstsongimage);
    ImageButton secondimage = (ImageButton) findViewById(R.id.secondsongimage);
    ImageButton thirdimage = (ImageButton) findViewById(R.id.thirdsongimage);
    ImageButton fourthimage = (ImageButton) findViewById(R.id.fourthsongimage);
     SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicpage);

        firstimage.setOnClickListener(this);
        secondimage.setOnClickListener(this);
        thirdimage.setOnClickListener(this);
        fourthimage.setOnClickListener(this);

             final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
              int maxvolume =audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
               int curvolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBar.setMax(maxvolume);
        seekBar.setProgress(curvolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.firstsongimage:

                try {

                    MediaPlayer Media1 = new MediaPlayer();
                    Media1.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    Media1.setDataSource(String.valueOf(songs_urls[0]));
                    Media1.prepare();
                    Media1.start();

                    if (Media1.isPlaying()) {
                        Media1.pause();

                    }
                    FirstSongtext.setText(songs_urls[0]);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                        break;

            case R.id.secondsongimage:
                try {


                    MediaPlayer Media1 = new MediaPlayer();
                    Media1.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    Media1.setDataSource(String.valueOf(songs_urls[1]));
                    Media1.prepare();
                    Media1.start();

                    if (Media1.isPlaying()) {
                        Media1.pause();

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                     Secondsongtext.setText(songs_urls[1]);
                break;

            case R.id.thirdsongimage:
                try {


                    MediaPlayer Media1 = new MediaPlayer();
                    Media1.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    Media1.setDataSource(String.valueOf(songs_urls[2]));
                    Media1.prepare();
                    Media1.start();

                    if (Media1.isPlaying()) {
                        Media1.pause();

                    }
                       Thirdsongtext.setText(songs_urls[2]);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case R.id.fourthsongimage:
                try {


                    MediaPlayer Media1 = new MediaPlayer();
                    Media1.setAudioStreamType(AudioManager.STREAM_MUSIC);

                    Media1.setDataSource(String.valueOf(songs_urls[3]));
                    Media1.prepare();
                    Media1.start();

                    if (Media1.isPlaying()) {
                        Media1.pause();

                    }
                    Forthsongtext.setText(songs_urls[3]);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
        }
    }
}