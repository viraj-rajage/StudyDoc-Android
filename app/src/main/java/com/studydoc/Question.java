package com.studydoc;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class Question extends AppCompatActivity {
   private ImageView notesbackView;
//
   private static final String CHANNEL_ID = "StudyDoc";
   private static final int NOTIFICATION_ID =100;
//
   EditText editTextName, editTextMobile, editTextEmail;
    Button sendButton;
    TextView textViewConfirmation;


    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getWindow().setStatusBarColor(ContextCompat.getColor(Question.this, R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toast.makeText(this, "Enter Your Correct Information", Toast.LENGTH_LONG).show();
        notesbackView = findViewById(R.id.imageView9);
        editTextName = findViewById(R.id.ditTextName);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextEmail = findViewById(R.id.editTextEmail);
        sendButton = findViewById(R.id.button3);
        textViewConfirmation = findViewById(R.id.textViewConfirmation);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String mobileNumber = editTextMobile.getText().toString();
                String email = editTextEmail.getText().toString();

                if (!name.isEmpty() && !mobileNumber.isEmpty() && !email.isEmpty()){

                    Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.main_logo , null);
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    Bitmap largeicon = bitmapDrawable.getBitmap();

                    // Send customer's data to admin
                    String Phone_number = "+919892942507";
                    String adminMessage = "Requirment: " + name + "\nMobile Number: " + mobileNumber + "\nEmail: " + email;
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(Phone_number, null, adminMessage, null, null);

                    // Display confirmation Notification
                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    Notification notification;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        notification = new Notification.Builder(Question.this)
                                .setLargeIcon(largeicon)
                                .setSmallIcon(R.drawable.main_logo)
                                .setContentText("Thanks for choosing StudyDoc! We will contact you in next 12 hours.")
                                .setSubText("StudyDoc Developer")
                                .setChannelId(CHANNEL_ID)
                                .build();
                        nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "StudyDoc",NotificationManager.IMPORTANCE_HIGH));
                    }else{
                        notification = new Notification.Builder(Question.this)
                                .setLargeIcon(largeicon)
                                .setSmallIcon(R.drawable.main_logo)
                                .setContentText("New Message")
                                .setSubText("Message From StudyDoc")
                                .build();
                    }
                    nm.notify(NOTIFICATION_ID,notification);
                    // Display confirmation message
                    customToast();
                    startActivity(new Intent(Question.this, Payment.class));
                }
                else{
                    Toast.makeText(Question.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }

            }

        });

        notesbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Question.this, Dashboard.class));
            }
        });
        if(!isInternetAvailable()){
            showInternetDialog();
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
                finish();
            }
        });
        builder.show();
    }
    public  void customToast(){
        Toast.makeText(this, "Select Your Plan!", Toast.LENGTH_SHORT).show();
    }


}