package com.studydoc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.File;

public class Upload_Notes extends AppCompatActivity {

    ImageView gotoDashboard;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private static final int PICK_PDF_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_notes);

        getWindow().setStatusBarColor(ContextCompat.getColor(Upload_Notes.this, R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Initialize Firebase
        FirebaseApp.initializeApp(this);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        gotoDashboard = findViewById(R.id.program_b);
        gotoDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Upload_Notes.this, Dashboard.class));
            }
        });
        if(!isInternetAvailable()){
            showInternetDialog();
        }
        // Your ImageView
        ImageView imageView = findViewById(R.id.imageView12);

        // Set an OnClickListener on your ImageView to open the file picker
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
    }
3333333
    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, PICK_PDF_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri pdfUri = data.getData();
            uploadPDFFile(pdfUri);
        }
    }

    private void uploadPDFFile(Uri pdfUri) {
        try {
            // Generate a unique file name for the uploaded PDF
            String fileName = "pdf_" + System.currentTimeMillis() + ".pdf";

            // Specify the path where the PDF will be stored in Firebase Storage
            StorageReference pdfRef = storageReference.child("pdfs/" + fileName);

            // Upload the selected PDF file to Firebase Storage
            UploadTask uploadTask = pdfRef.putFile(pdfUri);

            uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // File uploaded successfully
                    showToast("Notes uploaded successfully👍");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // Handle errors
                    showToast("Notes uploading failed😵 " + e.getMessage());
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    // Calculate the progress and show a Toast with the progress percentage
                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                    showToast("Notes uploading.." + (int) progress + "%");
                }
            });
        } catch (Exception e) {
            // Handle any unexpected exceptions here
            showToast("An error occurred🛑" + e.getMessage());
        }
    }

    private void showToast(String message) {
        Toast.makeText(Upload_Notes.this, message, Toast.LENGTH_SHORT).show();
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
//activity_upload_notes