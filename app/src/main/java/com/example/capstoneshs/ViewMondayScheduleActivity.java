package com.example.capstoneshs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baoyachi.stepview.VerticalStepView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ViewMondayScheduleActivity extends AppCompatActivity {
    private Dialog setupDialog;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser mUser = mAuth.getCurrentUser();
    private String userId;
    private String day,teacher_id;
    private List<String> list0 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_monday_schedule);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                day= null;
                teacher_id = null;
            } else {
                day= extras.getString("DAY_CODE");
                teacher_id = extras.getString("TEACHER_ID");
            }
        } else {
            day= (String) savedInstanceState.getSerializable("DAY_CODE");
            teacher_id= (String) savedInstanceState.getSerializable("TEACHER_ID");
        }

        Toast.makeText(this, teacher_id, Toast.LENGTH_SHORT).show();
        insertScheduleToStepper();


    }



    private void insertScheduleToStepper(){
        list0.clear();
        FirebaseDatabase.getInstance().getReference("Schedule")
                .child(teacher_id)
                .child(day).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot childSnap: dataSnapshot.getChildren()) {
                    list0.add(childSnap.child("start_time").getValue(String.class)
                            + " to " + childSnap.child("end_time").getValue(String.class)
                            + "\nSubject: " + childSnap.child("subject").getValue(String.class) + "\nSection: "
                            + childSnap.child("section").getValue(String.class) + "\nClassroom: "
                            + childSnap.child("class_room").getValue(String.class) );
                    Toast.makeText(ViewMondayScheduleActivity.this, childSnap.child("start_time").getValue(String.class), Toast.LENGTH_SHORT).show();
                    initializeStepper();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void initializeStepper(){
        VerticalStepView mSetpview0 =  findViewById(R.id.step_view);

        mSetpview0.reverseDraw(false)//default is true
                .setStepViewTexts(list0)//总步骤
                .setStepsViewIndicatorComplectingPosition(list0.size())
                .setLinePaddingProportion(3.5f)//设置indicator线与线间距的比例系数
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.colorPrimary))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(this, R.color.colorPrimary))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.colorPrimary))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(this, R.drawable.default_icon))
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this,R.color.colorAccent));//设置StepsViewIndicator AttentionIcon
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (mUser != null)
        {


        } else {
            Intent i = new Intent(ViewMondayScheduleActivity.this,LoginActivity.class);
            startActivity(i);
        }
    }


}
