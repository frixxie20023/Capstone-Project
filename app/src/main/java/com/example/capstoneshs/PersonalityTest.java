package com.example.capstoneshs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class PersonalityTest extends AppCompatActivity {
    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5, radioGroup6, radioGroup7, radioGroup8, radioGroup9, radioGroup10, radioGroup11, radioGroup12, radioGroup13, radioGroup14, radioGroup15, radioGroup16, radioGroup17, radioGroup18, radioGroup19, radioGroup20;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6, radioButton7, radioButton8, radioButton9, radioButton10, radioButton11, radioButton12, radioButton13, radioButton14, radioButton15, radioButton16, radioButton17, radioButton18, radioButton19, radioButton20;
    Button btnSubmit;
    private FirebaseUser user;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_test);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null)
        {
            uid = user.getUid();
        } else {
            Toast.makeText(this, "Please log in", Toast.LENGTH_SHORT).show();
        }


        radioGroup1 = findViewById(R.id.radio_group_1);
        radioGroup2 = findViewById(R.id.radio_group_2);
        radioGroup3 = findViewById(R.id.radio_group_3);
        radioGroup4 = findViewById(R.id.radio_group_4);
        radioGroup5 = findViewById(R.id.radio_group_5);
        radioGroup6 = findViewById(R.id.radio_group_6);
        radioGroup7 = findViewById(R.id.radio_group_7);
        radioGroup8 = findViewById(R.id.radio_group_8);
        radioGroup9 = findViewById(R.id.radio_group_9);
        radioGroup10 = findViewById(R.id.radio_group_10);
        radioGroup11 = findViewById(R.id.radio_group_11);
        radioGroup12 = findViewById(R.id.radio_group_12);
        radioGroup13 = findViewById(R.id.radio_group_13);
        radioGroup14 = findViewById(R.id.radio_group_14);
        radioGroup15 = findViewById(R.id.radio_group_15);
        radioGroup16 = findViewById(R.id.radio_group_16);
        radioGroup17 = findViewById(R.id.radio_group_17);
        radioGroup18 = findViewById(R.id.radio_group_18);
        radioGroup19 = findViewById(R.id.radio_group_19);
        radioGroup20 = findViewById(R.id.radio_group_20);

        btnSubmit = findViewById(R.id.submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
            }
        });
    }

    private void getValue() {
        String[] values;
        int a1 = 0;
        int b1 = 0;
        int a2 = 0;
        int b2 = 0;
        int a3 = 0;
        int b3 = 0;
        int a4 = 0;
        int b4 = 0;
        int a5 = 0;
        int b5 = 0;
        int radioId1 = radioGroup1.getCheckedRadioButtonId();
        int radioId2 = radioGroup2.getCheckedRadioButtonId();
        int radioId3 = radioGroup3.getCheckedRadioButtonId();
        int radioId4 = radioGroup4.getCheckedRadioButtonId();
        int radioId5 = radioGroup5.getCheckedRadioButtonId();
        int radioId6 = radioGroup6.getCheckedRadioButtonId();
        int radioId7 = radioGroup7.getCheckedRadioButtonId();
        int radioId8 = radioGroup8.getCheckedRadioButtonId();
        int radioId9 = radioGroup9.getCheckedRadioButtonId();
        int radioId10 = radioGroup10.getCheckedRadioButtonId();
        int radioId11 = radioGroup11.getCheckedRadioButtonId();
        int radioId12 = radioGroup12.getCheckedRadioButtonId();
        int radioId13 = radioGroup13.getCheckedRadioButtonId();
        int radioId14 = radioGroup14.getCheckedRadioButtonId();
        int radioId15 = radioGroup15.getCheckedRadioButtonId();
        int radioId16 = radioGroup16.getCheckedRadioButtonId();
        int radioId17 = radioGroup17.getCheckedRadioButtonId();
        int radioId18 = radioGroup18.getCheckedRadioButtonId();
        int radioId19 = radioGroup19.getCheckedRadioButtonId();
        int radioId20 = radioGroup20.getCheckedRadioButtonId();

        radioButton1 = findViewById(radioId1);
        radioButton2 = findViewById(radioId2);
        radioButton3 = findViewById(radioId3);
        radioButton4 = findViewById(radioId4);
        radioButton5 = findViewById(radioId5);
        radioButton6 = findViewById(radioId6);
        radioButton7 = findViewById(radioId7);
        radioButton8 = findViewById(radioId8);
        radioButton9 = findViewById(radioId9);
        radioButton10 = findViewById(radioId10);
        radioButton11 = findViewById(radioId11);
        radioButton12 = findViewById(radioId12);
        radioButton13 = findViewById(radioId13);
        radioButton14 = findViewById(radioId14);
        radioButton15 = findViewById(radioId15);
        radioButton16 = findViewById(radioId16);
        radioButton17 = findViewById(radioId17);
        radioButton18 = findViewById(radioId18);
        radioButton19 = findViewById(radioId19);
        radioButton20 = findViewById(radioId20);



        if (radioButton1.getText().equals(getResources().getString(R.string.question1a)))
        {

            a1 = a1 + 1;
        } else if (radioButton1.getText().equals(getResources().getString(R.string.question1b))) {

            b1 = b1 + 1;
        }

        if (radioButton2.getText().equals(getResources().getString(R.string.question2a)))
        {
            a2 = a2 + 1;
        } else if (radioButton2.getText().equals(getResources().getString(R.string.question2b))) {
            b2 = b2 + 1;
        }

        if (radioButton3.getText().equals(getResources().getString(R.string.question3a)))
        {
            a3 = a3 + 1;
        } else if (radioButton3.getText().equals(getResources().getString(R.string.question3b))) {
            b3 = b3 + 1;
        }

        if (radioButton4.getText().equals(getResources().getString(R.string.question4a)))
        {
            a4 = a4 + 1;
        } else if (radioButton4.getText().equals(getResources().getString(R.string.question4b))) {
            b4 = b4 + 1;
        }

        if (radioButton5.getText().equals(getResources().getString(R.string.question5a)))
        {

            a1 = a1 + 1;
        } else if (radioButton5.getText().equals(getResources().getString(R.string.question5b))) {
            b1 = b1 + 1;
        }

        if (radioButton6.getText().equals(getResources().getString(R.string.question6a)))
        {
            a2 = a2 + 1;
        } else if (radioButton6.getText().equals(getResources().getString(R.string.question6b))) {
            b2 = b2 + 1;
        }

        if (radioButton7.getText().equals(getResources().getString(R.string.question7a)))
        {
            a3 = a3 + 1;
        } else if (radioButton7.getText().equals(getResources().getString(R.string.question7b))) {
            b3 = b3 + 1;
        }

        if (radioButton8.getText().equals(getResources().getString(R.string.question8a)))
        {
            a4 = a4 + 1;
        } else if (radioButton8.getText().equals(getResources().getString(R.string.question8b))) {
            b4 = b4 + 1;
        }

        if (radioButton9.getText().equals(getResources().getString(R.string.question9a)))
        {

            a1 = a1 + 1;
        } else if (radioButton9.getText().equals(getResources().getString(R.string.question9b))) {

            b1 = b1 + 1;
        }

        if (radioButton10.getText().equals(getResources().getString(R.string.question10a)))
        {
            a2 = a2 + 1;
        } else if (radioButton10.getText().equals(getResources().getString(R.string.question10b))) {
            b2 = b2 + 1;
        }

        if (radioButton11.getText().equals(getResources().getString(R.string.question11a)))
        {
            a3 = a3 + 1;
        } else if (radioButton11.getText().equals(getResources().getString(R.string.question11b))) {
            b3 = b3 + 1;
        }

        if (radioButton12.getText().equals(getResources().getString(R.string.question12a)))
        {
            a4 = a4 + 1;
        } else if (radioButton12.getText().equals(getResources().getString(R.string.question12b))) {
            b4 = b4 + 1;
        }

        if (radioButton13.getText().equals(getResources().getString(R.string.question13a)))
        {

            a1 = a1 + 1;
        } else if (radioButton13.getText().equals(getResources().getString(R.string.question13b))) {

            b1 = b1 + 1;
        }

        if (radioButton14.getText().equals(getResources().getString(R.string.question14a)))
        {
            a2 = a2 + 1;
        } else if (radioButton14.getText().equals(getResources().getString(R.string.question14b))) {
            b2 = b2 + 1;
        }

        if (radioButton15.getText().equals(getResources().getString(R.string.question15a)))
        {
            a3 = a3 + 1;
        } else if (radioButton15.getText().equals(getResources().getString(R.string.question15b))) {
            b3 = b3 + 1;
        }

        if (radioButton16.getText().equals(getResources().getString(R.string.question16a)))
        {
            a4 = a4 + 1;
        } else if (radioButton16.getText().equals(getResources().getString(R.string.question16b))) {
            b4 = b4 + 1;
        }

        if (radioButton17.getText().equals(getResources().getString(R.string.question17a)))
        {

            a1 = a1 + 1;
        } else if (radioButton17.getText().equals(getResources().getString(R.string.question17b))) {

            b1 = b1 + 1;
        }

        if (radioButton18.getText().equals(getResources().getString(R.string.question18a)))
        {
            a2 = a2 + 1;
        } else if (radioButton18.getText().equals(getResources().getString(R.string.question18b))) {
            b2 = b2 + 1;
        }

        if (radioButton19.getText().equals(getResources().getString(R.string.question19a)))
        {
            a3 = a3 + 1;
        } else if (radioButton19.getText().equals(getResources().getString(R.string.question19b))) {
            b3 = b3 + 1;
        }

        if (radioButton20.getText().equals(getResources().getString(R.string.question20a)))
        {
            a4 = a4 + 1;
        } else if (radioButton20.getText().equals(getResources().getString(R.string.question20b))) {
            b4 = b4 + 1;
        }
        Log.d("VALUES", "1st set "+ String.valueOf(a1) + " " + String.valueOf(b1));
        Log.d("VALUES", "Second Set" + String.valueOf(a2) + " " + String.valueOf(b2));
        Log.d("VALUES", "Third Set" + String.valueOf(a3) + " " + String.valueOf(b3));
        Log.d("VALUES", "Fourth Set" + String.valueOf(a4) + " " + String.valueOf(b4));
        String personality = "";
        if (a1 > b1)
        {
            personality = personality + "E";
            if (a2 > b2)
            {
                personality = personality + "S";
                if (a3 > b3)
                {
                    personality = personality + "T";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                } else {
                    personality = personality + "F";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                }
            } else {
                personality = personality + "N";
                if (a3 > b3)
                {
                    personality = personality + "T";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                } else {
                    personality = personality + "F";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                }
            }
        } else {
            personality = personality + "I";
            if (a2 > b2)
            {
                personality = personality + "S";
                if (a3 > b3)
                {
                    personality = personality + "T";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                } else {
                    personality = personality + "F";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                }
            } else {
                personality = personality + "N";
                if (a3 > b3)
                {
                    personality = personality + "T";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                } else {
                    personality = personality + "F";
                    if (a4 > b4)
                    {
                        personality = personality + "J";
                    } else {
                        personality = personality + "P";
                    }
                }
            }
        }
        Log.d("VALUES", personality);
        if (personality.equals("ESTP")) {
            personality = "PERSUADER";
        } else if (personality.equals("ESFP")) {
            personality = "ENTERTAINER";
        } else if (personality.equals("ISTP")) {
            personality = "CRAFTSMAN";
        } else if(personality.equals("ISFP")) {
            personality = "ARTIST";
        } else if (personality.equals("ENTJ")) {
            personality = "CHIEF";
        } else if (personality.equals("ENTP")) {
            personality = "ORIGINATOR";
        } else if (personality.equals("INTJ")) {
            personality = "STRATEGIST";
        } else if (personality.equals("INTP")) {
            personality = "ENGINEER";
        } else if (personality.equals("ENFJ")) {
            personality = "MENTOR";
        } else if (personality.equals("ENFP")) {
            personality = "ADVOCATE";
        } else if (personality.equals("INFJ")) {
            personality = "CONFIDANT";
        } else if (personality.equals("INFP")) {
            personality = "DREAMER";
        } else if (personality.equals("ESTJ")) {
            personality = "OVERSEER";
        } else if (personality.equals("ESFJ")) {
            personality = "SUPPORTER";
        } else if (personality.equals("ISTJ")) {
            personality = "EXAMINER";
        } else if (personality.equals("ISFJ")) {
            personality = "DEFENDER";
        }
        PersonalityTestResult personalityTestResult = new PersonalityTestResult(a1,a2,a3,a4,b1,b2,b3,b4,personality);

        FirebaseDatabase.getInstance().getReference("Personality Test").child(uid).setValue(personalityTestResult).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                startActivity(new Intent(PersonalityTest.this, ProfileActivity.class));
                finish();
            }
        });
    }
}
