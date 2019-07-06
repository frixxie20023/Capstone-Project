package com.example.capstoneshs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class EvaluationFragmentStudent extends Fragment implements AdapterStudent.OnNoteListener {
    private RecyclerView recyclerView;
    private List<ModelClass> modelClassesList = new ArrayList<>();
    private ProgressBar loader;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    private Dialog menuDialog;
    public EvaluationFragmentStudent(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.evaluation_fragment,container,false);
        recyclerView = view.findViewById(R.id.my_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        loader = view.findViewById(R.id.loader);

        return view;
    }
    private void initAdapter(){
        AdapterStudent adapter = new AdapterStudent(modelClassesList,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onNoteClick(final int position) {
        menuDialog = new Dialog(Objects.requireNonNull(getActivity()));
        menuDialog.setContentView(R.layout.menu_dialog);
        menuDialog.setTitle("Menu Dialog");
        menuDialog.show();
        CardView option1 = menuDialog.findViewById(R.id.evaluate);
        CardView option2 = menuDialog.findViewById(R.id.profile);
        CardView option3 = menuDialog.findViewById(R.id.schedule);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CHECKO", String.valueOf(modelClassesList.get(position).getUserId()));
                Intent intent = new Intent(getActivity(),EvaluationTeacherActivity.class);
                intent.putExtra("userId",modelClassesList.get(position).getUserId());
                startActivity(intent);
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ViewProfileActivity.class);
                intent.putExtra("userId",modelClassesList.get(position).getUserId());
                startActivity(intent);
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ViewScheduleActivity.class);
                intent.putExtra("userId",modelClassesList.get(position).getUserId());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        if (user != null) {
            String userId = user.getUid();
            setUpData(userId);
        }
    }

    private void setUpData(final String userId) {

        FirebaseDatabase.getInstance().getReference("Teachers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelClassesList.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren())
                {

                    loader.setVisibility(View.GONE);
                    String fullName = snapshot.child("First_Name").getValue(String.class) + " " + snapshot.child("Last_Name").getValue(String.class);
                    modelClassesList.add(new ModelClass(R.drawable.ic_person_outline_black_24dp,fullName,snapshot.child("Degree").getValue(String.class),snapshot.getKey()));
                    initAdapter();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
