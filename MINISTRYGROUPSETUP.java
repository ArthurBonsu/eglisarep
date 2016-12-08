package com.gmail.peeman34.eglisaofficial;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.*;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.gmail.peeman34.eglisaofficial.R.id.groupdescription;
import static com.gmail.peeman34.eglisaofficial.R.id.toolbar;
import static com.gmail.peeman34.eglisaofficial.R.string.view;

/**
 * Created by pee on 7/28/2016.
 */

public class MINISTRYGROUPSETUP extends AppCompatActivity implements  View.OnClickListener{
    public MINISTRYGROUPSETUP() {
        super();

      Toolbar  toolbar = (Toolbar) findViewById(R.id.ministrygrouptoolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        EditText groupdescription = (EditText)findViewById(R.id.groupdescription);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ministry_group_setup);

        ImageButton about = new ImageButton(this);
        about.setImageResource(R.drawable.aboutlabel);

        ImageButton history = new ImageButton(this);
        history.setImageResource(R.drawable.historylabel);

    }

    @Override
    public void onClick(View v) {


    }
}

