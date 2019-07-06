package com.example.capstoneshs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class SettingsActivity extends AppCompatActivity {
    private TextView logout,test,profile;
    private Dialog profile_setup_dialog;
    private String userId;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        logout = findViewById(R.id.logout);
        test = findViewById(R.id.test);
        profile = findViewById(R.id.set_profile);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, PersonalityTest.class);
                startActivity(intent);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_setup_dialog = new Dialog(SettingsActivity.this);
                profile_setup_dialog.setContentView(R.layout.profile_setup_dialog);
                profile_setup_dialog.setTitle("Menu Dialog");
                profile_setup_dialog.show();
                final TextView school_textView = profile_setup_dialog.findViewById(R.id.school);
                final TextView hobbies_textView = profile_setup_dialog.findViewById(R.id.hobbies);
                final TextView degree_textView = profile_setup_dialog.findViewById(R.id.profession);
                final TextView address_textView = profile_setup_dialog.findViewById(R.id.address);
                Button submit_button = profile_setup_dialog.findViewById(R.id.submit);
                Button cancel_button = profile_setup_dialog.findViewById(R.id.cancel);

                submit_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        insertProfileInformation(school_textView.getText().toString(),hobbies_textView.getText().toString(),degree_textView.getText().toString(),address_textView.getText().toString());
                    }
                });

                cancel_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        profile_setup_dialog.hide();
                    }
                });
            }
        });
    }
    private void insertProfileInformation(String school, String hobbies, String degree, String address) {
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("Address").setValue(address);
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("School").setValue(school);
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("Degree").setValue(degree);
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("Hobbies").setValue(hobbies).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    profile_setup_dialog.hide();
                    Toast.makeText(SettingsActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
        {
            userId = user.getUid();
        } else {
            Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
