package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.wearable.DataMap.TAG;

/**
 * Created by pee on 1/5/2016.
 */


public class ABOUTVIEW extends Activity {
  TextView AboutText = (TextView) findViewById(R.id.AboutText);
    TextView AboutStory = (TextView) findViewById(R.id.AboutStory);
    final String TAG = this.getClass().getSimpleName();
    BindDictionary<Aboutviewpull> dict = new BindDictionary<Aboutviewpull>();
    public ABOUTVIEW() {
        super();
    }

    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    TextView Churchname = (TextView)findViewById(R.id.churchname);
    String churchname =    Churchname.getText().toString();

     FloatingActionButton back = (FloatingActionButton)findViewById(R.id.gobackabout);
// I have to make the page back to the previous page



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutview);

         AboutText.setText(R.string.about_text);
         AboutStory.setText(R.string.about_story);

        String url;
        url = "http://127.0.0.1/getabout.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
                ArrayList<Aboutviewpull> AboutViewArrayList  = new JsonConverter<Aboutviewpull>().toArrayList(response, Aboutviewpull.class);





                dict.addStringField(R.id.AboutStory,
                        new StringExtractor<Aboutviewpull>() {
                            @Override
                            public String getStringValue(Aboutviewpull aboutviewpull, int i) {
                                return String.valueOf(aboutviewpull.churchname);
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

                params.put("username", namingtext);
                params.put("password", passwordtext);
                params.put("churchname", churchname);


                Toast.makeText(ABOUTVIEW.this, "Data entered", Toast.LENGTH_LONG).show();

                return params;

            }


        };MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);}}
