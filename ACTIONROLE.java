package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by pee on 1/30/2016.
 */

public class ACTIONROLE extends Activity {
    public ACTIONROLE() {
        super();
    }
TextView actionpane = (TextView)findViewById(R.id.actionpane);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.actionpane);


    }
 }
