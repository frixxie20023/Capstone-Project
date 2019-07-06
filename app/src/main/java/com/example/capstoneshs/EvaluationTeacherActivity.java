package com.example.capstoneshs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class EvaluationTeacherActivity extends AppCompatActivity {
    private TextView A1,A2,A3,A4,B1,B2,B3,B4,B5,B6,C1,C2,C3,C4,C5,C6,C7,C8,D1,D2,D3,D4,D5,D6,D7,D8,D9;
    private int a1,a2,a3,a4,b1,b2,b3,b4,b5,b6,c1,c2,c3,c4,c5,c6,c7,c8,d1,d2,d3,d4,d5,d6,d7,d8,d9;
    private String userId,teacherId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_teacher);
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
        teacherId = newString;

        SeekBar seekBarA1 = findViewById(R.id.seekBarA1);
        SeekBar seekBarA2 = findViewById(R.id.seekBarA2);
        SeekBar seekBarA3 = findViewById(R.id.seekBarA3);
        SeekBar seekBarA4 = findViewById(R.id.seekBarA4);

        SeekBar seekBarB1 = findViewById(R.id.seekBarB1);
        SeekBar seekBarB2 = findViewById(R.id.seekBarB2);
        SeekBar seekBarB3 = findViewById(R.id.seekBarB3);
        SeekBar seekBarB4 = findViewById(R.id.seekBarB4);
        SeekBar seekBarB5 = findViewById(R.id.seekBarB5);
        SeekBar seekBarB6 = findViewById(R.id.seekBarB6);

        SeekBar seekBarC1 = findViewById(R.id.seekBarC1);
        SeekBar seekBarC2 = findViewById(R.id.seekBarC2);
        SeekBar seekBarC3 = findViewById(R.id.seekBarC3);
        SeekBar seekBarC4 = findViewById(R.id.seekBarC4);
        SeekBar seekBarC5 = findViewById(R.id.seekBarC5);
        SeekBar seekBarC6 = findViewById(R.id.seekBarC6);
        SeekBar seekBarC7 = findViewById(R.id.seekBarC7);
        SeekBar seekBarC8 = findViewById(R.id.seekBarC8);

        SeekBar seekBarD1 = findViewById(R.id.seekBarD1);
        SeekBar seekBarD2 = findViewById(R.id.seekBarD2);
        SeekBar seekBarD3 = findViewById(R.id.seekBarD3);
        SeekBar seekBarD4 = findViewById(R.id.seekBarD4);
        SeekBar seekBarD5 = findViewById(R.id.seekBarD5);
        SeekBar seekBarD6 = findViewById(R.id.seekBarD6);
        SeekBar seekBarD7 = findViewById(R.id.seekBarD7);
        SeekBar seekBarD8 = findViewById(R.id.seekBarD8);
        SeekBar seekBarD9 = findViewById(R.id.seekBarD9);

        A1 = findViewById(R.id.rateA1);
        A2 = findViewById(R.id.rateA2);
        A3 = findViewById(R.id.rateA3);
        A4 = findViewById(R.id.rateA4);

        B1 = findViewById(R.id.rateB1);
        B2 = findViewById(R.id.rateB2);
        B3 = findViewById(R.id.rateB3);
        B4 = findViewById(R.id.rateB4);
        B5 = findViewById(R.id.rateB5);
        B6 = findViewById(R.id.rateB6);

        C1 = findViewById(R.id.rateC1);
        C2 = findViewById(R.id.rateC2);
        C3 = findViewById(R.id.rateC3);
        C4 = findViewById(R.id.rateC4);
        C5 = findViewById(R.id.rateC5);
        C6 = findViewById(R.id.rateC6);
        C7 = findViewById(R.id.rateC7);
        C8 = findViewById(R.id.rateC8);

        D1 = findViewById(R.id.rateD1);
        D2 = findViewById(R.id.rateD2);
        D3 = findViewById(R.id.rateD3);
        D4 = findViewById(R.id.rateD4);
        D5 = findViewById(R.id.rateD5);
        D6 = findViewById(R.id.rateD6);
        D7 = findViewById(R.id.rateD7);
        D8 = findViewById(R.id.rateD8);
        D9 = findViewById(R.id.rateD9);

        seekBarA1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                A1.setText(String.valueOf(progress));
                a1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarA2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                A2.setText(String.valueOf(progress));
                a2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarA3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                A3.setText(String.valueOf(progress));
                a3 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarA4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                A4.setText(String.valueOf(progress));
                a4 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                B1.setText(String.valueOf(progress));
                b1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                B2.setText(String.valueOf(progress));
                b2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                B3.setText(String.valueOf(progress));
                b3 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                B4.setText(String.valueOf(progress));
                b4 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                B5.setText(String.valueOf(progress));
                b5 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarB6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                B6.setText(String.valueOf(progress));
                b6 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C1.setText(String.valueOf(progress));
                c1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C2.setText(String.valueOf(progress));
                c2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C3.setText(String.valueOf(progress));
                c3 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C4.setText(String.valueOf(progress));
                c4 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C5.setText(String.valueOf(progress));
                c5 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C6.setText(String.valueOf(progress));
                c6 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C7.setText(String.valueOf(progress));
                c7 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarC8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                C8.setText(String.valueOf(progress));
                c8 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D1.setText(String.valueOf(progress));
                d1 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D2.setText(String.valueOf(progress));
                d2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D3.setText(String.valueOf(progress));
                d3 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D4.setText(String.valueOf(progress));
                d4 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D5.setText(String.valueOf(progress));
                d5 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D6.setText(String.valueOf(progress));
                d6 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D7.setText(String.valueOf(progress));
                d7 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D8.setText(String.valueOf(progress));
                d8 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarD9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                D9.setText(String.valueOf(progress));
                d9 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total_A = a1 + a2 + a3 + a4;
                int average_A = total_A/4;

                int total_B = b1 + b2 + b3 + b4 + b5 + b6;
                int average_B = total_B/6;

                int total_C = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;
                int average_C = total_C/8;

                int total_D = d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9;
                int average_D = total_D/9;
                EvaluationAverageStudent evaluationAverage = new EvaluationAverageStudent(average_A,average_B,average_C,average_D," ",userId,teacherId);
                FirebaseDatabase.getInstance().getReference("Student to Teacher Evaluation").child(teacherId).child(userId).setValue(evaluationAverage).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Intent intent = new Intent(EvaluationTeacherActivity.this, StudentHomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            userId = user.getUid();
        }
    }
}
