package com.studydoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Term extends AppCompatActivity {
    ImageView imageView;
    Button project_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);
        getWindow().setStatusBarColor(ContextCompat.getColor(Term.this, R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView = findViewById(R.id.imageView9);
        project_btn = findViewById(R.id.button);

        project_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String utl="https://studydocs.netlify.app/html/store";
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(utl));
                startActivity(intent);
            }
        });
        if(!isInternetAvailable()){
            showInternetDialog();
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Term.this, Dashboard.class));
            }
        });
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