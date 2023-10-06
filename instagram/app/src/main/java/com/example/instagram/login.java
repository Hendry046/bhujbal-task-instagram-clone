package com.example.instagram;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    private static final String USER_PREFERENCES = "user_preferences";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize EditText fields
        usernameEditText = findViewById(R.id.editTextTextPersonName);
        passwordEditText = findViewById(R.id.editTextTextPassword);

        Button loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateCredentials();
            }
        });
    }

    private void validateCredentials() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        boolean isUsernameValid = isValidUsername(username);
        boolean isPasswordValid = isValidPassword(password);

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            // Username or password is empty
            showToast("Username or password cannot be empty");
            saveLoginStatus(false);
        } else if (isUsernameValid && isPasswordValid) {
            // Valid credentials
            saveLoginStatus(true);
            startNextActivity();
        } else {
            // Invalid credentials
            showToast("Invalid Username or Password");
            saveLoginStatus(false);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void saveLoginStatus(boolean isLoggedIn) {
        SharedPreferences preferences = getSharedPreferences(USER_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    private boolean isValidUsername(String username) {
        // Check if the username is a 10-digit number or an email ending with @gmail.com
        return (TextUtils.isDigitsOnly(username) && username.length() == 10) ||
                (Patterns.EMAIL_ADDRESS.matcher(username).matches() && username.endsWith("@gmail.com"));
    }

    private boolean isValidPassword(String password) {
        // Check if the password has at least one uppercase letter, one special character, and a minimum length of 8
        String passwordRegex = "^(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return password.matches(passwordRegex);
    }

    private void startNextActivity() {
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
        finish();
    }
}
