package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pee on 9/5/2016.
 */

public class ADMINPAGE extends AppCompatActivity implements View.OnClickListener {

    final String TAG = this.getClass().getSimpleName();

    EditText naming = (EditText) findViewById(R.id.usedname);
    EditText passwording2 = (EditText) findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    Button Login = (Button) findViewById(R.id.adminlogin);


    public ADMINPAGE() {
        super();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminpage);
        Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.adminlogin:

                String url = "http://127.0.0.1/adminlogin.php";
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

                        Toast.makeText(ADMINPAGE.this, "Data entered", Toast.LENGTH_LONG).show();
                        return params;


                    }


                };
                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

                break;

// We have to make a back page listener;


        }
    }
}