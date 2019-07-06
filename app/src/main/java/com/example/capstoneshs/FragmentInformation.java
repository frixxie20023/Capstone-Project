package com.example.capstoneshs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentInformation extends Fragment {
    View view;
    private TextView school,address,hobbies,degree;
    private String userId;
    private LinearLayout parentLayout, subLayout, loader_layout;
    private Dialog profile_setup_dialog,progress_loader;
    public FragmentInformation(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_information,container,false);
        parentLayout = view.findViewById(R.id.parent_layout);
        subLayout = view.findViewById(R.id.sub_parent);
        loader_layout = view.findViewById(R.id.progress_loader);
        school = view.findViewById(R.id.textView);
        hobbies = view.findViewById(R.id.textView2);
        degree = view.findViewById(R.id.textView3);
        address = view.findViewById(R.id.textView4);
        progress_loader = new Dialog(Objects.requireNonNull(getActivity()));
        progress_loader.setContentView(R.layout.progress_dialog);
        Button button_setup = view.findViewById(R.id.setup_button);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
        {
            userId = user.getUid();
        } else {
            Intent intent = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);
        }

        button_setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile_setup_dialog = new Dialog(Objects.requireNonNull(getActivity()));
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

        return view;
    }
    private void insertProfileInformation(String school, String hobbies, String degree, String address) {
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("Address").setValue(address);
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("School").setValue(school);
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("Degree").setValue(degree);
        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).child("Hobbies").setValue(hobbies).addOnCompleteListener(Objects.requireNonNull(getActivity()), new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    profile_setup_dialog.hide();
                    Toast.makeText(getContext(), "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null)
        {
            userId = user.getUid();
            FirebaseDatabase.getInstance().getReference("Teachers").child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (Objects.requireNonNull(dataSnapshot.child("School").getValue(String.class)).equals("")) {
                        subLayout.setVisibility(View.VISIBLE);
                        loader_layout.setVisibility(View.GONE);
                    } else {
                        loader_layout.setVisibility(View.GONE);
                        parentLayout.setVisibility(View.VISIBLE);
                        subLayout.setVisibility(View.GONE);
                        school.setText("STUDIED AT: " + dataSnapshot.child("School").getValue(String.class));
                        hobbies.setText("LIKES: " + dataSnapshot.child("Hobbies").getValue(String.class));
                        address.setText("FROM: " + dataSnapshot.child("Address").getValue(String.class));
                        degree.setText("DEGREE OF: " + dataSnapshot.child("Degree").getValue(String.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        } else {
            Intent intent = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);
        }
    }
}
