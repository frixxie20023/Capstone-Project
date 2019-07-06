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

public class FragmentViewInformation extends Fragment {
    View view;
    private TextView school,address,hobbies,degree;
    private String userId;
    private LinearLayout parentLayout, subLayout, loader_layout;
    private Dialog profile_setup_dialog,progress_loader;
    public FragmentViewInformation(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_view_information,container,false);
        parentLayout = view.findViewById(R.id.parent_layout);

        loader_layout = view.findViewById(R.id.progress_loader);
        school = view.findViewById(R.id.textView);
        hobbies = view.findViewById(R.id.textView2);
        degree = view.findViewById(R.id.textView3);
        address = view.findViewById(R.id.textView4);
        progress_loader = new Dialog(Objects.requireNonNull(getActivity()));
        progress_loader.setContentView(R.layout.progress_dialog);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            userId = bundle.getString("ID_NEEDED");

            FirebaseDatabase.getInstance().getReference("Teachers").child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (Objects.requireNonNull(dataSnapshot.child("School").getValue(String.class)).equals("")) {

                        loader_layout.setVisibility(View.GONE);
                    } else {
                        loader_layout.setVisibility(View.GONE);
                        parentLayout.setVisibility(View.VISIBLE);

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
        }



        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null)
        {


        } else {
            Intent intent = new Intent(getActivity(),LoginActivity.class);
            startActivity(intent);
        }
    }
}
