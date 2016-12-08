package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pee on 8/1/2016.
 */

public class HISTORY_ENTERY extends AppCompatActivity {


    public HISTORY_ENTERY() {
        super();
    }

    TextView Churchname = (TextView)findViewById(R.id.churchname);
    EditText writehistory = (EditText)findViewById(R.id.history_write);
    FloatingActionButton floathistory = (FloatingActionButton)findViewById(R.id.floathistory);
    final String TAG =this.getClass().getSimpleName();
    ImageButton send_historyback = (ImageButton)findViewById(R.id.sendhistoryback);
    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    String history_write = writehistory.getText().toString();
    String churchname =    Churchname.getText().toString();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_enter);
        // For churchname we get it from the registration of church

        //  Churchname.setText(R.id.churchnameregistered

    }











    String url
            = "http://127.0.0.1/send_history.php ";
    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


        @Override
        public void onResponse(String response) {
            Log.d(TAG, response);
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);



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


            }) {
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<String, String>();

            params.put("username", namingtext);
            params.put("password", passwordtext);
            params.put("writehistory", history_write);
            params.put("churchname", churchname);

            Toast.makeText(HISTORY_ENTERY.this, "Data entered", Toast.LENGTH_LONG).show();

            return params;

        }


    };
}
