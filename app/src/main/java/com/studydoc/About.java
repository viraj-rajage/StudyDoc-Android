package com.studydoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class About extends AppCompatActivity {
   ImageView imageView ;
   WebView webview;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getWindow().setStatusBarColor(ContextCompat.getColor(About.this, R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView = findViewById(R.id.imageView9);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(About.this, Dashboard.class));
            }
        });
        if(!isInternetAvailable()){
            showInternetDialog();
        }
        webview = (WebView) findViewById(R.id.webviews);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://studydocs.netlify.app/html/about_us");

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
    private boolean isInternetAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    // Show a dialog with an "OK" button to enable internet
    private void showInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Please enable internet or Wi-Fi to continue.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Open the Wi-Fi settings
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User denied, you can handle it here
                // For example, you can close the app or go back
                finish();
            }
        });
        builder.show();
    }
}