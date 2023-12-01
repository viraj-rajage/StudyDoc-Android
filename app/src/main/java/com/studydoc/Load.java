package com.studydoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;
import com.airbnb.lottie.LottieAnimationView;
public class Load extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setStatusBarColor(ContextCompat.getColor(Load.this,R.color.application_background));
        LottieAnimationView animeview = findViewById(R.id.lottieAnimationView);
        animeview.playAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Load.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },3300);
    }
}