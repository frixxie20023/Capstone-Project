package com.example.capstoneshs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class EvaluationActivity extends AppCompatActivity {
    private int A1,A2,A3,A4,A5,A6,A7,A8;
    private int B1,B2,B3,B4,B5,B6,B7,B8,B9,B10,B11,B12,B13,B14;
    private String userId,teacherId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
        {
            userId = user.getUid();
        } else {
            Intent intent = new Intent(EvaluationActivity.this,LoginActivity.class);
            startActivity(intent);
        }


        SeekBar seekBarA1 = findViewById(R.id.seekBarA1);
        SeekBar seekBarA2 = findViewById(R.id.seekBarA2);
        SeekBar seekBarA3 = findViewById(R.id.seekBarA3);
        SeekBar seekBarA4 = findViewById(R.id.seekBarA4);
        SeekBar seekBarA5 = findViewById(R.id.seekBarA5);
        SeekBar seekBarA6 = findViewById(R.id.seekBarA6);
        SeekBar seekBarA7 = findViewById(R.id.seekBarA7);
        SeekBar seekBarA8 = findViewById(R.id.seekBarA8);

        SeekBar seekBarB1 = findViewById(R.id.seekBarB1);
        SeekBar seekBarB2 = findViewById(R.id.seekBarB2);
        SeekBar seekBarB3 = findViewById(R.id.seekBarB3);
        SeekBar seekBarB4 = findViewById(R.id.seekBarB4);
        SeekBar seekBarB5 = findViewById(R.id.seekBarB5);
        SeekBar seekBarB6 = findViewById(R.id.seekBarB6);
        SeekBar seekBarB7 = findViewById(R.id.seekBarB7);
        SeekBar seekBarB8 = findViewById(R.id.seekBarB8);
        SeekBar seekBarB9 = findViewById(R.id.seekBarB9);
        SeekBar seekBarB10 = findViewById(R.id.seekBarB10);
        SeekBar seekBarB11 = findViewById(R.id.seekBarB11);
        SeekBar seekBarB12 = findViewById(R.id.seekBarB12);
        SeekBar seekBarB13= findViewById(R.id.seekBarB13);
        SeekBar seekBarB14= findViewById(R.id.seekBarB14);

        final TextView rateA1 = findViewById(R.id.rateA1);
        final TextView rateA2 = findViewById(R.id.rateA2);
        final TextView rateA3 = findViewById(R.id.rateA3);
        final TextView rateA4 = findViewById(R.id.rateA4);
        final TextView rateA5 = findViewById(R.id.rateA5);
        final TextView rateA6 = findViewById(R.id.rateA6);
        final TextView rateA7 = findViewById(R.id.rateA7);
        final TextView rateA8 = findViewById(R.id.rateA8);

        final TextView rateB1 = findViewById(R.id.rateB1);
        final TextView rateB2 = findViewById(R.id.rateB2);
        final TextView rateB3 = findViewById(R.id.rateB3);
        final TextView rateB4 = findViewById(R.id.rateB4);
        final TextView rateB5 = findViewById(R.id.rateB5);
        final TextView rateB6 = findViewById(R.id.rateB6);
        final TextView rateB7 = findViewById(R.id.rateB7);
        final TextView rateB8 = findViewById(R.id.rateB8);
        final TextView rateB9 = findViewById(R.id.rateB9);
        final TextView rateB10 = findViewById(R.id.rateB10);
        final TextView rateB11 = findViewById(R.id.rateB11);
        final TextView rateB12 = findViewById(R.id.rateB12);
        final TextView rateB13 = findViewById(R.id.rateB13);
        final TextView rateB14 = findViewById(R.id.rateB14);

        seekBarA1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateA1.setText(String.valueOf(progress));
                A1 = progress;
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
                rateA2.setText(String.valueOf(progress));
                A2 = progress;
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
                rateA3.setText(String.valueOf(progress));
                A3 = progress;
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
                rateA4.setText(String.valueOf(progress));
                A4 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarA5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateA5.setText(String.valueOf(progress));
                A5 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarA6.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateA6.setText(String.valueOf(progress));
                A6 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarA7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateA7.setText(String.valueOf(progress));
                A7 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarA8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateA8.setText(String.valueOf(progress));
                A8 = progress;
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
                rateB1.setText(String.valueOf(progress));
                B1 = progress;
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
                rateB2.setText(String.valueOf(progress));
                B2 = progress;
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
                rateB3.setText(String.valueOf(progress));
                B3 = progress;
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
                rateB4.setText(String.valueOf(progress));
                B4 = progress;
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
                rateB5.setText(String.valueOf(progress));
                B5 = progress;
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
                rateB6.setText(String.valueOf(progress));
                B6 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB7.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB7.setText(String.valueOf(progress));
                B7 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB8.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB8.setText(String.valueOf(progress));
                B8 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB9.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB9.setText(String.valueOf(progress));
                B9 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB10.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB10.setText(String.valueOf(progress));
                B10 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB11.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB11.setText(String.valueOf(progress));
                B11 = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB12.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB12.setText(String.valueOf(progress));
                B12 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB13.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB13.setText(String.valueOf(progress));
                B13 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarB14.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rateB14.setText(String.valueOf(progress));
                B14 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btn_submit = findViewById(R.id.submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int totalA = A1 + A2 + A3 + A4 + A5 + A6 + A7 + A8;
                int averageA = totalA/8;
                Toast.makeText(EvaluationActivity.this, String.valueOf(averageA), Toast.LENGTH_SHORT).show();

                int totalB = B1 + B2 + B3 + B4 + B5 + B6 + B7 + B8 + B9 + B10 + B11 + B12 + B13 + B14;
                int averageB = totalB/14;
                Toast.makeText(EvaluationActivity.this, "Average B" + String.valueOf(averageB) + "Average A " + String.valueOf(averageA), Toast.LENGTH_SHORT).show();

                EvaluationAverage evaluationAverage = new EvaluationAverage(averageA,averageB," ",userId,teacherId);
                FirebaseDatabase.getInstance().getReference("Teacher to Teacher Evaluation").child(teacherId).child(userId).setValue(evaluationAverage).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Intent intent = new Intent(EvaluationActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        });

    }
}
