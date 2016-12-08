package com.gmail.peeman34.eglisaofficial;

import android.graphics.Bitmap;

import retrofit.RestAdapter;

/**
 * Created by pee on 8/27/2016.
 */

public class SoundClub {
    private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder().setEndpoint(SongHub.API_URL).build();
    private static final CSService SERVICE = REST_ADAPTER.create(CSService.class);

    public static CSService getService() {
        return SERVICE;
    }
}