package com.example.capstoneshs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScheduleActivity extends AppCompatActivity {
    private Button btnetup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        CardView cardMonday = findViewById(R.id.monday_card);
        cardMonday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this,MondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","MONDAY");
                startActivity(intent);
            }
        });

        CardView cardTuesday = findViewById(R.id.tuesday_card);
        cardTuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this,MondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","TUESDAY");
                startActivity(intent);
            }
        });

        CardView cardWednesday = findViewById(R.id.wednesday_card);
        cardWednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this,MondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","WEDNESDAY");
                startActivity(intent);
            }
        });

        CardView cardThursday = findViewById(R.id.thursday_card);
        cardThursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this,MondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","THURSDAY");
                startActivity(intent);
            }
        });

        CardView cardFriday = findViewById(R.id.friday_card);
        cardFriday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this,MondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","FRIDAY");
                startActivity(intent);
            }
        });

        CardView cardSaturday = findViewById(R.id.saturday_card);
        cardSaturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this,MondayScheduleActivity.class);
                intent.putExtra("DAY_CODE","SATURDAY");
                startActivity(intent);
            }
        });
    }
}
