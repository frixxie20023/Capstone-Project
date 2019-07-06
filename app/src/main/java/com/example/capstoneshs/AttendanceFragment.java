package com.example.capstoneshs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AttendanceFragment extends Fragment {
    public static String codeValue = null;
    public static boolean isPerformedScan = false;
    TextView dateView;
    private Button time_in , time_out,time_in_pm , time_out_pm;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser mUser = mAuth.getCurrentUser();
    private String userId;
    private String qrValue;
    public AttendanceFragment (){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attendance_fragment,container,false);
        dateView = view.findViewById(R.id.dateFetch);
        time_in = view.findViewById(R.id.time_in);
        time_out = view.findViewById(R.id.time_out);
        time_in_pm = view.findViewById(R.id.time_in_pm);
        time_out_pm = view.findViewById(R.id.time_out_pm);
        assert getArguments() != null;

        qrValue = getArguments().getString("QRVALUE");

        time_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
                SimpleDateFormat time = new SimpleDateFormat("h:mm a");
                String formattedDate = df.format(c.getTime());
                String formattedTime = time.format(c);
                    AttendanceClass attendanceClass = new AttendanceClass();
                    attendanceClass.setTime_out_pm(formattedTime);
                    attendanceClass.setUser_id(userId);
                    FirebaseDatabase.getInstance().getReference("Attendance").child(formattedDate).child(userId).child("time_out_am").setValue(formattedTime);
                    FirebaseDatabase.getInstance().getReference("AttendanceQR").child("code").setValue(formattedTime);
            }
        });

        time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
                SimpleDateFormat time = new SimpleDateFormat("h:mm a");
                String formattedDate = df.format(c.getTime());
                String formattedTime = time.format(c);
                AttendanceClass attendanceClass = new AttendanceClass();
                attendanceClass.setTime_out_pm(formattedTime);
                attendanceClass.setUser_id(userId);
                FirebaseDatabase.getInstance().getReference("Attendance").child(formattedDate).child(userId).child("time_in_am").setValue(formattedTime);
                FirebaseDatabase.getInstance().getReference("AttendanceQR").child("code").setValue(formattedTime);
            }
        });
        time_in_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
                SimpleDateFormat time = new SimpleDateFormat("h:mm a");
                String formattedDate = df.format(c.getTime());
                String formattedTime = time.format(c);
                //pm time in and out
                dateView.setText(" Time out Pm");
                AttendanceClass attendanceClass = new AttendanceClass();
                attendanceClass.setTime_out_pm(formattedTime);
                attendanceClass.setUser_id(userId);
                FirebaseDatabase.getInstance().getReference("Attendance").child(formattedDate).child(userId).child("time_in_pm").setValue(formattedTime);
                FirebaseDatabase.getInstance().getReference("AttendanceQR").child("code").setValue(formattedTime);
            }
        });
        time_out_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
                SimpleDateFormat time = new SimpleDateFormat("h:mm a");
                String formattedDate = df.format(c.getTime());
                String formattedTime = time.format(c);
                AttendanceClass attendanceClass = new AttendanceClass();
                attendanceClass.setTime_out_pm(formattedTime);
                attendanceClass.setUser_id(userId);
                FirebaseDatabase.getInstance().getReference("Attendance").child(formattedDate).child(userId).child("time_out_pm").setValue(formattedTime);
                FirebaseDatabase.getInstance().getReference("AttendanceQR").child("code").setValue(formattedTime);
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FRAGMENTRIG", "onCreate:");
    }

    private void FetchData(String userId){

        FirebaseDatabase.getInstance().getReference("AttendanceQR").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("code").getValue(String.class).equals(qrValue))
                {
                    //InitializeAttendance();

                    time_in.setVisibility(View.VISIBLE);
                    time_out.setVisibility(View.VISIBLE);
                    time_in_pm.setVisibility(View.VISIBLE);
                    time_out_pm.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(getActivity(), "Wrong Qr", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void InitializeAttendance(){
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-M-yyyy");
        SimpleDateFormat time = new SimpleDateFormat("h:mm a");
        String formattedDate = df.format(c.getTime());
        String formattedTime = time.format(c);
        String newTime = "1:01 pm";
        if (formattedTime.compareTo(newTime) >= 0)
        {
            //pm time in and out
            dateView.setText("LATER");
            AttendanceClass attendanceClass = new AttendanceClass();
            attendanceClass.setTime_out_pm(formattedTime);
            attendanceClass.setUser_id(userId);
            FirebaseDatabase.getInstance().getReference("Attendance").child(formattedDate).child("time_in_pm").setValue(formattedTime);
        } else {
            dateView.setText("Earlier");
            // am time in and out

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mUser != null)
        {
            userId = mUser.getUid();
            FetchData(userId);
        } else {
            Intent i = new Intent(getActivity(),LoginActivity.class);
            startActivity(i);
        }
    }


}
