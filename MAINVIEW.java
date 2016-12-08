package com.gmail.peeman34.eglisaofficial;

import android.app.ListActivity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pee on 1/5/2016.
 */
public class MAINVIEW extends ListActivity {



    RecyclerView mainview  = (RecyclerView) findViewById(R.id.mainview);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);

        mainview.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mainview.setLayoutManager(manager);

        ArrayList<Mainlist> mainlistArrayList = generateDummy();
           MAINVIEWADAPTER mainviewadapter = new MAINVIEWADAPTER(this, mainlistArrayList);
                   mainview.setAdapter(mainviewadapter);
    }
  // have to add the image urls here

     private  ArrayList<Mainlist>generateDummy() {
         ArrayList<Mainlist> list = new ArrayList<>();
         for (int i = 0; i < 9; i++) {
             if (i == 1) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = i;
                 mainlist.mainviewlist = "ALBUM_PHOTOGRAPHY";
                 mainlist.mainimage = "http://media.glimpse.org/uploads/hXMTdY/full.png";
                 list.add(mainlist);

             } else if (i == 2) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = 2;
                 mainlist.mainviewlist = "MINISTRIES";
                 mainlist.mainimage = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcT83Mo8b9JTyOwAo-7BQvjMXuCm-b504rVwmXh45d5MwsLW1yj7FQ";
                 list.add(mainlist);

             } else if (i == 3) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = 3;
                 mainlist.mainviewlist = "FUNDS_AND_FINANCE";
                 mainlist.mainimage = "";
                 list.add(mainlist);

             } else if (i == 4) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = 4;
                 mainlist.mainviewlist = "VIEW_SITE";
                 mainlist.mainimage = "";
                 list.add(mainlist);

             } else if (i == 5) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = 5;
                 mainlist.mainviewlist = "EVENT_GRID_FILE";
                 mainlist.mainimage = "";
                 list.add(mainlist);

             } else if (i == 6) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = 6;
                 mainlist.mainviewlist = "GENERALLE";
                 mainlist.mainimage = "";
                 list.add(mainlist);

             } else if (i == 7) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = 7;
                 mainlist.mainviewlist = "STAFF_PROFILE";
                 mainlist.mainimage = "";
                 list.add(mainlist);

             } else if (i == 8) {
                 Mainlist mainlist = new Mainlist();
                 mainlist.id = 8;
                 mainlist.mainviewlist = "VIEW_PROFILE";
                 mainlist.mainimage = "";
                 list.add(mainlist);

             }


         }
     return  list;
     }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    // this was what must be corrected, making an onclicklistener for an churchlisting



    }




