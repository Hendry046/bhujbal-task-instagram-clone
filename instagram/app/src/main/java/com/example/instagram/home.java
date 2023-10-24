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
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));
        userProfiles.add(new UserProfile("Raj", R.drawable.img9));


        // Find and initialize the followingCountTextView
        followingCountTextView = findViewById(R.id.followingCountTextView);

        recyclerView = findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create the adapter and pass the followingCountTextView
        adapter = new UserProfileAdapter(this, userProfiles, followingCountTextView);
        recyclerView.setAdapter(adapter);

        // Initialize and update the following count
        updateFollowingCount();
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
        followingCountTextView.setText(String.valueOf(followingCount));
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
