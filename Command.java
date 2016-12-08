package com.gmail.peeman34.eglisaofficial;


import android.content.Context;

import com.android.volley.Request;

import java.util.ArrayList;

/**
 * Created by pee on 6/6/2016.
 */
public class Command<T> {
    private ArrayList<Request<T>> requestList = new ArrayList<>();
    private Context context;

    public  Command(Context context){
        this.context = context;

    }

     public void add(Request<T> request){
         requestList.add(request);

     }
    public void remove(Request<T> request) {
        requestList.remove(request);
    }

   public void execute(){
        for (Request<T> request:requestList){
                 MySingleton.getInstance(context).addToRequestQueue(request);}
    }

  }
