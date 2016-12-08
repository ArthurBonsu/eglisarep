package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pee on 8/29/2016.
 */

public class TRACKPOST extends AppCompatActivity implements View.OnClickListener {
    public TRACKPOST() {
        super();
    }

    final String TAG = this.getClass().getSimpleName();

    EditText naming = (EditText) findViewById(R.id.usedname);
    EditText passwording2 = (EditText) findViewById(R.id.usedname);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();


    EditText songtitle = (EditText) findViewById(R.id.songtitle);
    EditText song_url = (EditText) findViewById(R.id.song_url);
    EditText song_image_url = (EditText) findViewById(R.id.song_image_url);

    ImageButton trackpostback = (ImageButton) findViewById(R.id.trackpostback);
    FloatingActionButton trackpostfloat = (FloatingActionButton) findViewById(R.id.trackpostfloat);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trackspost);
    }


    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.trackpostback:
// We have to make a back page listener;

                break;

            case R.id.trackpostfloat:

                 String url = "http://127.0.0.1/songstream.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);

                    }


                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                if (volleyError instanceof com.android.volley.TimeoutError) {
                                    Toast.makeText(getApplicationContext(), "Time Out Error", Toast.LENGTH_SHORT).show();
                                } else if (volleyError instanceof com.android.volley.NoConnectionError) {
                                    Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_SHORT).show();

                                } else if (volleyError instanceof com.android.volley.AuthFailureError) {

                                    Toast.makeText(getApplicationContext(), "Authentication Failure Error", Toast.LENGTH_SHORT).show();
                                } else if (volleyError instanceof com.android.volley.NetworkError) {
                                    Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
                                } else if (volleyError instanceof com.android.volley.ServerError) {
                                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_SHORT).show();
                                } else if (volleyError instanceof com.android.volley.ParseError) {
                                    Toast.makeText(getApplicationContext(), "Parse Error", Toast.LENGTH_SHORT);
                                }
                            }


                        }) {

                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();

                        params.put("username", namingtext);
                        params.put("password", passwordtext);
                        params.put("songtitle", songtitle.getText().toString());
                        params.put("song_url", song_url.getText().toString());
                        params.put("song_image_url", song_image_url.getText().toString());
                        Toast.makeText(TRACKPOST.this, "Data entered", Toast.LENGTH_LONG).show();
                        return params;


                    }


                };
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                break;
        }
    }
}



