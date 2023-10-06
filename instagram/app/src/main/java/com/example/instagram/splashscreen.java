package com.example.instagram;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstLaunch() || !isLoggedIn()) {
                    // If it's the first launch or not logged in, navigate to the login activity
                    Intent intent = new Intent(splashscreen.this, login.class);
                    startActivity(intent);
                } else {
                    // If logged in, navigate to the home activity
                    Intent intent = new Intent(splashscreen.this, home.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 3000);
    }

    private boolean isFirstLaunch() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        boolean isFirstLaunch = preferences.getBoolean("isFirstLaunch", true);

        if (isFirstLaunch) {
            // Set the flag to false to indicate that it's not the first launch anymore
            preferences.edit().putBoolean("isFirstLaunch", false).apply();
        }

        return isFirstLaunch;
    }

    private boolean isLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);
        return preferences.getBoolean("isLoggedIn", false);
    }
}
