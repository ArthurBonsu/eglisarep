package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
 * Created by pee on 9/1/2016.
 */

public class GROUPCHAT extends AppCompatActivity implements View.OnClickListener{


    final String TAG = this.getClass().getSimpleName();
    final RecyclerView groupchatrecycler = (RecyclerView)findViewById(R.id.groupchatrecycler);


    EditText naming = (EditText) findViewById(R.id.usedname);
    EditText passwording2 = (EditText) findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();

    EditText churchname = (EditText) findViewById(R.id.getchurchname);
    EditText  location = (EditText)findViewById(R.id.getchurchlocation);
      TextView grouptitle = (TextView)findViewById(R.id.gettitle);
    String grouptitles = grouptitle.getText().toString();
    ImageView profilepicture = (ImageView)findViewById(R.id.profilepicture);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.groupchatroom);
        groupchatrecycler.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        groupchatrecycler.setLayoutManager(layoutManager);




        String url;
        url = "http://127.0.0.1/groupchatpage.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {




            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);

                final ArrayList<GroupChatList> groupChatListArrayList  = new JsonConverter<GroupChatList>().toArrayList(response,GroupChatList.class);


                GROUPCHATADAPTER groupchatadapter = new GROUPCHATADAPTER(groupChatListArrayList,getApplicationContext());
                groupchatrecycler.setAdapter(groupchatadapter);




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

                params.put("churchname", churchname.getText().toString());
                params.put("location", location.getText().toString());
                params.put("groupname", grouptitles);


                Toast.makeText(GROUPCHAT.this, "Data entered", Toast.LENGTH_LONG).show();

                return params;

            }

        };



        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }















    public GROUPCHAT() {
        super();
    }

    @Override
    public void onClick(View v) {
    switch (getTaskId()){
        case R.id.share:

            String url2 = "http://127.0.0.1/grouppagesendinfo.php";
            StringRequest stringRequest2 = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {




                @Override
                public void onResponse(String response) {
                    Log.d(TAG, response);

                    final ArrayList<GroupChatList> groupChatListArrayList  = new JsonConverter<GroupChatList>().toArrayList(response,GroupChatList.class);


                    GROUPCHATADAPTER groupchatadapter = new GROUPCHATADAPTER(groupChatListArrayList,getApplicationContext());
                    groupchatrecycler.setAdapter(groupchatadapter);




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

                    params.put("churchname", churchname.getText().toString());

                    params.put("groupname", grouptitles);


                    Toast.makeText(GROUPCHAT.this, "Data entered", Toast.LENGTH_LONG).show();

                    return params;

                }

            };

            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest2);

            break;
    }
    }
}

