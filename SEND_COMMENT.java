package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
 * Created by pee on 2/13/2016.
 */
public class SEND_COMMENT extends Activity implements View.OnClickListener  {
    public SEND_COMMENT() {
        super();
    }

    final String TAG =this.getClass().getSimpleName();

    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();

    EditText commentwriter = (EditText)findViewById(R.id.commentwriter);

    TextView commentpaste =  (TextView)findViewById(R.id.commentpaste);
    Button comment = (Button)findViewById(R.id.comment);
      Button commentback = (Button)findViewById(R.id.commentback);

    String message = commentwriter.getText().toString();


    /**
     * Return the intent that started this activity.
     */
    @Override
    public Intent getIntent() {
        return super.getIntent();
    }

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p/>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p/>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
          setContentView(R.layout.sendcomment);

        comment.setOnClickListener(this);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.comment:
                commentpaste.setText(message);
                String url
                 = "http://127.0.0.1/Sendincomment.php ";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        ArrayList<Commentee> jsonObjects = new JsonConverter<Commentee>().toArrayList(response, Commentee.class);
                        TableLayout datatable = (TableLayout) findViewById(R.id.DATATABLE);


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
                        params.put("commentpaste", message);


                        Toast.makeText(SEND_COMMENT.this, "Data entered", Toast.LENGTH_LONG).show();

                        return params;

                    }


                };
          break;
              case R.id.commentback:
                Intent trending = null;
                try {
                    trending = new Intent(String.valueOf(Class.forName("com.gmail.peeman34.eglisaofficial.TRENDING")));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                startActivity(trending);

// I have to use volley to do that now


        }

    }}