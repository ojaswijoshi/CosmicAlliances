package com.tmsimple.cosmicalliances;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to handle the click event of the "Start" button
    public void startGame(View view) {
        // Intent to start the level 1 activity
        Intent intent = new Intent(this, Level1Activity.class);
        startActivity(intent);
    }
}

