package com.example.capstoneshs;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotificaitonFragmentStudent extends Fragment implements AnnouncementAdapter.AnnouncementListener {
    View view;
    private ProgressBar loader;
    private RecyclerView recyclerView;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser mUser = mAuth.getCurrentUser();
    private String userId;
    private List<AnnouncementClass> announcementClassList = new ArrayList<>();
    public NotificaitonFragmentStudent() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.notification_fragment_student,container,false);

        recyclerView = view.findViewById(R.id.announcement_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        loader = view.findViewById(R.id.loader);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mUser != null)
        {
            userId = mUser.getUid();
            setupData();
        } else {
            Intent i = new Intent(getActivity(), LoginActivity.class);
            startActivity(i);
        }
    }

    private void setupData() {
        FirebaseDatabase.getInstance().getReference("Announcements/Students").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                announcementClassList.clear();
                for (DataSnapshot snapShot: dataSnapshot.getChildren())
                {
                    loader.setVisibility(View.GONE);
                    announcementClassList.add(new AnnouncementClass(snapShot.child("Message").getValue(String.class),snapShot.child("Date").getValue(String.class),snapShot.child("Subject").getValue(String.class),snapShot.child("Location").getValue(String.class),snapShot.child("Time").getValue(String.class)));
                    InitAnnouncementAdapter();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void InitAnnouncementAdapter(){
        AnnouncementAdapter adapter = new AnnouncementAdapter(announcementClassList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAnnouncementClick(int position) {

        Toast.makeText(getContext(), announcementClassList.get(position).getMessage(), Toast.LENGTH_SHORT).show();
    }
}
