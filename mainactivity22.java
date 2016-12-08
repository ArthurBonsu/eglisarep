package com.gmail.peeman34.eglisaofficial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.extractors.StringExtractor;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;

/**
 * Created by pee on 5/26/2016.
 */
public class mainactivity22 extends AppCompatActivity {

        final String TAG= this.getClass().getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity22);

        EditText username = (EditText)findViewById(R.id.usedname);
        EditText password  = (EditText)findViewById(R.id.passwd);
        Button login = (Button)findViewById(R.id.lgin);

        RequestQueue requestQueue;


        String url = "https://google.com";
        StringRequest stringRequest1 = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
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
        });

        url = "https://127.0.0.1/product.php";
        StringRequest stringRequest2 = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);

                // dictionary.addStringField(R.id.TvText, new StringExtractor<Product>())




            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });




       url = "https://10.0.3.2/product.php";
        StringRequest stringRequest3 = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });



        MySingleton.getInstance(this).addToRequestQueue(stringRequest1);
        MySingleton.getInstance(this).addToRequestQueue(stringRequest2);
        MySingleton.getInstance(this).addToRequestQueue(stringRequest3);
    }





    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p/>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}
     * <p/>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p/>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p/>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */

    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_eglisa__official, menu);

              return true;
            }
}
