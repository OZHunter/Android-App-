package com.example.yushen.functionforapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class discountpart extends AppCompatActivity {

    ImageButton dj;
    ImageButton cw;
    ImageButton ow;
    ImageButton jb;
    ImageButton myer;
    WebView webView;

    String url_dj="http://shop.davidjones.com.au/djs/en/davidjones";
    String url_cw="https://www.chemistwarehouse.com.au/";
    String url_ow="https://www.officeworks.com.au/";
    String url_jb="https://www.jbhifi.com.au/";
    String url_myer="https://www.myer.com.au/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discountpart);

        dj=(ImageButton)findViewById(R.id.imageButton_dj);
        cw=(ImageButton)findViewById(R.id.imageButton_chemistwarehouse);
        ow=(ImageButton)findViewById(R.id.imageButton_officeworks);
        jb=(ImageButton)findViewById(R.id.imageButton_jbhifi);
        myer=(ImageButton)findViewById(R.id.imageButton_myer);
        webView=(WebView)findViewById(R.id.webview);



        dj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url_dj);
            }
        });

        cw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url_cw);
            }
        });

        ow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url_ow);
            }
        });

        jb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(url_jb);
            }
        });

        myer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url_myer);
                webView.setWebViewClient(new WebViewClient());
            }
        });




    }

}
