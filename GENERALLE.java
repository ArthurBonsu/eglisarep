package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pee on 2/3/2016.
 */
public class GENERALLE extends Activity implements View.OnClickListener {
    public GENERALLE() {
        super();
    }

    ImageView Generalpic = (ImageView)findViewById(R.id.Profilepic);
    Button setprofilepicture = (Button)findViewById(R.id.setprofilepic);
    Button viewalbum = (Button)findViewById(R.id.viewalbum);
    Button PLAYEE = (Button)findViewById(R.id.announcement);
    Button announcement = (Button)findViewById(R.id.announcement);
    Button sendmessage =(Button)findViewById(R.id.sendmessage);
    TextView quoteoftheday = (TextView)findViewById(R.id.Quoteoftheday);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.generalle);

        Generalpic.setOnClickListener(this);
           setprofilepicture.setOnClickListener(this);
            viewalbum.setOnClickListener(this);
             PLAYEE.setOnClickListener(this);
             announcement.setOnClickListener(this);
               sendmessage.setOnClickListener(this);
                quoteoftheday.setOnClickListener(this);

                  }

    @Override
    public void onClick(View v) {
        switch (getTaskId()){
        case R.id.setprofilepic:

            try {
                Intent ALBUM_PHOTOGRAPHY = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.ALBUM_PHOTOGRAPHY"));
                startActivity(ALBUM_PHOTOGRAPHY);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            break;

            case R.id.viewalbum:
                try {
                    Intent Swiping = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.Swipesetup"));
                    startActivity(Swiping);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                break;

            case R.id.PLAYEE:

                try {
                    Intent SERMON = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.LATEST_MESSAGE"));
                    startActivity(SERMON);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.announcement:
                Intent announcement = null;
                try {
                    announcement = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.ANNOUNCEMENT"));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                startActivity(announcement);

                break;
            case R.id.sendmessage:
                try {
                    Intent sendmessage  = new Intent(this,  Class.forName("com.gmail.peeman34.eglisaofficial.SEND_COMMENT"));
                    startActivity(sendmessage);}
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                break;
    }
}}
