package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by pee on 2/5/2016.
 */
public class CHATAPP extends Activity implements  View.OnClickListener {


    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    TextView d_person_name = (TextView)findViewById(R.id.d_person_name);
        String receiver = d_person_name.getText().toString();

    private ChatArrayAdapter adp;
    private ListView list;
    private EditText chatText;
    private Button send;
    Intent in;
    private boolean side = false;

    public CHATAPP() {
        super();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent i = getIntent();

        send = (Button) findViewById(R.id.btn);

        list = (ListView) findViewById(R.id.chatlist);

        adp = new ChatArrayAdapter(getApplicationContext(), R.layout.chat);

        chatText = (EditText) findViewById(R.id.chat);
        send.setOnClickListener(this);

        chatText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER)


                        // I have to fix the onKeyListener.............................................

                        return true;
                }
                return false;
            }

        });



                        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
                list.setAdapter(adp);
                adp.registerDataSetObserver(new

                                                    DataSetObserver() {
                                                        /**
                                                         * This method is called when the entire data set has changed,
                                                         * most likely through a call to {@link Cursor#requery()} on a {@link Cursor}.
                                                         */
                                                        @Override
                                                        public void onChanged() {
                                                            super.onChanged();
                                                            list.setSelection(adp.getCount());
                                                        }
                                                    }

                );
            }


            private boolean sendChatMessage() {
                adp.add(new ChatMessage(side, chatText.getText().toString()));
                chatText.setText("");
                side = !side;
                return true;


            }

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             *
             *
             */
            @Override
            public void onClick(View v) {
                switch (getTaskId()) {
                    case R.id.btn:
                        sendChatMessage();
                        // This is the local view,we will implement the sending part after you press send

                        // We will have to build a serialized name for it
                       final String chattext = chatText.getText().toString();

                        String url;
                        url = "http://127.0.0.1/sendchatmessage.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


                            @Override
                            public void onResponse(String response) {
                                Log.d(TAG, response);
                                ArrayList<Registera> registeraArrayList  = new JsonConverter<Registera>().toArrayList(response, Registera.class);






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
                        params.put("chattext", chattext);
                            params.put("username", namingtext);
                            params.put("password", passwordtext);
                             params.put("receiver", receiver);


                            Toast.makeText(CHATAPP.this, "Data entered", Toast.LENGTH_LONG).show();

                        return params;

                    }


                    };


                        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

                }

                String url;
                url = "http://127.0.0.1/getchatmessageback.php";
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, response);
                        ArrayList<Registera> registeraArrayList  = new JsonConverter<Registera>().toArrayList(response, Registera.class);






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


                        Toast.makeText(CHATAPP.this, "Data entered", Toast.LENGTH_LONG).show();

                        return params;

                    }


                };


                MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

            }


}



