package com.gmail.peeman34.eglisaofficial;

/**
 * Created by pee on 8/26/2016.
 */

import com.google.gson.annotations.SerializedName;

public class Tracks {
    @SerializedName("songtitle")


    private String mTitle;

    @SerializedName("song_id")

    private int mId;


    @SerializedName("song_url")

    private String mStream_url;


    @SerializedName("song_image_url")

    private String mArtworkURL;

  public String getTitle(){
      return mTitle;
  }
    public int getmId(){
        return mId;

    }
    public String getmStream_url(){
        return mStream_url;
    }
    public String getmArtworkURL(){
        return mArtworkURL;

    }

}

