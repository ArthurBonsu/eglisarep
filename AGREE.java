package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by pee on 7/29/2016.
 */

public class AGREE extends AppCompatActivity implements View.OnClickListener {

    Button Agree = (Button) findViewById(R.id.Agree);

      // I have to send the data to the server to process
    public AGREE() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trending);
        Agree.setOnClickListener(this);
    }

    int counter = 0;

    boolean state = false;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int countereached = 0;
        outState.putInt("counterreached", countereached);
    }

    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            // I have to make a text place where it has to show the text
            case R.id.Agree:
                if (state == false) {
                    int counterreached = counter++;
                    Agree.setText("Unagree" + counterreached);

                    state = true;
                 break;
                } else {
                    Toast.makeText(getApplicationContext(), "Already Agreed", Toast.LENGTH_SHORT);
                    int counterreached = counter - 1;
                    Agree.setText("Agreed" + counterreached);
                }
                state = false;
                break;
        }

    }
}