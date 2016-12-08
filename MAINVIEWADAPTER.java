
package com.gmail.peeman34.eglisaofficial;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kosalgeek.android.json.JsonConverter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;


class MAINVIEWADAPTER extends RecyclerView.Adapter<MAINVIEWADAPTER.MainViewViewHolder> {


        private  Context context;

         private  ArrayList<Mainlist> mainlist;


    final String TAG = this.getClass().getSimpleName();
    public MAINVIEWADAPTER(Context context, ArrayList<Mainlist> mainViewListArrayList) {
        this.mainlist = mainViewListArrayList;
        this.context  =context;
    }

    @Override
    public MainViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainview, parent, false);
            MainViewViewHolder mainViewViewHolder = new MainViewViewHolder(view);
           return  mainViewViewHolder;

    }

    @Override
    public void onBindViewHolder(MainViewViewHolder holder, int position) {

             Mainlist thelist = mainlist.get(position);
        Picasso.with(context).load(thelist.mainimage).placeholder(R.drawable.praying_hands_203324).error(android.R.drawable.stat_notify_error).into(holder.mainimage);
           holder.mainviewtext.setText(thelist.mainviewlist);





    }

    @Override
    public int getItemCount()
    { if(mainlist !=null){
        return  mainlist.size();
    }
        return 0;
    }


    public  static  class  MainViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
public CardView maincardview;
        public ImageView mainimage;
        public TextView mainviewtext;


        public MainViewViewHolder(View itemView) {

            super(itemView);


            mainimage= (ImageView) itemView.findViewById(R.id.listviewingstuff);
            maincardview = (CardView) itemView.findViewById(R.id.maincardview);
              mainviewtext= (TextView) itemView.findViewById(R.id.mainviewrecycletexts);
            itemView.setOnClickListener(this);
        }
               // so we have to deal with the onclick listener for the mainviews
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();





          }}


}

