package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
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

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by pee on 8/5/2016.
 */

public class EVENT_GRID_FILE extends AppCompatActivity {
    public EVENT_GRID_FILE() {
        super();
    }

    BindDictionary<Event_grid_filee> dict = new BindDictionary<Event_grid_filee>();

    TextView eventname = (TextView) findViewById(R.id.Eventname);

    TextView eventDate = (TextView) findViewById(R.id.Date);
    GridView eventgrid = (GridView) findViewById(R.id.GridView);
    TextView eventtime = (TextView) findViewById(R.id.event_time);
    EditText naming = (EditText) findViewById(R.id.usedname);
    EditText passwording2 = (EditText) findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    ImageView eventpic = (ImageView) findViewById(R.id.eventpic);
    final String TAG = this.getClass().getSimpleName();
    final Command command = new Command(getApplication());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventgridfile);
    }

    String url = "http://127.0.0.1/get_event.php";
    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        {
            dict.addStringField(R.id.Eventname,
                    new StringExtractor<Event_grid_filee>() {
                        @Override
                        public String getStringValue(Event_grid_filee item, int position) {
                            return item.eventname;
                        }

                    }
            );
             dict.addStringField(R.id.Date,
                    new StringExtractor<Event_grid_filee>() {
                        @Override
                        public String getStringValue(Event_grid_filee item, int position) {
                            return item.event_date;
                        }

                    }
            );


            dict.addStringField(R.id.event_time,
                    new StringExtractor<Event_grid_filee>() {
                        @Override
                        public String getStringValue(Event_grid_filee item, int position) {
                            return item.event_time;
                        }

                    }
            );

            dict.addDynamicImageField(R.id.GridView, new StringExtractor<Event_grid_filee>() {
                        @Override
                        public String getStringValue(Event_grid_filee item, int position) {
                            return item.event_pic;
                        }
                    }, new DynamicImageLoader() {
                        @Override
                        public void loadImage(String event_pic, ImageView eventpic) {
                            Picasso.with(getApplicationContext()).load("http://10.0.3.2/upload/" + event_pic).into(eventpic);
                            eventpic.setPadding(0, 0, 0, 0);
                            eventpic.setAdjustViewBounds(true);
                            // I have to change the values of the image loader

                            // ImageLoader.getImageListener(profilepic,R.id.imageView3, R.id.prfilepic);
                        }
                    }

            );

        }


        @Override
        public void onResponse(String response) {
            Log.d(TAG, response);

            ArrayList<Event_grid_filee> Event_grid_fileeList = new JsonConverter<Event_grid_filee>().toArrayList(response, Event_grid_filee.class);
            FunDapter<Event_grid_filee> adapter = new FunDapter<>(getApplicationContext(), Event_grid_fileeList, R.layout.membershipview, dict);
            eventgrid.setAdapter(adapter);

            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
            command.add(stringRequest);



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

            Toast.makeText(EVENT_GRID_FILE.this, "Data entered", Toast.LENGTH_LONG).show();

            command.execute();
            return params;

        }


    };


    }
