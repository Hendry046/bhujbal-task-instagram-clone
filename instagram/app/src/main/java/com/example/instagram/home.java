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
        userProfiles.add(new UserProfile("Ethan", R.drawable.i1));
        userProfiles.add(new UserProfile("Liam", R.drawable.i2));
        userProfiles.add(new UserProfile("Noah", R.drawable.i3));
        userProfiles.add(new UserProfile("Aiden", R.drawable.i4));
        userProfiles.add(new UserProfile("Lucas", R.drawable.i5));
        userProfiles.add(new UserProfile("Mason", R.drawable.i6));
        userProfiles.add(new UserProfile("Logan", R.drawable.i7));
        userProfiles.add(new UserProfile("Caleb", R.drawable.i8));
        userProfiles.add(new UserProfile("Samuel", R.drawable.i9));
        userProfiles.add(new UserProfile("Benjamin", R.drawable.i10));
        userProfiles.add(new UserProfile("Simon", R.drawable.i11));
        userProfiles.add(new UserProfile("Elijah", R.drawable.i12));
        userProfiles.add(new UserProfile("William", R.drawable.i13));
        userProfiles.add(new UserProfile("James", R.drawable.i14));
        userProfiles.add(new UserProfile("Michael", R.drawable.i15));
        userProfiles.add(new UserProfile("Daniel", R.drawable.i16));
        userProfiles.add(new UserProfile("Andrew", R.drawable.i17));
        userProfiles.add(new UserProfile("Oliver", R.drawable.i18));
        userProfiles.add(new UserProfile("Matthew", R.drawable.i19));
        userProfiles.add(new UserProfile("Jackson", R.drawable.i20));
        userProfiles.add(new UserProfile("Joseph", R.drawable.i21));
        userProfiles.add(new UserProfile("David", R.drawable.i22));
        userProfiles.add(new UserProfile("Christopher", R.drawable.i23));
        userProfiles.add(new UserProfile("Nicholas", R.drawable.i24));
        userProfiles.add(new UserProfile("Anthony", R.drawable.i25));
        userProfiles.add(new UserProfile("Jonathan", R.drawable.img9));
        userProfiles.add(new UserProfile("Alexander", R.drawable.img9));
        userProfiles.add(new UserProfile("Noah", R.drawable.img9));
        userProfiles.add(new UserProfile("Owen", R.drawable.img9));
        userProfiles.add(new UserProfile("Thomas", R.drawable.img9));
        userProfiles.add(new UserProfile("Charles", R.drawable.img9));
        userProfiles.add(new UserProfile("Nathan", R.drawable.img9));
        userProfiles.add(new UserProfile("Jack", R.drawable.img9));
        userProfiles.add(new UserProfile("Ryan", R.drawable.img9));
        userProfiles.add(new UserProfile("William", R.drawable.img9));
        userProfiles.add(new UserProfile("Gabriel", R.drawable.img9));
        userProfiles.add(new UserProfile("Isaac", R.drawable.img9));
        userProfiles.add(new UserProfile("John", R.drawable.img9));
        userProfiles.add(new UserProfile("Brandon", R.drawable.img9));
        userProfiles.add(new UserProfile("Luke", R.drawable.img9));
        userProfiles.add(new UserProfile("Robert", R.drawable.img9));
        userProfiles.add(new UserProfile("Adam", R.drawable.img9));
        userProfiles.add(new UserProfile("Daniel", R.drawable.img9));
        userProfiles.add(new UserProfile("Zachary", R.drawable.img9));
        userProfiles.add(new UserProfile("Hunter", R.drawable.img9));
        userProfiles.add(new UserProfile("Justin", R.drawable.img9));
        userProfiles.add(new UserProfile("Jayden", R.drawable.img9));
        userProfiles.add(new UserProfile("Evan", R.drawable.img9));
        userProfiles.add(new UserProfile("Cameron", R.drawable.img9));
        userProfiles.add(new UserProfile("Dylan", R.drawable.img9));


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
