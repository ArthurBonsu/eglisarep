package com.gmail.peeman34.eglisaofficial;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class EGLISA_OFFICIAL extends AppCompatActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eglisa_official);
        final ImageView iv = (ImageView)findViewById(R.id.homescreen);
                iv.setBackgroundResource(R.drawable.anim);
           iv.setOnClickListener(new View.OnClickListener() {

               @Override
               public void onClick(View v) {
                   AnimationDrawable anim  = (AnimationDrawable)iv.getBackground();
                      anim.start();               }
           });
      }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eglisa__official, menu);
            int groupID = 0;
            int settingsID=R.id.action_settings;
            int menuitemorder= Menu.NONE;
            int settingsitemtext = R.string.action_settings;
            int aboutID = R.id.action_about;
            int  abouttext = R.string.action_about;
        // Creating a menu ITEM
        MenuItem SETTINGS = menu.add(groupID, settingsID,menuitemorder, settingsitemtext);
        MenuItem ABOUT = menu.add(groupID, aboutID ,menuitemorder,abouttext);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Loading settings.....", Toast.LENGTH_SHORT).show();



                Class Actionia = null;
                try {
                    Actionia = Class.forName("com.gmail.peeman34.eglisaofficial.SETTINGSACTION");
                    Intent StartAction = new Intent(EGLISA_OFFICIAL.this, Actionia);
                    startActivity(StartAction);


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return true;


        }
        else if ( id == R.id.action_about){
            Toast.makeText(getApplicationContext(), "Loading about.....", Toast.LENGTH_SHORT).show();
            Class Abouta = null;
            try {
                Abouta = Class.forName("com.gmail.peeman34.eglisaofficial.ABOUTVIEW");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Intent StartAbouta = new Intent(EGLISA_OFFICIAL.this, Abouta);
             startActivity(StartAbouta);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
