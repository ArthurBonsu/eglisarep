package com.gmail.peeman34.eglisaofficial;

import android.graphics.Bitmap;
import android.support.v7.util.SortedList;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by pee on 8/27/2016.
 */

public interface CSService {

    @GET("/tracks?client_id=" + SongHub.CLIENT_ID)
    void getRecentTracks(@Query("created_at[from]") String date, SortedList.Callback<List<Tracks>> cb);


}
