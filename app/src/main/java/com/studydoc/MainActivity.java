package com.studydoc;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {
    int progressCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.application_background));
        ProgressBar progress = findViewById(R.id.progressBar);
        TextView text = findViewById(R.id.textView);
        Activity activity = MainActivity.this;
        progress.setProgress(progressCount);
        progress.setMax(100);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                progressCount = progressCount+2;
                progress.setProgress(progressCount);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        text.setText(String.valueOf(progressCount));
                    }
                });

                if(progress.getProgress()>=100){
                    timer.cancel();
                    Intent intent = new Intent(MainActivity.this,Load.class);
                    activity.startActivity(intent);
                    finish();
                }
            }
        },500,20);
    }
}