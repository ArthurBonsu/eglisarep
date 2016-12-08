package com.gmail.peeman34.eglisaofficial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pee on 8/17/2016.
 */

public class MessageDetails extends AppCompatActivity  implements  View.OnClickListener{
    ImageView  d_person_img = (ImageView)findViewById(R.id.person_img);

    TextView d_person_name = (TextView)findViewById(R.id.d_person_name);
    TextView d_person_number = (TextView)findViewById(R.id.d_person_number);
     ImageButton person_call = (ImageButton) findViewById(R.id.person_call);
      ImageButton messagebutton = (ImageButton)findViewById(R.id.messagebutton);

    public MessageDetails() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.messagingdetails);
                    d_person_img.setImageResource(getIntent().getIntExtra("img_id",00));
                    d_person_name.setText("Name   :" + getIntent().getStringExtra("person_name"));
                    d_person_number.setText("Mobile  :"  +getIntent().getStringExtra("person_number") );
                   person_call.setOnClickListener( this);
                        messagebutton.setOnClickListener(this);}

    @Override
    public void onClick(View v) {
         switch (getTaskId()){
             case  R.id.person_call:
                // I have to implement a volley call with this
                 break;
             case R.id.messagebutton:
                 try {
                     d_person_name.setText(getIntent().getStringExtra("person_name"));
                      Intent CHATAPP = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.CHATAPP"));
                     startActivity(CHATAPP);
                 } catch (ClassNotFoundException e) {
                     e.printStackTrace();
                 }
                 break;
         }
          }
  }
