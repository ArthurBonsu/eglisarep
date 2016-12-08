package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.android.photoutil.ImageBase64;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.android.volley.VolleyLog.TAG;
import static com.gmail.peeman34.eglisaofficial.R.id.image;

/**
 * Created by pee on 2/13/2016.
 */
public class TRENDING extends Activity implements View.OnClickListener{
    public TRENDING() {
        super();
    }



    BindDictionary<trendingg> dict = new BindDictionary<trendingg>();


    EditText writesomethinghereto = (EditText)findViewById(R.id.writesomethinghere);
    TextView date = (TextView)findViewById(R.id.date);
    TextView hostname = (TextView)findViewById(R.id.hostname);
    TextView postname = (TextView)findViewById(R.id.commentpaste);
    Button Reply = (Button)findViewById(R.id.reply);
    Button Agree = (Button)findViewById(R.id.Agree);
    Button comment =( Button)findViewById(R.id.commentee);
    ListView lvProduct = (ListView) findViewById(R.id.lv_product);

    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    String writesomething = writesomethinghereto.getText().toString();
       ImageView profilepic = (ImageView)findViewById(R.id.Profilepic);
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
           setContentView(R.layout.trending);

              TextView pastecomment = (TextView)findViewById(R.id.commentpaste);

         Reply.setOnClickListener(this);
           Agree.setOnClickListener(this);
           comment.setOnClickListener(this);}


    String url="http://127.0.0.1/trending.php";
    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        {
            dict.addStringField(R.id.hostname,
                    new StringExtractor<trendingg>() {
                        @Override
                        public String getStringValue(trendingg item, int position) {
                            return item.name;
                        }

                    }
            );
            dict.addStringField(R.id.date,
                    new StringExtractor<trendingg>() {
                        @Override
                        public String getStringValue(trendingg item, int position) {
                            return item.date;
                        }


                    }
            );
            dict.addStringField(R.id.commentpaste,
                    new StringExtractor<trendingg>() {
                        @Override
                        public String getStringValue(trendingg item, int position) {
                            return item.chattext;
                        }

                    }
            );
             dict.addDynamicImageField(R.id.Profilepic, new StringExtractor<trendingg>() {
                 @Override
                 public String getStringValue(trendingg item, int position) {
                     return item.picture;
                 }
             }, new DynamicImageLoader() {
                 @Override
                 public void loadImage(String picture, ImageView profilepic) {
                   Picasso.with(getApplicationContext()).load("http://127.0.0.1/upload/" + picture).into(profilepic);
                          profilepic.setPadding(0,0,0,0);
                        profilepic.setAdjustViewBounds(true);

                 }
             }

        );

        }



        @Override
        public void onResponse(String response) {
            Log.d(TAG, response);

            ArrayList<Product> jsonObjects = new JsonConverter<Product>().toArrayList(response, Product.class);


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
                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
                }


            }) {

        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<String, String>();

            params.put("username", namingtext);
            params.put("password", passwordtext);
            params.put("writesomething", writesomething);

            Toast.makeText(TRENDING.this, "Data entered", Toast.LENGTH_LONG).show();

            return params;
        }







/*

                      }
                  },
                          new Response.ErrorListener() {
                              @Override
                              public void onErrorResponse(VolleyError volleyError) {
                                  Toast.makeText(getApplicationContext(), "Error while reading data", Toast.LENGTH_SHORT).show();
                              }


                          }) {

                      4 String encodedString = ImageBase64.encode(image);
                      protected Map<String, String> getParams() throws AuthFailureError {
                          Map<String, String> params = new HashMap<String, String>();
                           params.put("image",encodedString);


                          return params;


                      }

                      ;


                  };


                  LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                  Profilepic.setLayoutParams(layoutParams);
                  Profilepic.setScaleType(ImageView.ScaleType.FIT_CENTER);
                  Profilepic.setPadding(0, 0, 0, 10);
                  Profilepic.setAdjustViewBounds(true);

                  Profilepic.setImageBitmap(image);

                  command.add(stringRequest);

                  MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

              } catch (FileNotFoundException e) {
                  e.printStackTrace();
                  //show a message showing image is unavailable
                  Toast.makeText(this, "Unable to open Image", Toast.LENGTH_LONG).show();
              }

              command.execute();

              }


      }
 }

}
*/



    };


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
      switch (getTaskId()){
          case R.id.reply:
              Intent reply = null;
              try {
                  reply = new Intent(this,Class.forName("com.gmail.peeman34.eglisaofficial.REPLY"));
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();
              }

              startActivity(reply);
              break;


                    //I have to build the reply of the application context
              // I have to create a reply box and a reply activity

                              // we have to make another textview  or another send reply








        case R.id.Agree:
                  // I have to buildd the application context
                   // I have to make an image that changes when the image is changed.

              Toast.makeText(getApplicationContext(), "Agreed", Toast.LENGTH_SHORT).show();


                break;


          case R.id.commentee:
              try {
                  Intent sendmessage = new Intent(this, Class.forName("com.gmail.peeman34.SEND_MESSAGE"));
                  startActivity(sendmessage);
              } catch (ClassNotFoundException e) {
                  e.printStackTrace();

              }
                 break;
      }
      }

}

