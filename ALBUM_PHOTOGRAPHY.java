package com.gmail.peeman34.eglisaofficial;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.android.photoutil.ImageBase64;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pee on 1/5/2016.
 */

public class ALBUM_PHOTOGRAPHY extends Activity implements  View.OnClickListener {
    EditText naming = (EditText)findViewById(R.id.usedname);
    EditText passwording2 = (EditText)findViewById(R.id.passwd);
    String namingtext = naming.getText().toString();
    String passwordtext = passwording2.getText().toString();


    public ALBUM_PHOTOGRAPHY() {
        super();
    }


    Button Takeapic = (Button) findViewById(R.id.TakePicture);
    Button Upload = (Button) findViewById(R.id.Upload);
    private File ImageFile;
    String path;

    final String TAG = this.getClass().getSimpleName();
    ImageView Profilepic = (ImageView) findViewById(R.id.Profilepic);
    final Command command = new Command(getApplication());



    Bitmap image;
    ImageView iv = (ImageView) findViewById(R.id.iv);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photography);
        Takeapic.setOnClickListener(this);
        Upload.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (getTaskId()) {
            case R.id.TakePicture:
                process(v);
                break;

            case R.id.Upload:
                Class Uploading = null;
                try {
                    Uploading = Class.forName("com.gmail.peeman34.eglisaofficial.UPLOAD");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Intent getPicture = new Intent(ALBUM_PHOTOGRAPHY.this, Uploading);
                startActivity(getPicture);
                break;


        }
    }


    @TargetApi(Build.VERSION_CODES.FROYO)
    public void process(View v) {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ImageFile = new File((Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)), "test.jpg");
        Uri tempfile = Uri.fromFile(ImageFile);
        camera.putExtra(MediaStore.EXTRA_OUTPUT, tempfile);

        camera.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(camera, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    if (ImageFile.exists()) {

                    }
                    Toast.makeText(this, "The File was saved at " + ImageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                        Bundle exras = data.getExtras();
                        image = (Bitmap) exras.get("data");
                         final String path = ImageFile.getAbsolutePath();
                        iv.setImageBitmap(image);



                        String url = "http://127.0.0.1/upload.php";
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


                            @Override
                            public void onResponse(String response) {
                                Log.d(TAG, response);
                                ArrayList<String> imagelist = new ArrayList<>();
                                ListView lvProduct = (ListView) findViewById(R.id.lv_product);


                            }
                        },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError volleyError) {
                                        if (volleyError instanceof com.android.volley.TimeoutError) {
                                            Toast.makeText(getApplicationContext(), "Time Out Error", Toast.LENGTH_SHORT).show();
                                        }
                                        else if (volleyError instanceof com.android.volley.NoConnectionError) {
                                            Toast.makeText(getApplicationContext(), "No Connection", Toast.LENGTH_SHORT).show();

                                        } else if (volleyError instanceof com.android.volley.AuthFailureError){

                                            Toast.makeText(getApplicationContext(), "Authentication Failure Error", Toast.LENGTH_SHORT).show();
                                        }
                                        else if(volleyError instanceof  com.android.volley.NetworkError){
                                            Toast.makeText(getApplicationContext(),"Network error", Toast.LENGTH_SHORT).show();
                                        }
                                        else  if(volleyError instanceof  com.android.volley.ServerError){
                                            Toast.makeText(getApplicationContext(), "Server Error" , Toast.LENGTH_SHORT).show();
                                        }
                                        else if(volleyError instanceof  com.android.volley.ParseError){
                                            Toast.makeText(getApplicationContext(), "Parse Error", Toast.LENGTH_SHORT );
                                        }

                                    }


                                }) {


                            protected Map<String, String> getParams() throws AuthFailureError {

                                Map<String, String> params = new HashMap<String, String>();
                                String encodedString = ImageBase64.encode(image);
                                 params.put("image",encodedString);
                                params.put("path", path);
                                  params.put("username", namingtext);
                                params.put("password", passwordtext);
                                return params;


                            }


                        };


                        command.add(stringRequest);

                    MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

                    }
                  command.execute();

            }


        }


    }






