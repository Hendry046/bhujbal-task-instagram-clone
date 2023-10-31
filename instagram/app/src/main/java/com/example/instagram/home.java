package com.example.instagram;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserProfileAdapter adapter;
    private TextView followingCountTextView;
    private List<UserProfile> userProfiles;
    private int followingCount = 0; // Initialize the following count

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize your user profiles list
        userProfiles = new ArrayList<>();
        // Add user profiles (modify this part as needed)
        userProfiles.add(new UserProfile("1", "Ethan", R.drawable.i1));
        userProfiles.add(new UserProfile("2","Liam", R.drawable.i2));
        userProfiles.add(new UserProfile("3","Noah", R.drawable.i3));
        userProfiles.add(new UserProfile("4","Aiden", R.drawable.i4));
        userProfiles.add(new UserProfile("5","Lucas", R.drawable.i5));
        userProfiles.add(new UserProfile("6","Mason", R.drawable.i6));
        userProfiles.add(new UserProfile("7","Logan", R.drawable.i7));
        userProfiles.add(new UserProfile("8","Caleb", R.drawable.i8));
        userProfiles.add(new UserProfile("9","Samuel", R.drawable.i9));
        userProfiles.add(new UserProfile("10","Benjamin", R.drawable.i10));
        userProfiles.add(new UserProfile("11","Simon", R.drawable.i11));
        userProfiles.add(new UserProfile("12","Elijah", R.drawable.i12));
        userProfiles.add(new UserProfile("13","William", R.drawable.i13));
        userProfiles.add(new UserProfile("14","James", R.drawable.i14));
        userProfiles.add(new UserProfile("15","Michael", R.drawable.i15));
        userProfiles.add(new UserProfile("16","Daniel", R.drawable.i16));
        userProfiles.add(new UserProfile("17","Andrew", R.drawable.i17));
        userProfiles.add(new UserProfile("18","Oliver", R.drawable.i18));
        userProfiles.add(new UserProfile("19","Matthew", R.drawable.i19));
        userProfiles.add(new UserProfile("20","Jackson", R.drawable.i20));
        userProfiles.add(new UserProfile("21","Joseph", R.drawable.i21));
        userProfiles.add(new UserProfile("22","David", R.drawable.i22));
        userProfiles.add(new UserProfile("23","Christopher", R.drawable.i23));
        userProfiles.add(new UserProfile("24","Nicholas", R.drawable.i24));
        userProfiles.add(new UserProfile("25","Anthony", R.drawable.i25));
        userProfiles.add(new UserProfile("26","Jonathan", R.drawable.img9));
        userProfiles.add(new UserProfile("27","Alexander", R.drawable.img9));
        userProfiles.add(new UserProfile("28","Noah", R.drawable.img9));
        userProfiles.add(new UserProfile("29","Owen", R.drawable.img9));
        userProfiles.add(new UserProfile("30","Thomas", R.drawable.img9));
        userProfiles.add(new UserProfile("31","Charles", R.drawable.img9));
        userProfiles.add(new UserProfile("32","Nathan", R.drawable.img9));
        userProfiles.add(new UserProfile("33","Jack", R.drawable.img9));
        userProfiles.add(new UserProfile("34","Ryan", R.drawable.img9));
        userProfiles.add(new UserProfile("35","William", R.drawable.img9));
        userProfiles.add(new UserProfile("36","Gabriel", R.drawable.img9));
        userProfiles.add(new UserProfile("37","Isaac", R.drawable.img9));
        userProfiles.add(new UserProfile("38","John", R.drawable.img9));
        userProfiles.add(new UserProfile("39","Brandon", R.drawable.img9));
        userProfiles.add(new UserProfile("40","Luke", R.drawable.img9));
        userProfiles.add(new UserProfile("41","Robert", R.drawable.img9));
        userProfiles.add(new UserProfile("42","Adam", R.drawable.img9));
        userProfiles.add(new UserProfile("43","Daniel", R.drawable.img9));
        userProfiles.add(new UserProfile("44","Zachary", R.drawable.img9));
        userProfiles.add(new UserProfile("45","Hunter", R.drawable.img9));
        userProfiles.add(new UserProfile("46","Justin", R.drawable.img9));
        userProfiles.add(new UserProfile("47","Jayden", R.drawable.img9));
        userProfiles.add(new UserProfile("48","Evan", R.drawable.img9));
        userProfiles.add(new UserProfile("49","Cameron", R.drawable.img9));
        userProfiles.add(new UserProfile("50","Dylan", R.drawable.img9));


        // Find and initialize the followingCountTextView
        followingCountTextView = findViewById(R.id.followingCountTextView);

        // Initialize and update the following count
        followingCountTextView = findViewById(R.id.followingCountTextView);
        followingCount = SharedPreferencesUtil.getFollowingCount(this);
        followingCountTextView.setText(String.valueOf(followingCount) + " Following");

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load and apply the follow status for each user profile
        for (UserProfile userProfile : userProfiles) {
            boolean followStatus = SharedPreferencesUtil.getFollowStatus(this, userProfile.getUserId());
            userProfile.setFollowStatus(followStatus);
        }

        // Create the adapter and pass the followingCountTextView
        adapter = new UserProfileAdapter(this, userProfiles, followingCountTextView);
        recyclerView.setAdapter(adapter);
    }

    // "Log Out" button is clicked
    public void logout(View view) {
        // Clear the login status
        saveLoginStatus(false);

        Intent intent = new Intent(this, login.class);
        startActivity(intent);
        finish();
    }

    // Update and display the following count
    private void updateFollowingCount() {
        followingCount = calculateFollowingCount();
        followingCountTextView.setText(String.valueOf(followingCount) + " Following");

        // Save the following count in SharedPreferences
        SharedPreferencesUtil.saveFollowingCount(this, followingCount);
    }

    // Implement your logic to calculate the following count
    private int calculateFollowingCount() {
        int count = 0;
        for (UserProfile userProfile : userProfiles) {
            if (userProfile.isFollowing()) {
                count++;
            }
        }
        return count;
    }

    private void saveLoginStatus(boolean isLoggedIn) {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }
}
