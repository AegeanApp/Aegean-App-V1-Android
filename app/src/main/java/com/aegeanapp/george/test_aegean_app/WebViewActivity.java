package com.aegeanapp.george.test_aegean_app;

import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity
{
    //this activity is not used in project was only added for testing purpose
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getSupportActionBar().setTitle("Aegean App");
        Intent intent = getIntent();
        String link = intent.getStringExtra("http://www.icsd.aegean.gr/website_files/grammateia_files/announcements/339224911.pdf");
        WebView wv = (WebView)findViewById(R.id.webview);
        wv.setWebViewClient(new WebViewClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.getSettings().setBuiltInZoomControls(true);
        /*(wv.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
            {
                handler.proceed();

            }
        });*/
        wv.loadUrl("http://docs.google.com/gview?embedded=true&url="+link);
    }
}
