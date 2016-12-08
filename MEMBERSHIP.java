package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

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
 * Created by pee on 7/27/2016.
 */

public class MEMBERSHIP extends AppCompatActivity {

    public MEMBERSHIP() {
        super();
    }

    EditText membernames = (EditText) findViewById(R.id.namering);
    EditText lastnames = (EditText) findViewById(R.id.lastname);
    EditText other = (EditText) findViewById(R.id.otherss);
    EditText email = (EditText) findViewById(R.id.emailee);

    EditText passwords = (EditText) findViewById(R.id.memberpassword);
    EditText telephonenumber = (EditText) findViewById(R.id.membernumber);

    String memernames = membernames.getText().toString();
    String lastname = lastnames.getText().toString();
    String others = other.getText().toString();
    String passworder = passwords.getText().toString();
    String emailer = email.getText().toString();
    String telephonenumb = telephonenumber.getText().toString();
    final String TAG = this.getClass().getSimpleName();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);

        String url
                = "http://127.0.0.1/membershipregister.php ";
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
                params.put("name", String.valueOf(membernames));
                params.put("lastname", lastname);
                params.put("othernames", others);
                params.put("password", passworder);
                params.put("emailer", emailer);
                params.put("number", telephonenumb);


                Toast.makeText(MEMBERSHIP.this, "Data entered", Toast.LENGTH_LONG).show();

                return params;

            }


        };
          MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }




    }



