package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pee on 2/4/2016.
 */
public class ANNOUNCEMENT extends Activity{

    public ANNOUNCEMENT() {
        super();
    }

    final String TAG =this.getClass().getSimpleName();

    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
ListView announcementlist = (ListView)findViewById(R.id.announcementlist);
    TextView announcementpane = (TextView)findViewById(R.id.announcement);
    BindDictionary<Announcement11> dictionary = new BindDictionary<Announcement11>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement);

// I need to paste the the data we get from announcechat;
        String url;
        url = "http://127.0.0.1/announcement.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);


                ArrayList<Announcement11> announcementarraylist = new JsonConverter<Announcement11>().toArrayList(response, Announcement11.class);

                FunDapter<Announcement11> adapter =new FunDapter<>(getApplicationContext(), announcementarraylist , R.layout.membershipview, dictionary);
                announcementlist.setAdapter(adapter);

                BindDictionary<Announcement11> dictionary = new BindDictionary<>();
                dictionary.addStringField(R.id.announcement,
                        new StringExtractor<Announcement11>() {
                            @Override
                            public String getStringValue(Announcement11 announcementee, int i) {
                                return announcementee.announcement;
                            }
                        }
                );

            }


        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(getApplicationContext(), "Error while reading data", Toast.LENGTH_SHORT).show();
                    }


                })

        {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                String username;
                String password;
                params.put("username", namingtext);
                params.put("password", passwordtext);

                return  params;

            }



        };

        }}

