package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

/**
 * Created by pee on 1/20/2016.
 */
public class Swipesetup extends Activity implements View.OnClickListener{
    public Swipesetup() {
        super();
    }
          Button backpressed = (Button)findViewById(R.id.backbuttonpressed);
    ViewPager viewpager2 = (ViewPager) findViewById(R.id.viewpager);
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.albumlook);

            Button Nextflip = (Button)findViewById(R.id.Nextflip);
             Nextflip.setOnClickListener(this);
             backpressed.setOnClickListener(this);
            Swipe adapter = new Swipe(this);
            viewpager2.setAdapter(adapter);


              }
    @Override
    public void onBackPressed() {
        if(viewpager2.getCurrentItem()==0){
            super.onBackPressed();
        }else {
            viewpager2.setCurrentItem(viewpager2.getCurrentItem()-1);
        }


    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (getTaskId()){
            case R.id.backbuttonpressed:
                 onBackPressed();
                break;
        }
           }
     }
