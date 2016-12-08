package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
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
public class MUSICINFOPLAN extends Activity {
    public MUSICINFOPLAN() {
        super();
    }
    final String TAG =this.getClass().getSimpleName();
     TextView infopane = (TextView)findViewById(R.id.infopane);
           String infotext = infopane.getText().toString();

    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.musicinfopane);
          infopane.setText(infotext);



 }

    String url= "http://127.0.0.1/musicinforeport.php";
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


        @Override
        public void onResponse(String response) {
            Log.d(TAG, response);
            ArrayList<MusicInfoPull> quoteArrayList   = new JsonConverter<MusicInfoPull>().toArrayList(response, MusicInfoPull.class);
            BindDictionary<MusicInfoPull> dict = new BindDictionary<MusicInfoPull>();




            dict.addStringField(R.id.usherspane,
                    new StringExtractor<MusicInfoPull>() {
                        @Override
                        public String getStringValue(MusicInfoPull musicInfoPull, int i) {
                            return musicInfoPull.musicinfo;
                        }
                    }
            );

        }


    },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    if (volleyError instanceof com.android.volley.TimeoutError) {
                        Toast.makeText(getApplicationContext(), "Time Out Error", Toast.LENGTH_SHORT).show();
                    }
                    else if (volleyError instanceof com.android.volley.NoConnectionError) {
                        Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_SHORT).show();

                    } else if (volleyError instanceof com.android.volley.AuthFailureError){

                        Toast.makeText(getApplicationContext(), "Authentication Failure Error", Toast.LENGTH_SHORT).show();
                    }
                    else if(volleyError instanceof  com.android.volley.NetworkError){
                        Toast.makeText(getApplicationContext(),"Network error", Toast.LENGTH_SHORT).show();
                    }
                    else  if(volleyError instanceof  com.android.volley.ServerError){
                        Toast.makeText(getApplicationContext(), "Server Error" , Toast.LENGTH_SHORT).show();
                    }
                    else if(volleyError instanceof  com.android.volley.ParseError){
                        Toast.makeText(getApplicationContext(), "Parse Error", Toast.LENGTH_SHORT );
                    }

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


}















