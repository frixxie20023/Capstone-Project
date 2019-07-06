package com.example.capstoneshs;


import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private String userId;
    private FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();
    TextView dateView, time;
    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
    public static String codeValue = null;
    public static boolean isPerformedScan = false;

    private BottomAppBar bar;
    private boolean fbModeCenter = true;
    private FloatingActionButton fab;
    Dialog menuDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        init();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
            }
        });

        if (mUser != null)
        {
            userId = mUser.getUid();
            FirebaseDatabase.getInstance().getReference("Leave Request").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot snap: dataSnapshot.getChildren())
                    {
                        if (userId.equals(snap.child("user_id").getValue(String.class))){
                            if (Objects.requireNonNull(snap.child("status").getValue(String.class)).equals("approved"))
                            {
                                initApprovedRequest();
                            } else if (Objects.requireNonNull(snap.child("status").getValue(String.class)).equals("declined")){
                                initDeclinedRequest();
                            }
                        }
                    }


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuDialog();
            }
        });





    }

    private void initDeclinedRequest() {
        Notification notification = new NotificationCompat.Builder(this,"channel1")
                .setSmallIcon(R.drawable.default_icon)
                .setContentTitle("Leave Request")
                .setContentText("your request for leave have been Declined by the admin")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);

    }

    private void initApprovedRequest() {
        Notification notification = new NotificationCompat.Builder(this,"channel1")
                .setSmallIcon(R.drawable.default_icon)
                .setContentTitle("Leave Request")
                .setContentText("your request for leave have been Approved by the admin")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);
    }


    private void MenuDialog() {
        menuDialog = new Dialog(MainActivity.this);
        menuDialog.setContentView(R.layout.menu_custom_dialog);
        menuDialog.setTitle("Menu Dialog");
        menuDialog.show();
        CardView cardLeave = menuDialog.findViewById(R.id.card_leave);
        CardView cardSchedule = menuDialog.findViewById(R.id.card_schedule);
        cardLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LeaveActivity.class);
                startActivity(intent);
            }
        });

        cardSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean Evaluate(MenuItem item){
        Fragment fragment = new EvaluationFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();
        return true;
    }


    public boolean search(MenuItem item){
        Fragment fragment = new NotificaitonFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment);
        fragmentTransaction.commit();


        return true;
    }

    public boolean profile(MenuItem item){
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
        return true;
    }

    private void init() {
        this.bar = findViewById(R.id.bar);
        setSupportActionBar(bar);
        this.fab = findViewById(R.id.fab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bbar, menu);
        return true;
    }


    private void reset() {
        isPerformedScan = false;
        BarcodeGraphic.numOfSuccessRead = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isPerformedScan && codeValue != null) {
//            showChooseRoom();
            isPerformedScan = false;
            fetchRecord(codeValue);

        }else {
            codeValue = null;
        }
    }

    private void fetchRecord(String codeValue) {
        if (codeValue != null) {
            Fragment fragment = new AttendanceFragment();
            Bundle bundle = new Bundle();
            bundle.putString("QRVALUE",codeValue);
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainer, fragment);
            fragmentTransaction.commit();
        }
    }
}
