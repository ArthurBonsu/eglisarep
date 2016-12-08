package com.gmail.peeman34.eglisaofficial;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by pee on 9/13/2016.
 */
public class WEBVIEWCLIENT extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
      view.loadUrl(url);
        return true;
     }
}
