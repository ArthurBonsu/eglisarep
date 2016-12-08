package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.android.photoutil.ImageBase64;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.gmail.peeman34.eglisaofficial.R.layout.main;

/**
 * Created by pee on 6/27/2016.
 */
public class QUOTES extends Activity {
    public QUOTES() {
        super();
    }
    final String TAG =this.getClass().getSimpleName();

    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    BindDictionary<Quote> dict = new BindDictionary<Quote>();


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
         setContentView(R.layout.generalle);}

    String url= "http://127.0.0.1/quotes.php";
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {


        @Override
        public void onResponse(String response) {
            Log.d(TAG, response);

            ArrayList<Quote> quoteArrayList   = new JsonConverter<Quote>().toArrayList(response, Quote.class);





            dict.addStringField(R.id.Quoteoftheday,
                    new StringExtractor<Quote>() {
                        @Override
                        public String getStringValue(Quote quote, int i) {
                            return quote.quote;
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

            String username;
            String password;
            params.put("username", namingtext);
            params.put("password", passwordtext);

            return  params;

        }




    };


}




























































