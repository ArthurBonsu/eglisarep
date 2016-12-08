package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import java.util.zip.DeflaterOutputStream;

/**
 * Created by pee on 7/29/2016.
 */

public class REPLY extends AppCompatActivity {
   EditText replytext = (EditText)findViewById(R.id.replytext);
    FloatingActionButton floatAction = (FloatingActionButton)findViewById(R.id.replyfloatingbutton);


    public REPLY() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.reply);
        String replytexts = replytext.getText().toString();


    }

    public FloatingActionButton getFloatAction() {

        return floatAction;
    }
}
