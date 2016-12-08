package com.gmail.peeman34.eglisaofficial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
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
 * Created by pee on 8/12/2016.
 */

public class SEND_MESSAGE extends AppCompatActivity implements View.OnClickListener {

    final String TAG = this.getClass().getSimpleName();

    EditText naming = (EditText) findViewById(R.id.usedname);
    EditText passwording2 = (EditText) findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();

    EditText messagewriter = (EditText) findViewById(R.id.messagewriter);

    TextView messagepaste = (TextView) findViewById(R.id.messagepaste);
    Button message = (Button) findViewById(R.id.message);
        Button messageback = (Button)findViewById(R.id.messageback);
    String messagesent = message.getText().toString();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendmessage);
        message.setOnClickListener(this);
           messageback.setOnClickListener(this);}

    public SEND_MESSAGE() {
        super();
    }


    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.message:

                String url
                        = "http://127.0.0.1/Sendinmessage.php ";
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
                        params.put("messagepaste", messagesent);


                        Toast.makeText(SEND_MESSAGE.this, "Data entered", Toast.LENGTH_LONG).show();

                        return params;

                    }


                };
              break;
            case R.id.messageback:
                Intent GENERALLE = null;
                try {
                    GENERALLE = new Intent(String.valueOf(Class.forName("com.gmail.peeman34.eglisaofficial.GENERALLE")));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                 startActivity(GENERALLE);
        }

    }
}
