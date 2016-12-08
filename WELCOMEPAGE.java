package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by pee on 1/12/2016.
 */
public class WELCOMEPAGE extends Activity implements View.OnClickListener {
   private SharedPreferences SharedPrefs;
    private  String username, password ,displaymessage;
    private  static String USERNAME_KEY = "username";
    private  static  String PASSWORD_KEY ="password";
    private  final static String SAVED_KEY ="saved";
      private  boolean isSaved= false;
  TextView welcomoo = (TextView)findViewById(R.id.welcomoo);

     Button GENERAL = (Button)findViewById(R.id.GENERAL);
     Button MUSICWORLD = (Button)findViewById(R.id.MUSICWORLD);
    Button USHERING = (Button)findViewById(R.id.USHERINGWORLD);
     Button VISITATION = (Button)findViewById(R.id.VISITATION);




    public WELCOMEPAGE() {
        super();
           setContentView(R.layout.welcome_page);
      init();
        isSaved = SharedPrefs.getBoolean(SAVED_KEY, false);
         username=  SharedPrefs.getString(USERNAME_KEY, "");

    }
     private void init(){
         SharedPrefs =  getSharedPreferences("SharedPrefs", MODE_PRIVATE);
               displaymessage = "Welcome back " +  username ;

        if(isSaved) {
            welcomoo.setText(displaymessage);
        }
         GENERAL.setOnClickListener(this);
         MUSICWORLD.setOnClickListener(this);
         USHERING.setOnClickListener(this);
          VISITATION.setOnClickListener(this);
     }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
          switch (getTaskId()){
              case R.id.GENERAL:
                  try {
                      Intent generalle = new Intent(this,  Class.forName("com.gmail.peeman34.eglisaofficial.GENERALLE"));
                      startActivity(generalle);
                  } catch (ClassNotFoundException e) {
                      e.printStackTrace();
                  }


                  break;
              case R.id.MUSICWORLD:

                  try {
                      Intent musicdepartment = new Intent(this,  Class.forName("com.gmail.peeman34.eglisaofficial.MUSICDEPARTMENT"));
                      startActivity(musicdepartment);
                  } catch (ClassNotFoundException e) {
                      e.printStackTrace();
                  }

                  break;
              case R.id.USHERINGWORLD:

                  try {
                      Intent usheringdepartment = new Intent(this,  Class.forName("com.gmail.peeman34.eglisaofficial.USHERINGDEPARTMENT"));
                      startActivity(usheringdepartment);
                  } catch (ClassNotFoundException e) {
                      e.printStackTrace();
                  }

                  break;
              case R.id.VISITATION:

                  try {
                      Intent visitationdept = new Intent(this,  Class.forName("com.gmail.peeman34.eglisaofficial.VISITATIONDEPT"));
                      startActivity(visitationdept);
                  } catch (ClassNotFoundException e) {
                      e.printStackTrace();
                  }

                  break;
          }
    }
}



