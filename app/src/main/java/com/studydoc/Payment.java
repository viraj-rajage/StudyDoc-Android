package com.studydoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Payment extends AppCompatActivity implements PaymentResultListener {
    private ImageView notesbackView;
    private static final String CHANNEL_ID = "StudyDoc";
    private static final int NOTIFICATION_ID =100;
    private Button Pyment;
    private CheckBox hostApp,UpdateApp,DownloadLink;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        notesbackView = findViewById(R.id.imageView9);
        Pyment = findViewById(R.id.button2);
        hostApp = findViewById(R.id.checkBox2);
        UpdateApp =  findViewById(R.id.checkBox3);
        DownloadLink = findViewById(R.id.checkBox4);
        getWindow().setStatusBarColor(ContextCompat.getColor(Payment.this, R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        notesbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Payment.this, Question.class));
            }
        });



        Pyment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hostApp.isChecked()){
                    Host_Payment(); //150
                }
                if (UpdateApp.isChecked()){
                    Update_payment(); //56
                    recreate();
                }
                if (DownloadLink.isChecked()){
                    Download_link(); //50
                    recreate();
                }


            }
        });



    }


    public void Host_Payment(){
        Checkout ch = new Checkout();
        JSONObject obj = new JSONObject();
        try {
            obj.put("name","StudyDoc Application Hosting Plan");
            obj.put("theme.color","#061A40");
            obj.put("description","StudyDoc Application Hosting Plan");
            obj.put("image","https://studydocs.netlify.app/Image/main_logo.png");
            obj.put("currency","INR");
            obj.put("amount","15000");

            JSONObject pre = new JSONObject();
            pre.put("contact"," ");
            pre.put("email"," ");
            obj.put("prefill",pre);

            ch.open(Payment.this,obj);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void Update_payment(){
        Checkout ch = new Checkout();
        JSONObject obj = new JSONObject();
        try {
            obj.put("name","StudyDoc Application Updating Plan");
            obj.put("theme","#061A40");
            obj.put("description","StudyDoc Application Updating Plan");
            obj.put("image","https://studydocs.netlify.app/Image/main_logo.png");
            obj.put("currency","INR");
            obj.put("amount","5600");

            JSONObject pre = new JSONObject();
            pre.put("contact"," ");
            pre.put("email"," ");
            obj.put("prefill",pre);

            ch.open(Payment.this,obj);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


    public void Download_link(){
        Checkout ch = new Checkout();
        JSONObject obj = new JSONObject();
        try {
            obj.put("name","StudyDoc Application Download Link Plan");
            obj.put("theme","#061A40");
            obj.put("description","StudyDoc Application Download Link Plan");
            obj.put("image","https://studydocs.netlify.app/Image/main_logo.png");
            obj.put("currency","INR");
            obj.put("amount","5000");

            JSONObject pre = new JSONObject();
            pre.put("contact"," ");
            pre.put("email"," ");
            obj.put("prefill",pre);

            ch.open(Payment.this,obj);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void onPaymentSuccess(String s) {
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.main_logo , null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeicon = bitmapDrawable.getBitmap();
        Toast.makeText(this, "Payment Success!", Toast.LENGTH_SHORT).show();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(Payment.this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.main_logo)
                    .setContentText("StudyDoc Contact you In Your Given Mobile Number Or Email")
                    .setSubText("StudyDoc Developer")
                    .setChannelId(CHANNEL_ID)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "StudyDoc",NotificationManager.IMPORTANCE_HIGH));
        }else{
            notification = new Notification.Builder(Payment.this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.main_logo)
                    .setContentText("New Message")
                    .setSubText("Message From StudyDoc")
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification);




    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Payment Failed!", Toast.LENGTH_SHORT).show();
    }
}