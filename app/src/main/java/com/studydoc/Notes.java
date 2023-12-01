package com.studydoc;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

import java.net.HttpURLConnection;
import java.net.URL;

public class Notes extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ImageView notesbackView ;
        Button DBMS1;
        Button DBMS2;
        Button DBMS3;
        Button C1;
        Button C2;
        Button C3;
        Button C4;
        Button C5;
        Button C6;
        Button OS1;
        Button OS2;
        Button OS3;
        Button OS4;
        Button OS5;
        Button OS6;
        Button SE1;
        Button SE2;
        Button SE3;
        Button SE4;
        Button SE5;
        Button java1;
        Button java2;
        Button java3;
        Button java4;
        Button java5;
        Button STQA;
        Button CN1;
        Button CN2;
        Button CN3;
        Button CN4;
        Button CN5;
        Button CN6;
        Button MR1;
        Button MR2;
        Button MR3;
        Button MR4;
        Button MR5;
        Button MR6;
        Button CC1;
        Button CC2;
        Button CC3;
        Button CC4;
        Button CC5;
        Button CC6;
        Button CC7;
        Button CC8;
        Button CC9;
        Button CC10;
        Button CC11;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        getWindow().setStatusBarColor(ContextCompat.getColor(Notes.this,R.color.application_background));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        notesbackView = findViewById(R.id.imageView9);
        notesbackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Notes.this, Dashboard.class));
            }
           });
        if(!isInternetAvailable()){
            showInternetDialog();
        }
//----------------------------------------------------------------------------------------------------------------------------->
        DBMS1 = findViewById(R.id.DBMSnote1);
        DBMS1.setOnClickListener(v -> {
            DBMS1NOTE();
        });

        DBMS2 = findViewById(R.id.DBMSnote2);
        DBMS2.setOnClickListener(v -> {
            DBMS2NOTE();
        });

        DBMS3 = findViewById(R.id.DBMSnote3);
        DBMS3.setOnClickListener(v -> {
            DBMS3NOTE();
        });
        //------------------------->
        C1 = findViewById(R.id.CNotes1);
        C1.setOnClickListener(v -> {
            C1NOTE();
        });
        C2 = findViewById(R.id.CNotes2);
        C2.setOnClickListener(v -> {
            C2NOTE();
        });
        C3 = findViewById(R.id.CNotes3);
        C3.setOnClickListener(v -> {
            C3NOTE();
        });
        C4 = findViewById(R.id.CNotes4);
        C4.setOnClickListener(v -> {
            C4NOTE();
        });
        C5 = findViewById(R.id.CNotes5);
        C5.setOnClickListener(v -> {
            C5NOTE();
        });
        C6 = findViewById(R.id.CNotes6);
        C6.setOnClickListener(v -> {
            C6NOTE();
        });
        //--------------------------->
        OS1 = findViewById(R.id.OS1);
        OS1.setOnClickListener(v -> {
            OS1NOTE();
        });
        OS2 = findViewById(R.id.OS2);
        OS2.setOnClickListener(v -> {
            OS2NOTE();
        });
        OS3 = findViewById(R.id.OS3);
        OS3.setOnClickListener(v -> {
            OS3NOTE();
        });
        OS4 = findViewById(R.id.OS4);
        OS4.setOnClickListener(v -> {
            OS4NOTE();
        });
        OS5 = findViewById(R.id.OS5);
        OS5.setOnClickListener(v -> {
            OS5NOTE();
        });
        OS6 = findViewById(R.id.OS6);
        OS6.setOnClickListener(v -> {
            OS6NOTE();
        });
       //  ------------------------------->

        SE1 = findViewById(R.id.se1);
        SE1.setOnClickListener(v -> {
            SE1NOTE();
        });
        SE2 = findViewById(R.id.se2);
        SE2.setOnClickListener(v -> {
            SE2NOTE();
        });
        SE3 = findViewById(R.id.se3);
        SE3.setOnClickListener(v -> {
            SE3NOTE();
        });
        SE4 = findViewById(R.id.se4);
        SE4.setOnClickListener(v -> {
            SE4NOTE();
        });
        SE5 = findViewById(R.id.se5);
        SE5.setOnClickListener(v -> {
            SE5NOTE();
        });
      //------------------------------------------->
        java1 = findViewById(R.id.java1);
        java1.setOnClickListener(v -> {
            JAVA1NOTE();
        });
        java2 = findViewById(R.id.java2);
        java2.setOnClickListener(v -> {
            JAVA2NOTE();
        });
        java3 = findViewById(R.id.java3);
        java3.setOnClickListener(v -> {
            JAVA3NOTE();
        });
        java4 = findViewById(R.id.java4);
        java4.setOnClickListener(v -> {
            JAVA4NOTE();
        });
        java5 = findViewById(R.id.java5);
        java5.setOnClickListener(v -> {
            JAVA5NOTE();
        });

        STQA = findViewById(R.id.stqa1);
        STQA.setOnClickListener(v -> {
            STQANOTES1();
        });
        //------------------------------------------>
        CN1 = findViewById(R.id.cn1);
        CN1.setOnClickListener(v -> {
            COM1NOTE();
        });
        CN2 = findViewById(R.id.cn2);
        CN2.setOnClickListener(v -> {
            COM2NOTE();
        });
        CN3 = findViewById(R.id.cn3);
        CN3.setOnClickListener(v -> {
            COM3NOTE();
        });
        CN4 = findViewById(R.id.cn4);
        CN4.setOnClickListener(v -> {
            COM4NOTE();
        });
        CN5 = findViewById(R.id.cn5);
        CN5.setOnClickListener(v -> {
            COM5NOTE();
        });

        CN6 = findViewById(R.id.cn6);
        CN6.setOnClickListener(v -> {
            COM6NOTE();
        });
        //------------------------------------>
        MR1 = findViewById(R.id.mr1);
        MR1.setOnClickListener(v -> {
            MR1NOTE();
        });

        MR2 = findViewById(R.id.mr2);
        MR2.setOnClickListener(v -> {
            MR2NOTE();
        });

        MR3 = findViewById(R.id.mr3);
        MR3.setOnClickListener(v -> {
            MR3NOTE();
        });

        MR4 = findViewById(R.id.mr4);
        MR4.setOnClickListener(v -> {
            MR4NOTE();
        });

        MR5 = findViewById(R.id.mr5);
        MR5.setOnClickListener(v -> {
            MR5NOTE();
        });

        MR6 = findViewById(R.id.mr6);
        MR6.setOnClickListener(v -> {
            MR6NOTE();
        });
        // -------------------------->

        CC1 = findViewById(R.id.cc1);
        CC1.setOnClickListener(v -> {
            CC1NOTE();
        });
        CC2 = findViewById(R.id.cc2);
        CC2.setOnClickListener(v -> {
            CC2NOTE();
        });
        CC3 = findViewById(R.id.cc3);
        CC3.setOnClickListener(v -> {
            CC3NOTE();
        });
        CC4 = findViewById(R.id.cc4);
        CC4.setOnClickListener(v -> {
            CC4NOTE();
        });
        CC5 = findViewById(R.id.cc5);
        CC5.setOnClickListener(v -> {
            CC5NOTE();
        });
        CC6 = findViewById(R.id.cc6);
        CC6.setOnClickListener(v -> {
            CC6NOTE();
        });
        CC7 = findViewById(R.id.cc7);
        CC7.setOnClickListener(v -> {
            CC7NOTE();
        });
        CC8 = findViewById(R.id.cc8);
        CC8.setOnClickListener(v -> {
            CC8NOTE();
        });
        CC9 = findViewById(R.id.cc9);
        CC9.setOnClickListener(v -> {
            CC9NOTE();
        });
        CC10 = findViewById(R.id.cc10);
        CC10.setOnClickListener(v -> {
            CC10NOTE();
        });
        CC11 = findViewById(R.id.cc11);
        CC11.setOnClickListener(v -> {
            CC11NOTE();
        });








    }
    private void CC1NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/1.1From%20Client-Server%20and%20collaborative%20computing%20to%20Cloud%20computing,,Defining%20cloud%20Computing,%20Essential%20characteristics%20of%20cloud%20computing.pdf";
        download(getApplicationContext(), "Defining_cloud_Computing", ".pdf", "Downloads", uri.trim());
    }
    private void CC2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/1.3%20%20Cloud%20Service%20Model.pdf";
        download(getApplicationContext(), "Cloud_Service_Model", ".pdf", "Downloads", uri.trim());
    }
    private void CC3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC.Unit%20no.1.4%20Cloud%20Economics%20and%20Benefits.pdf";
        download(getApplicationContext(), "Cloud_Economics_and_Benefits", ".pdf", "Downloads", uri.trim());
    }
    private void CC4NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC.Unit%20no.2%20.1%20-%20Intro-Virtualization%20&%20its%20Charatacteristics.pdf";
        download(getApplicationContext(), "Intro-Virtualization", ".pdf", "Downloads", uri.trim());
    }
    private void CC5NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC.Unit%20no.2.2-Virtualization%20Types.pdf";
        download(getApplicationContext(), "Virtualization_Types", ".pdf", "Downloads", uri.trim());
    }
    private void CC6NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC.Unit%20no.2.3%20Technology%20Example-Vmware,%20Microsoft%20Hyper-V,%20KVM%20,%20Xen.pdf";
        download(getApplicationContext(), "Technology_Example-Vmware_Microsoft_Hyper-V_KVM_Xen", ".pdf", "Downloads", uri.trim());
    }
    private void CC7NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC.Unit%20no.2.5%20Disadvantages%20of%20virtualization.pdf";
        download(getApplicationContext(), "Disadvantages_of_virtualization", ".pdf", "Downloads", uri.trim());
    }
    private void CC8NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC.Unit%20no.3%20-%20Storage%20in%20Cloud.pdf";
        download(getApplicationContext(), "Storage_in_Cloud", ".pdf", "Downloads", uri.trim());
    }
    private void CC9NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC.Unit%20no.3.5-Cloud%20file%20systems-GFS%20and%20HDFS,%20Comparisons%20among%20GFS%20and%20HDFS..pdf";
        download(getApplicationContext(), "Cloud_file_systems-GFS_and_HDFS", ".pdf", "Downloads", uri.trim());
    }
    private void CC10NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC1.2-Cloud%20Deployment%20Models.docx";
        download(getApplicationContext(), "Cloud_Deployment_Models", ".docx", "Downloads", uri.trim());
    }
    private void CC11NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CC/CC1.5,1.6.pdf";
        download(getApplicationContext(), "Architecture_of_Cloud_computing", ".pdf", "Downloads", uri.trim());
    }









    private void MR1NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Microcontroller/arduino.pdf";
        download(getApplicationContext(), "Input_output_pins_Arduino", ".pdf", "Downloads", uri.trim());
    }
    private void MR2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Microcontroller/Interfacing_DC_motor_to_8051.pdf";
        download(getApplicationContext(), "INTERFACING_DC_MOTOR_TO_8051", ".pdf", "Downloads", uri.trim());
    }
    private void MR3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Microcontroller/Microcontroller%208051%20Chapter_1.VR17.pdf";
        download(getApplicationContext(), "Introduction_To_8051", ".pdf", "Downloads", uri.trim());
    }
    private void MR4NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Microcontroller/Microcontroller%208051%20Chapter_2.VR17.pdf";
        download(getApplicationContext(), "instruction_set_Programming(8051)", ".pdf", "Downloads", uri.trim());
    }
    private void MR5NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Microcontroller/Timing%20Diagram%20and%20Interrupts.pdf";
        download(getApplicationContext(), "Timing_Diagram_and_Interrupts", ".pdf", "Downloads", uri.trim());
    }
    private void MR6NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Microcontroller/Unit_Microcontroller%20.pdf";
        download(getApplicationContext(), "QNA_Microcontroller(10_IMP_Q.)", ".pdf", "Downloads", uri.trim());
    }

    private void COM1NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CN/CN%207%20OSI.pptx";
        download(getApplicationContext(), "OSI_Model", ".pptx", "Downloads", uri.trim());
    }
    private void COM2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CN/CN%20TCP%20IP%20MODEL.pptx";
        download(getApplicationContext(), "TCP_IP_MODEL", ".pptx", "Downloads", uri.trim());
    }
    private void COM3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CN/CN8%20IP%20Address.pptx";
        download(getApplicationContext(), "IP_Addressing", ".pptx", "Downloads", uri.trim());
    }
    private void COM4NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CN/CN5.pptx";
        download(getApplicationContext(), "Network_Topology", ".pptx", "Downloads", uri.trim());
    }
    private void COM5NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CN/CN6.pptx";
        download(getApplicationContext(), "Network_Devices", ".pptx", "Downloads", uri.trim());
    }
    private void COM6NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/CN/CN9.pptx";
        download(getApplicationContext(), "Ethernet_NAT_DHCP", ".pptx", "Downloads", uri.trim());
    }

    private void DBMS1NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/DBMS/Unit%20No.5(Transaction%20Processing).pptx";
        download(getApplicationContext(), "Transaction_Processing", ".pptx", "Downloads", uri.trim());
    }
    private void DBMS2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/DBMS/Unit%20No2(Relational%20Data%20Model).pptx";
        download(getApplicationContext(), "Relational_Data_Model", ".pptx", "Downloads", uri.trim());
    }
    private void DBMS3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/DBMS/6.%20PL%20SQL%20Programming.docx";
        download(getApplicationContext(), "PL/SQL_Programming", ".docx", "Downloads", uri.trim());
    }
   //----------------------------->
   private void C1NOTE() {
       String uri = "https://studydocs.netlify.app/Notes/c/chapter1.pdf";
       download(getApplicationContext(), "Basic_of_c_part1", ".pdf", "Downloads", uri.trim());
   }
    private void C2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/c/Basic%20of%20C.pdf";
        download(getApplicationContext(), "Basic_of_c_part2", ".pdf", "Downloads", uri.trim());
    }
    private void C3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/c/chapter3.pdf";
        download(getApplicationContext(), "Arrays_and_Strings", ".pdf", "Downloads", uri.trim());
    }
    private void C4NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/c/Chapter%204.pdf.pdf";
        download(getApplicationContext(), "Functions", ".pdf", "Downloads", uri.trim());
    }
    private void C5NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/c/Chapter%205.pdf.pdf";
        download(getApplicationContext(), "Structure_and_Union", ".pdf", "Downloads", uri.trim());
    }
    private void C6NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/c/Chatper%206.pdf.pdf";
        download(getApplicationContext(), "Pointers", ".pdf", "Downloads", uri.trim());
    }
    //------------------->
    private void OS1NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/OS/Overview%20of%20Operating%20System.pdf";
        download(getApplicationContext(), "Overview_of_Operating_System", ".pdf", "Downloads", uri.trim());
    }
    private void OS2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/OS/2.%20Operating%20System%20Principles.pdf";
        download(getApplicationContext(), "Operating_System_Principles", ".pdf", "Downloads", uri.trim());
    }
    private void OS3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/OS/Process%20Management.pdf";
        download(getApplicationContext(), "Process_Management", ".pdf", "Downloads", uri.trim());
    }
    private void OS4NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/OS/File%20management.pdf";
        download(getApplicationContext(), "File_management", ".pdf", "Downloads", uri.trim());
    }
    private void OS5NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/OS/5.%20Memory%20management.pdf";
        download(getApplicationContext(), "Memory_management", ".pdf", "Downloads", uri.trim());
    }
    private void OS6NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/OS/4.%20CPU%20Scheduling%20&%20Deadlock.pdf";
        download(getApplicationContext(), "CPU_Scheduling_&_Deadlock", ".pdf", "Downloads", uri.trim());
    }

//----------------------------------------------->

    private void SE1NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Software/Overview%20of%20Software%20Engineering.pdf";
        download(getApplicationContext(), "Overview_of_Software_Engineering", ".pdf", "Downloads", uri.trim());
    }
    private void SE2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Software/Agile%20Software%20Methodology.pdf";
        download(getApplicationContext(), "Agile_Software_Methodology", ".pdf", "Downloads", uri.trim());
    }
    private void SE3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Software/Prescriptive%20Process%20Models.pdf";
        download(getApplicationContext(), "Prescriptive_Process_Models", ".pdf", "Downloads", uri.trim());
    }
    private void SE4NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Software/Software%20Engineering%20Practices.pdf";
        download(getApplicationContext(), "Software_Engineering_Practices", ".pdf", "Downloads", uri.trim());
    }
    private void SE5NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Software/Software%20modeling.pdf";
        download(getApplicationContext(), "Software_modeling", ".pdf", "Downloads", uri.trim());
    }

//----------------------------------->

    private void JAVA1NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Java/JAVA_CHAPTER_1.pdf";
        download(getApplicationContext(), "DATA-TYPE_FLOW-CONTROL_ARRAY", ".pdf", "Downloads", uri.trim());
    }
    private void JAVA2NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Java/JAVA_CHAPTER_2.pdf";
        download(getApplicationContext(), "CLASS_INTERFACES_PACKAGES", ".pdf", "Downloads", uri.trim());
    }
    private void JAVA3NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Java/JAVA_CHAPTER_3.pdf";
        download(getApplicationContext(), "GENERICS", ".pdf", "Downloads", uri.trim());
    }
    private void JAVA4NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Java/JAVA_CHAPTER_4.pdf";
        download(getApplicationContext(), "LAMBDA_EXPRESSION", ".pdf", "Downloads", uri.trim());
    }
    private void JAVA5NOTE() {
        String uri = "https://studydocs.netlify.app/Notes/Java/JAVA_CHAPTER_5.pdf";
        download(getApplicationContext(), "COLLECTION-FRAMEWORK_STREAM-API", ".pdf", "Downloads", uri.trim());
    }

    private void STQANOTES1() {
        String uri = "https://studydocs.netlify.app/Notes/STQA/ST%20&%20QA.pdf";
        download(getApplicationContext(), "STQA_Notes", ".pdf", "Downloads", uri.trim());
    }


    private void download(Context context, String Filename, String FileExtension, String DesignationDirectory, String url) {
        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, DesignationDirectory, Filename + FileExtension);
        assert downloadManager != null;
        downloadManager.enqueue(request);
        Snackbar snackbar = (Snackbar) Snackbar
                .make(findViewById(android.R.id.content), "Downloading...", Snackbar.LENGTH_LONG);
        snackbar.show();



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