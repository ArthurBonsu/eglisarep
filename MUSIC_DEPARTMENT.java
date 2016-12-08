package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pee on 1/29/2016.
 */
public class MUSIC_DEPARTMENT extends Activity implements View.OnClickListener {
    public MUSIC_DEPARTMENT() {
        super();
    }

    Button membersonline = (Button) findViewById(R.id.membersonline);
    Button groupalbum = (Button) findViewById(R.id.groupalbum);
    Button rehearsalroom = (Button) findViewById(R.id.rehearsalroom);
    Button musicback = (Button) findViewById(R.id.musicgoback);
    TextView infopane = (TextView) findViewById(R.id.infopane);
      ImageView musichomepic= (ImageView)findViewById(R.id.music_home_page);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_department);

        membersonline.setOnClickListener(this);
        groupalbum.setOnClickListener(this);
        rehearsalroom.setOnClickListener(this);
        musicback.setOnClickListener(this);
         infopane.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.visitationmembers:
                try {
                     Intent musicmembers = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.MUSIC_MEMBERS"));
                     startActivity(musicmembers);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            case R.id.actionrole:

                try {
                    Intent weeksong = new Intent(this,Class.forName("com.gmail.peeman34.eglisaofficial.MUSIC_PAGE") );
                     startActivity(weeksong);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.infopane:
                Intent infopane = null;
                try {
                    infopane = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.MUSICINFOPLAN"));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                startActivity(infopane);
                break;

            case R.id.rehearsalroom:

                break;

            case R.id.ushersback:

                break;
        }
    }

}