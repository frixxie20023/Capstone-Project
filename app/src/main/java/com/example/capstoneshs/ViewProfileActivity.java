package com.example.capstoneshs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

public class ViewProfileActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    private String userId;
    private TextView fullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
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
        setUpProfile(userId);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tabLayout = findViewById(R.id.tabLayout);
        appBarLayout = findViewById(R.id.appBar);
        viewPager = findViewById(R.id.viewPager);
        fullName = findViewById(R.id.fullName);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        FragmentViewInformation fragmentinfo = new FragmentViewInformation();
        FragmentViewPersonality fragmentpersonality = new FragmentViewPersonality();
        Bundle bundle = new Bundle();
        bundle.putString("ID_NEEDED", userId);
        fragmentinfo.setArguments(bundle);

        Bundle bundle2 = new Bundle();
        bundle2.putString("ID_NEEDED", userId);
        fragmentpersonality.setArguments(bundle2);

        adapter.AddFragment(fragmentinfo,"Information");
        adapter.AddFragment(fragmentpersonality,"Personality");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()  == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (user != null) {

        } else {
            Intent intent = new Intent(ViewProfileActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void setUpProfile(String userId) {

        FirebaseDatabase.getInstance().getReference("Teachers").child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fullName.setText(dataSnapshot.child("First_Name").getValue(String.class) + " " + dataSnapshot.child("Last_Name").getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
