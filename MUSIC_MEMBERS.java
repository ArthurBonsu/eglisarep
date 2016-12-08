package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.gmail.peeman34.eglisaofficial.R.layout.musicmembers;

/**
 * Created by pee on 2/3/2016.
 */
public class MUSIC_MEMBERS extends Activity implements View.OnClickListener {
    public MUSIC_MEMBERS() {
        super();
    }

    final String TAG = this.getClass().getSimpleName();

    TextView musicalmembers = (TextView) findViewById(R.id.memberpane);
    ImageButton refresh = (ImageButton) findViewById(R.id.refreshmusicmember);
    EditText naming = (EditText) findViewById(R.id.usedname);
    EditText passwording2 = (EditText) findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    ListView memberlisto = (ListView) findViewById(R.id.memberlisto);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_members);

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */


    }

    @Override
    public void onClick(View v) {

    }
}

