package com.example.capstoneshs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ViewScheduleActivity extends AppCompatActivity {
    private Button btnetup;
    private String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);
        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("userId");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("userId");
        }
        userId = newString;
        CardView cardMonday = findViewById(R.id.monday_card);
        cardMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewScheduleActivity.this,ViewMondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","MONDAY");
                intent.putExtra("TEACHER_ID",userId);
                startActivity(intent);
            }
        });

        CardView cardTuesday = findViewById(R.id.tuesday_card);
        cardTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewScheduleActivity.this,ViewMondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","TUESDAY");
                intent.putExtra("TEACHER_ID",userId);
                startActivity(intent);
            }
        });

        CardView cardWednesday = findViewById(R.id.wednesday_card);
        cardWednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewScheduleActivity.this,ViewMondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","WEDNESDAY");
                intent.putExtra("TEACHER_ID",userId);
                startActivity(intent);
            }
        });

        CardView cardThursday = findViewById(R.id.thursday_card);
        cardThursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewScheduleActivity.this,ViewMondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","THURSDAY");
                intent.putExtra("TEACHER_ID",userId);
                startActivity(intent);
            }
        });

        CardView cardFriday = findViewById(R.id.friday_card);
        cardFriday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewScheduleActivity.this,ViewMondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","FRIDAY");
                intent.putExtra("TEACHER_ID",userId);
                startActivity(intent);
            }
        });

        CardView cardSaturday = findViewById(R.id.saturday_card);
        cardSaturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewScheduleActivity.this,ViewMondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","SATURDAY");
                intent.putExtra("TEACHER_ID",userId);
                startActivity(intent);
            }
        });
    }
}
