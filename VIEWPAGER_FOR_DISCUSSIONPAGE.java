package com.gmail.peeman34.eglisaofficial;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pee on 8/3/2016.
 */

public class VIEWPAGER_FOR_DISCUSSIONPAGE extends FragmentActivity {
    public static String POSITION = "POSITION";

    ViewPager viewPager = null;

         Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        TabLayout tablayout = (TabLayout) findViewById(R.id.tabs);

       private int[]tabIcons ={
                R.drawable.mehappy,R.drawable.mewatching, R.drawable.musichomepic
       };
     private  String[]tabTitles = new String[] {"DISCUSSION", "DOORSTEP", "ONE-ON-ONE"

     };

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
                outState.putInt(POSITION, tablayout.getSelectedTabPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       viewPager.setCurrentItem(savedInstanceState.getInt(POSITION));
        }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);


        setContentView(R.layout.viewpager_for_discussionpage);
        viewPager = (ViewPager) findViewById(R.id.discussionviewpager);


        FragmentManager fragmentmanager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentmanager));
         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
        tablayout.setupWithViewPager(viewPager);
        setupTabIcons();

                   setActionBar(toolbar);
                  getActionBar().setDisplayHomeAsUpEnabled(true);





    }

private void setupTabIcons(){
    tablayout.getTabAt(0).setIcon(tabIcons[0]);
    tablayout.getTabAt(1).setIcon(tabIcons[1]);
    tablayout.getTabAt(2).setIcon(tabIcons[2]);
}

    @Override
    public void setActionBar(android.widget.Toolbar toolbar) {

        super.setActionBar(toolbar);
    }






    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0) {
                fragment = new SCROLL_TAB_ACTIVITY();
            }
            if (position == 1) {
                 fragment= new SCROLL_TAB_ACTIVITY_BPLUS();
            }
            if (position == 2) {
                fragment = new SCROLL_TAB_ACTIVITY_CPLUS();
            }


            return fragment;


        }

        @Override
        public int getCount() {
            Log.d("VIVZ", "get Count called");
            return 3;

        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return tabTitles[0];
            }
            if (position == 1) {
                return tabTitles[1];
            }

            if (position == 2) {
                return tabTitles[2];
            }

            Drawable image = ContextCompat.getDrawable(getApplicationContext(),tabIcons[position]);
            image.setBounds(0,0, image.getIntrinsicWidth(),image.getIntrinsicHeight());
            SpannableString sb = new SpannableString("" + tabTitles[position]);
            ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
            sb.setSpan(imageSpan, 0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            return  sb;
        }

    }
}