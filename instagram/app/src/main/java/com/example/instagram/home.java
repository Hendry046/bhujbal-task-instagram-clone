package com.example.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Sample data
        int[] imageIds = {R.drawable.img0, R.drawable.img9, R.drawable.img8, R.drawable.img7};

        GridView gridView = findViewById(R.id.gridView);
        ImageAdapter adapter = new ImageAdapter(this, imageIds);
        gridView.setAdapter(adapter);
    }

    //"Log Out" button is clicked
    public void logout(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
        finish();
    }
}
