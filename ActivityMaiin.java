package com.gmail.peeman34.eglisaofficial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
 * Created by pee on 6/1/2016.
 */
public class ActivityMaiin extends AppCompatActivity {


    EditText etUsername, Password, btnLogin;
     final String TAG= this.getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             setContentView(R.layout.mainactivity22);

                etUsername =(EditText)findViewById(R.id.usedname);
    Password = (EditText)findViewById(R.id.passwd);
           btnLogin =(EditText)findViewById(R.id.Loginns);
              btnLogin.setOnClickListener( new View.OnClickListener() {
                  
                  /**
                   * Called when a view has been clicked.
                   *
                   * @param v The view that was clicked.
                   */
                  @Override
                  public void onClick(View v) {

                      String  url = "http://10.0.3.3/index.php";

                      StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                          @Override
                          public void onResponse(String response) {
                               Log.d(TAG, response);
                              if(response.contains("success_login")){
                                  Intent  in = new Intent(ActivityMaiin.this,MAINVIEW.class);
                                  startActivity(in);
                              }
                          else{
                                  Toast.makeText(getApplicationContext(),"Wrong username and password", Toast.LENGTH_SHORT).show();
                              }
                          }
                          }, new Response.ErrorListener() {

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

                          Map<String, String> getParams() throws AuthFailureError {
                              Map<String, String> params = new HashMap<String, String>();
                              params.put("txtUsername", etUsername.getText().toString());
                              params.put("txtPassword", Password.getText().toString());

                              return getParams();

                          }
                      });



                      MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                  }

                                });

    }
}

