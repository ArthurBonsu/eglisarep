package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by pee on 2/4/2016.
 */
public class USHERINGPLAN extends Activity {
    public USHERINGPLAN() {
        super();
    }
TextView usherspane = (TextView)findViewById(R.id.usheringstrategy);
     String usherpanetext = usherspane.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.usheringplan);
      usherspane.setText(usherpanetext);
         // I have to get the ushering pane;
        // I have to create an ushering plan, post and get
     }

           }
