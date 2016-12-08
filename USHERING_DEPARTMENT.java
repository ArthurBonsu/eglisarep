package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pee on 1/30/2016.
 */
public class USHERING_DEPARTMENT extends Activity {
    public USHERING_DEPARTMENT() {
        super();
    }
    Button actionrole = (Button) findViewById(R.id.actionrole);
    Button ushersmembers = (Button) findViewById(R.id.visitationmembers);
    Button Viewleaders = (Button) findViewById(R.id.Viewleaders);
    Button ushersback = (Button) findViewById(R.id.ushersback);
    TextView usherspane = (TextView) findViewById(R.id.usherspane);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_department);
        actionrole.setOnClickListener((View.OnClickListener) this);
        ushersmembers.setOnClickListener((View.OnClickListener) this);
        Viewleaders.setOnClickListener((View.OnClickListener) this);
        ushersback.setOnClickListener((View.OnClickListener) this);
            usherspane.setOnClickListener((View.OnClickListener) this);
    }


    public void onClick(View v) throws ClassNotFoundException {
        switch (getTaskId()) {
            case R.id.actionrole:
                Intent  actionrole = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.ACTIONROLE"));
                    startActivity(actionrole);
                break;

            case R.id.visitationmembers:

                Intent ushermembers =new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.USHERINGMEMBERS"));
                startActivity(ushermembers);
                break;

            case R.id.Viewleaders:

             Intent usherleaders = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.USHERING_LEADERS"));
                startActivity(usherleaders);

                break;
            case R.id.usherspane:
                Intent ushersplan = new Intent(this, Class.forName("com.gmail.peeman34.eglisaofficial.USHERINGPLAN"));
                startActivity(ushersplan);
            case R.id.ushersback:

                break;
        }
    }

}
