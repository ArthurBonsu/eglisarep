package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
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
import com.amigold.fundapter.FunDapterUtils;
import com.squareup.picasso.Picasso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.wearable.DataMap.TAG;

/**
 * Created by pee on 1/7/2016.
 */
public class MEMBERSHIPVIEW extends Activity implements View.OnClickListener {


    Button refresh = (Button)findViewById(R.id.congregationrefresh);
    BindDictionary<Registera> dict = new BindDictionary<Registera>();
         ListView printname = (ListView)findViewById(R.id.printnames);
         ImageView profilepic = (ImageView)findViewById(R.id.Profilepic);

    final String TAG = this.getClass().getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membershipview);


        // I have to do an refresh button for it to pull the values from the internet
        refresh.setOnClickListener(this);
            String url;
                url = "http://127.0.0.1/registery.php";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        ArrayList<Registera> registeraArrayList  = new JsonConverter<Registera>().toArrayList(response, Registera.class);



                        FunDapter<Registera> adapter =new FunDapter<>(getApplicationContext(), registeraArrayList , R.layout.membershipview, dict);
                         printname.setAdapter(adapter);


                        dict.addStringField(R.id.NamesSection,
                                new StringExtractor<Registera>() {
                                    @Override
                                    public String getStringValue(Registera registera, int i) {
                                        return registera.name;
                                    }
                                }
                        );

                        dict.addStringField(R.id.membernumber,
                                new StringExtractor<Registera>() {
                                    @Override
                                    public String getStringValue(Registera registera, int i) {
                                        return registera.number;
                                    }
                                }
                        );
                        dict.addDynamicImageField(R.id.Profilepic, new StringExtractor<Registera>() {
                                    @Override
                                    public String getStringValue(Registera item, int position) {
                                        return item.picture;
                                    }
                                }, new DynamicImageLoader() {
                                    @Override
                                    public void loadImage(String picture, ImageView profilepic) {
                                            Picasso.with(getApplicationContext()).load("http://10.0.3.2/upload/" + picture).into(profilepic);
                                        profilepic.setPadding(0,0,0,0);
                                        profilepic.setAdjustViewBounds(true);
                                        // I have to change the values of the image loader

                                        // ImageLoader.getImageListener(profilepic,R.id.imageView3, R.id.prfilepic);
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



                        });


        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

                }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
        @Override
        public void onClick (View v){
            switch (getTaskId()) {
                //make a new refresh button refresh2;
                case R.id.refresh:


                break;
            }
        }

    }
