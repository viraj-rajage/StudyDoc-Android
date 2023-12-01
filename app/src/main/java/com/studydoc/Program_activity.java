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
import android.widget.ImageView;

public class Program_activity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ImageView program_back , c_image_view , cpp_image_view , cs_image_view, sql_image_view,java_image_view,python_image_view, js_image_view , css_image;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        getWindow().setStatusBarColor(ContextCompat.getColor(Program_activity.this, R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        program_back = findViewById(R.id.program_b);
        c_image_view = findViewById(R.id.imageView15);
        cpp_image_view = findViewById(R.id.imageView13);
        cs_image_view = findViewById(R.id.imageView16);
        sql_image_view = findViewById(R.id.imageView17);
        java_image_view = findViewById(R.id.imageView2);
        python_image_view = findViewById(R.id.imageView10);
        js_image_view = findViewById(R.id.imageView11);
        css_image = findViewById(R.id.imageView14);
        if(!isInternetAvailable()){
            showInternetDialog();
        }

        css_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, css_program.class));
            }
        });
        js_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, js_program.class));
            }
        });
        python_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, python_program.class));
            }
        });
        java_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, java_program.class));
            }
        });
        sql_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, sql_program.class));
            }
        });
        cs_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, Csharp_program.class));
            }
        });
        cpp_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, cpp_program.class));
            }
        });
        program_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, Dashboard.class));
            }
        });
        c_image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Program_activity.this, CProgram.class));
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