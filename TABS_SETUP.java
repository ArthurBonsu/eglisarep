package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by pee on 8/3/2016.
 */

      public class TABS_SETUP extends Activity {
        @Override
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.chatroom);

            TabHost tabs=(TabHost)findViewById(R.id.tabhost);

            tabs.setup();

            TabHost.TabSpec spec=tabs.newTabSpec("tag1");

            spec.setContent(R.id.tab1);
            spec.setIndicator("Clock");
            tabs.addTab(spec);

            spec=tabs.newTabSpec("tag2");
            spec.setContent(R.id.tab2);
            spec.setIndicator("Button");
            tabs.addTab(spec);

            spec=tabs.newTabSpec("tag2");
            spec.setContent(R.id.tab3);
            spec.setIndicator("Button");
            tabs.addTab(spec);



        }
    }
