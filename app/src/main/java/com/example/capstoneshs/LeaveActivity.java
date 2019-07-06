package com.example.capstoneshs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;

public class LeaveActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {
    String othersVal;
    String value;
    String distinguisher;
    Button btn_date_start,btn_date_return;
    EditText otherReason,address_editText, reason_edit;
    private String userId;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser mUser = mAuth.getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Spinner spinnerLeave = findViewById(R.id.nature_of_leave_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.nature_of_leave_value,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLeave.setAdapter(adapter);
        spinnerLeave.setOnItemSelectedListener(this);

        address_editText = findViewById(R.id.address_while_onleave);
        reason_edit = findViewById(R.id.reason);
        Button btn_submit = findViewById(R.id.submit_button);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value.equalsIgnoreCase("Others"))
                {

                    String start_date = btn_date_start.getText().toString();
                    String end_date = btn_date_return.getText().toString();
                    String reason_of_leave = otherReason.getText().toString();
                    String address = address_editText.getText().toString();
                    String reason = reason_edit.getText().toString();
                    Log.d("CheckIfNull",start_date + end_date + reason_of_leave + address);
                    LeaveClass leaveClass = new LeaveClass(start_date,end_date,reason_of_leave,address,userId,reason,"pending");
                    InsertRequest(leaveClass);
                } else {

                    String start_date = btn_date_start.getText().toString();
                    String end_date = btn_date_return.getText().toString();
                    String address = address_editText.getText().toString();
                    String reason = reason_edit.getText().toString();
                    LeaveClass leaveClass = new LeaveClass(start_date,end_date,value,address,userId,reason,"pending");
                    InsertRequest(leaveClass);
                }
            }
        });

        btn_date_start = findViewById(R.id.start_date);
        btn_date_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distinguisher = "0";
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        btn_date_return = findViewById(R.id.return_date);
        btn_date_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distinguisher = "1";
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()  == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        if (distinguisher.equals("0")) {
            Button btn_start = findViewById(R.id.start_date);
            String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
            btn_start.setText(currentDate);
        } else if (distinguisher.equals("1")) {
            Button btn_return = findViewById(R.id.return_date);
            String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
            btn_return.setText(currentDate);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        value = parent.getItemAtPosition(position).toString();

        if (value.equalsIgnoreCase("Others"))
        {

            otherReason = findViewById(R.id.other_type_of_leave);
            otherReason.setEnabled(true);
            otherReason.setHintTextColor(getResources().getColor(R.color.colorAccent));
            otherReason.setFocusableInTouchMode(true);

        } else {
            EditText editText = findViewById(R.id.other_type_of_leave);
            editText.setHintTextColor(getResources().getColor(R.color.gray));
            editText.setEnabled(false);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void InsertRequest(LeaveClass leaveClass){
        Toast.makeText(this, leaveClass.getAddress(), Toast.LENGTH_SHORT).show();
        FirebaseDatabase.getInstance().getReference("Leave Request").push().setValue(leaveClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mUser != null)
        {
            userId = mUser.getUid();
        } else {
            Intent intent = new Intent(LeaveActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
