package com.gmail.peeman34.eglisaofficial;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by pee on 1/5/2016.
 */
public class VIEW_SITE extends Activity implements View.OnClickListener {
    public VIEW_SITE() {
        super();
    }
    EditText website = (EditText) findViewById(R.id.urlplacer);
    WebView OurSite;

    @TargetApi(Build.VERSION_CODES.ECLAIR_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siteview);

        OurSite = (WebView)findViewById(R.id.browser);
        OurSite.loadUrl("http://www.christianitytoday.com");
        OurSite.setWebViewClient(new WEBVIEWCLIENT());
        OurSite.getSettings().setJavaScriptEnabled(true);
        OurSite.getSettings().setUseWideViewPort(true);
        OurSite.getSettings().setLoadWithOverviewMode(true);

        Button GO = (Button) findViewById(R.id.go);
        Button GOBACK  = (Button) findViewById(R.id.goback);
        Button FORWARD = (Button) findViewById(R.id.forward);
        Button REFRESH = (Button) findViewById(R.id.refresh);
        Button CLEARHISTORY = (Button) findViewById(R.id.clHistory);


         GO.setOnClickListener(this);
         GOBACK.setOnClickListener(this);
        FORWARD.setOnClickListener(this);
        REFRESH.setOnClickListener(this);
        CLEARHISTORY.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (getTaskId()){
            case R.id.go:
                try {
                    String theWebsite =  website.getText().toString();
                 OurSite.loadUrl(theWebsite);
                    InputMethodManager Inputman  = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    Inputman.hideSoftInputFromInputMethod(website.getWindowToken(), 0);


                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.goback:
                if (OurSite.canGoBack()){
                    OurSite.goBack();
                }
                break;
            case R.id.forward:
                if(OurSite.canGoForward()){
                    OurSite.goForward();
                }
                break;
            case R.id.refresh:
                OurSite.reload();
                break;
            case R.id.clHistory:
                OurSite.clearHistory();
                break;
        }
    }
}
