package com.gmail.peeman34.eglisaofficial;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kosalgeek.android.photoutil.MainActivity;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by pee on 8/27/2016.
 */

public class TRACKSMAIN extends AppCompatActivity {
    private static final String TAG = "TRACKSMAIN";
    EditText naming = (EditText) findViewById(R.id.usedname);
    EditText passwording2 = (EditText) findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();
    SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public TRACKSMAIN() {
        super();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mMediaPlayer != null) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private List<Tracks> mListItems;
    private Trackspulladapter mAdapter;
    private TextView mSelectedTrackTitle;
    private ImageView mSelectedTrackImage;
    private MediaPlayer mMediaPlayer;
    private ImageView mPlayerControl;
    private void togglePlayPause() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mPlayerControl.setImageResource(android.R.drawable.ic_media_play);
        } else {
            mMediaPlayer.start();
            mPlayerControl.setImageResource(android.R.drawable.ic_media_pause);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracksmain);
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                togglePlayPause();
            }
        });
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayerControl.setImageResource(android.R.drawable.ic_media_play);
            }
        });

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(SongHub.API_URL).build();
        CSService csService = restAdapter.create(CSService.class);
        csService.getRecentTracks(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), new SortedList.Callback<List<Tracks>>() {

            @Override
            public int compare(List<Tracks> o1, List<Tracks> o2) {
                return 0;
            }

            @Override
            public void onInserted(int position, int count) {

            }

            @Override
            public void onRemoved(int position, int count) {

            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {

            }

            @Override
            public void onChanged(int position, int count) {

            }

            @Override
            public boolean areContentsTheSame(List<Tracks> oldItem, List<Tracks> newItem) {
                return false;
            }

            @Override
            public boolean areItemsTheSame(List<Tracks> item1, List<Tracks> item2) {
                return false;
            }


            public void success(List<Tracks> tracks, Response response) {
                Log.d(TAG, "First track title: " + tracks.get(0).getTitle());
            }


            public void failure(RetrofitError error) {
                Log.d(TAG, "Error: " + error);
            }
        });
            String url;
         url = "http://127.0.0.1/getsongstream.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {


            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);



            }


        },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        if (volleyError instanceof com.android.volley.TimeoutError) {
                            Toast.makeText(getApplicationContext(), "Time Out Error", Toast.LENGTH_SHORT).show();
                        } else if (volleyError instanceof com.android.volley.NoConnectionError) {
                            Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_SHORT).show();

                        } else if (volleyError instanceof com.android.volley.AuthFailureError) {

                            Toast.makeText(getApplicationContext(), "Authentication Failure Error", Toast.LENGTH_SHORT).show();
                        } else if (volleyError instanceof com.android.volley.NetworkError) {
                            Toast.makeText(getApplicationContext(), "Network error", Toast.LENGTH_SHORT).show();
                        } else if (volleyError instanceof com.android.volley.ServerError) {
                            Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_SHORT).show();
                        } else if (volleyError instanceof com.android.volley.ParseError) {
                            Toast.makeText(getApplicationContext(), "Parse Error", Toast.LENGTH_SHORT);
                        }
                    }


                }) {

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("username", namingtext);
                params.put("password", passwordtext);
                Toast.makeText(TRACKSMAIN.this, "Data entered", Toast.LENGTH_LONG).show();
                return params;


            }


        };

        mListItems = new ArrayList<Tracks>();
        ListView listView = (ListView) findViewById(R.id.track_list_view);
        mAdapter = new Trackspulladapter(this, mListItems);
        listView.setAdapter(mAdapter);

        mSelectedTrackTitle = (TextView) findViewById(R.id.selected_track_title);
        mSelectedTrackImage = (ImageView) findViewById(R.id.selected_track_image);
        mPlayerControl = (ImageView)findViewById(R.id.player_control);
        mPlayerControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePlayPause();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tracks track = mListItems.get(position);

                mSelectedTrackTitle.setText(track.getTitle());
                Picasso.with(TRACKSMAIN.this).load(track.getmArtworkURL()).into(mSelectedTrackImage);

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                    mMediaPlayer.reset();
                }

                try {
                    mMediaPlayer.setDataSource(track.getmStream_url() + "?client_id=" + SongHub.CLIENT_ID);
                    mMediaPlayer.prepareAsync();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        final AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxvolume =audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curvolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBar.setMax(maxvolume);
        seekBar.setProgress(curvolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        CSService scService = SoundClub.getService();
        scService.getRecentTracks(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), new SortedList.Callback<List<Tracks>>() {

            @Override
            public int compare(List<Tracks> o1, List<Tracks> o2) {
                return 0;
            }

            @Override
            public void onInserted(int position, int count) {

            }

            @Override
            public void onRemoved(int position, int count) {

            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {

            }

            @Override
            public void onChanged(int position, int count) {

            }

            @Override
            public boolean areContentsTheSame(List<Tracks> oldItem, List<Tracks> newItem) {
                return false;
            }

            @Override
            public boolean areItemsTheSame(List<Tracks> item1, List<Tracks> item2) {
                return false;
            }

            public void success(List<Tracks> tracks, Response response) {

                loadTracks(tracks);
                Log.d(TAG, "First track title: " + tracks.get(0).getTitle());
            }


            public void failure(RetrofitError error) {
                Log.d(TAG, "Error: " + error);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void loadTracks(List<Tracks> tracks) {
        mListItems.clear();
        mListItems.addAll(tracks);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("TRACKSMAIN Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://www.soundcloud.com"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}