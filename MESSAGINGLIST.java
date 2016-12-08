package com.gmail.peeman34.eglisaofficial;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.R.attr.data;
import static com.google.android.gms.wearable.DataMap.TAG;

/**
 * Created by pee on 8/15/2016.
 */

public class MESSAGINGLIST extends AppCompatActivity {


    final String TAG = this.getClass().getSimpleName();
    final RecyclerView     messaginglistrecycler = (RecyclerView)findViewById(R.id.messaginglistrecycler);


    public MESSAGINGLIST() {
        super();
    }



      @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.messaginglist);
          messaginglistrecycler.setHasFixedSize(true);

          LinearLayoutManager  layoutManager = new LinearLayoutManager(this);
          messaginglistrecycler.setLayoutManager(layoutManager);


          String url;
        url = "http://127.0.0.1/registery.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {




            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);

                final ArrayList<MessageList> messagelisting  = new JsonConverter<MessageList>().toArrayList(response,MessageList.class);


                       Messageradapter messageradapter = new Messageradapter(messagelisting,getApplicationContext());
                           messaginglistrecycler.setAdapter(messageradapter);




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



                });


        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }
    }




