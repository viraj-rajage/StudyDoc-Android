package com.studydoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

   ImageView website_1;
   ImageView About_us,call,term;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ImageView imageView1,imageView2,imageview77,imageview88;
        final ImageView upload_notes;

        final TextView generator_text,question_text;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setStatusBarColor(ContextCompat.getColor(Dashboard.this, R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageview88 = findViewById(R.id.imageView8);
        imageview77 = findViewById(R.id.imageView7);
        imageView1 = findViewById(R.id.imageView20);
        imageView2 = findViewById(R.id.imageView18);
        website_1 = findViewById(R.id.imageView19);

        About_us = findViewById(R.id.imageView21);
        call = findViewById(R.id.imageView23);
        term = findViewById(R.id.imageView22);
        About_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, About.class));
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Call.class));
            }
        });
        term.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Term.class));
            }
        });



        upload_notes = findViewById(R.id.uploadNotes);
        upload_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Upload_Notes.class));
            }
        });



        imageview88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Question.class));

            }
        });
        imageview77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Generator.class));
            }
        });


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Notes.class));
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,Program_activity.class));
            }
        });

       website_1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String utl="https://studydocs.netlify.app";
               Intent intent= new Intent(Intent.ACTION_VIEW,Uri.parse(utl));
               startActivity(intent);
           }
       });
    }

}