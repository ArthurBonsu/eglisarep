package com.gmail.peeman34.eglisaofficial;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by pee on 8/5/2016.
 */

public class EVENT_CREATE extends FragmentActivity implements View.OnClickListener {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public EVENT_CREATE() {
        super();
    }


    EditText dateclick = (EditText) findViewById(R.id.datetaker);
      Button eventgetback = (Button) findViewById(R.id.eventgetback);
    FloatingActionButton get_eventfloat = (FloatingActionButton)findViewById(R.id.get_eventfloat);
    EditText Eventname = (EditText)findViewById(R.id.eventname);
    ImageView eventpic = (ImageView)findViewById(R.id.eventpic);
    EditText eventdescribed = (EditText)findViewById(R.id.eventdescribed);
     String eventnames= Eventname.getText().toString();
      String eventdescriber = eventdescribed.getText().toString();
            String datetaker = dateclick.getText().toString();





           // I have to get the time picker too over here..


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_create);
         eventgetback.setOnClickListener(this);

        dateclick.setOnFocusChangeListener(new View.OnFocusChangeListener() {


            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    PickerDialog pickerDialog = new PickerDialog();
                    pickerDialog.show(getSupportFragmentManager(), "date_picker");

                }
            }


        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("EVENT_CREATE Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    public void onClick(View v) {
        switch (getTaskId()){
            case R.id.eventgetback:
              //implement a back view listener
                break;
            case R.id.get_eventfloat:
                break;
        }
    }
}





