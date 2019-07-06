package com.example.capstoneshs;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentViewPersonality extends Fragment {
    View view;
    private RadarChart chart;

    private static final float MAX = 5 , MIN = 0f;
    private static  final int NB_QUALITIES = 5;

    private FloatingActionButton btnToggle;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser mUser = mAuth.getCurrentUser();

    private String userId;
    public FragmentViewPersonality(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.personality_view_profile,container,false);

        chart = view.findViewById(R.id.personalityChart);
        btnToggle = view.findViewById(R.id.toggleValues);
        btnToggle.hide();
        chart.setBackgroundColor(Color.WHITE);
        chart.getDescription().setEnabled(false);

        chart.setWebColor(Color.BLACK);
        chart.setWebLineWidth(1f);
        chart.setWebColorInner(Color.BLACK);
        chart.setWebLineWidthInner(1.5f);
        chart.setWebAlpha(100);
        


        chart.animateXY(1400,1400, Easing.EasingOption.EaseInQuad, Easing.EasingOption.EaseInQuad);
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(9f);
        xAxis.setXOffset(9);
        xAxis.setYOffset(9);
        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] qualities = new String[] {"Extraversion", "Introversion", "Thinking", "Feeling", "Sensing", "Intuition", "Judging", "Perceiving"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return qualities[(int) value % qualities.length];
            }
        });

        YAxis yAxis = chart.getYAxis();
        yAxis.setLabelCount(NB_QUALITIES, true);
        yAxis.setTextSize(12f);
        yAxis.setAxisMinimum(MIN);
        yAxis.setAxisMaximum(MAX);
        yAxis.setDrawLabels(false);

        Legend l = chart.getLegend();
        l.setTextSize(15f);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setXEntrySpace(5f);
        l.setYEntrySpace(8f);
        l.setTextColor(Color.rgb(255,69,0));

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (IDataSet<?> set : chart.getData().getDataSets()) {
                    set.setDrawValues(!set.isDrawValuesEnabled());
                }
                chart.invalidate();
            }
        });
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            userId = bundle.getString("ID_NEEDED");
            setData();
        }
        return view;
    }

    private void setData() {
        Toast.makeText(getActivity(), userId, Toast.LENGTH_SHORT).show();
        final ArrayList<RadarEntry> employee1 = new ArrayList<>();
        final ArrayList<IRadarDataSet> sets = new ArrayList<>();
        if (isAdded()) {
            FirebaseDatabase.getInstance().getReference("Personality Test").child(userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot childSnapShot) {
                    employee1.clear();
                    sets.clear();
                    String check = childSnapShot.child("personalitytype").getValue(String.class);
                    if (check != null)
                    {
                        chart.setVisibility(View.VISIBLE);
                        employee1.add(new RadarEntry(childSnapShot.child("a1").getValue(int.class)));
                        employee1.add(new RadarEntry(childSnapShot.child("b1").getValue(int.class)));
                        employee1.add(new RadarEntry(childSnapShot.child("a2").getValue(int.class)));
                        employee1.add(new RadarEntry(childSnapShot.child("b2").getValue(int.class)));
                        employee1.add(new RadarEntry(childSnapShot.child("a3").getValue(int.class)));
                        employee1.add(new RadarEntry(childSnapShot.child("b3").getValue(int.class)));
                        employee1.add(new RadarEntry(childSnapShot.child("a4").getValue(int.class)));
                        employee1.add(new RadarEntry(childSnapShot.child("b4").getValue(int.class)));

                        RadarDataSet set1 = new RadarDataSet(employee1, childSnapShot.child("personalitytype").getValue(String.class));
                        set1.setColor(Color.rgb(51,105,30));
                        set1.setFillColor(Color.GREEN);
                        set1.setDrawFilled(true);
                        set1.setFillAlpha(90);
                        set1.setLineWidth(1f);
                        set1.setDrawHighlightIndicators(true);
                        set1.setDrawHighlightCircleEnabled(true);


                        sets.add(set1);

                        RadarData data = new RadarData(sets);
                        data.setValueTextSize(12f);
                        data.setDrawValues(false);
                        data.setValueTextColor(Color.rgb(255, 69, 0));

                        chart.setData(data);
                        chart.invalidate();
                        btnToggle.show();
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
//        employee1.add(new RadarEntry(3));
//        employee1.add(new RadarEntry(2));
//        employee1.add(new RadarEntry(5));
//        employee1.add(new RadarEntry(1));
//        employee1.add(new RadarEntry(5));
//        employee1.add(new RadarEntry(2));
//        employee1.add(new RadarEntry(1));
//        employee1.add(new RadarEntry(4));
            // Generate random values for the Personality
//        for (int i = 0; i < NB_QUALITIES; i++) {
////            float val1 = (int) (Math.random() * MAX) + MIN;
////            employee1.add(new RadarEntry(val1));
//
//            float val2 = (int) (Math.random()* MAX) + MIN;
//            employee2.add(new RadarEntry(val2));
//        }

        }
    }


}
