package com.gmail.peeman34.eglisaofficial;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by pee on 1/21/2016.
 */
public class UPLOAD extends Activity  implements View.OnClickListener{

    final String TAG =this.getClass().getSimpleName();
          ImageView Profilepic = (ImageView)findViewById(R.id.Profilepic);
    ImageView iv = (ImageView) findViewById(R.id.iv);
         Button Upload = (Button)findViewById(R.id.Upload);
              final Command command = new Command(getApplication());
    private static final int IMAGE_GALLERY_REQUEST = 20;

    public UPLOAD() {
        super();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photography);}


    @Override
    public void onClick(View v) {
          switch (getTaskId()) {
              case R.id.Upload:
              onImageGalleryClicked(v);
          }
    }

    public void onImageGalleryClicked(View v){
        // invoke the image gallery using an implicit intent
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

        //where do we find the data
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectorypath = pictureDirectory.getPath();
        //finally get a URI presentation

        Uri data  =  Uri.parse(pictureDirectorypath);
        //set the data and type .. Get all images
        photoPickerIntent.setDataAndType(data, "image/*");
        //we will invoke this activity and get something back from it

        startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);

    }

    ArrayList<String> imagelist = new ArrayList<>();
    ListView lvProduct = (ListView) findViewById(R.id.lv_product);

 protected void onActivityResult(int requestCode, int resultCode, Intent data){
      if (resultCode == RESULT_OK) {
          //if we are here, everything processed sucessfully
          if (resultCode == IMAGE_GALLERY_REQUEST) {
              //if  we are here,we are hearing back from the  image gallery
              // the address of the image on the SD CARD
              Uri imageUri = data.getData();
                String path = data.getData().getPath();
              InputStream InputStream;
              try {
                  InputStream = getContentResolver().openInputStream(imageUri);
                  //get a Bitmap from the stream
                  final Bitmap image = BitmapFactory.decodeStream(InputStream);
                     imagelist.add(String.valueOf(imageUri));

                  String url = "";
                  StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


                      @Override
                      public void onResponse(String response) {
                          Log.d(TAG, response);


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

                       String encodedString = ImageBase64.encode(image);
                      protected Map<String, String> getParams() throws AuthFailureError {
                          Map<String, String> params = new HashMap<String, String>();
                           params.put("image",encodedString);


                          return params;


                      }


                  };


                  LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                  Profilepic.setLayoutParams(layoutParams);
                  Profilepic.setScaleType(ImageView.ScaleType.FIT_CENTER);
                  Profilepic.setPadding(0, 0, 0, 10);
                  Profilepic.setAdjustViewBounds(true);

                  Profilepic.setImageBitmap(image);

                  command.add(stringRequest);

                  MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

              } catch (FileNotFoundException e) {
                  e.printStackTrace();
                  //show a message showing image is unavailable
                  Toast.makeText(this, "Unable to open Image", Toast.LENGTH_LONG).show();
              }

              command.execute();

              }


      }
 }

}
