package com.example.zadanie_zajecia2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivityGymExercises extends AppCompatActivity {
    private MaterialButton armsButton, chestButton, bodyButton, backButton, legsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        armsButton = findViewById(R.id.armsbtn);
        chestButton = findViewById(R.id.chestbtn);
        bodyButton = findViewById(R.id.bodybtn);
        backButton = findViewById(R.id.backbtn);
        legsButton = findViewById(R.id.legsbtn);

        armsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), ArmsActivity.class);
                startActivity(explicitIntent);
            }
        });

        chestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.chest);
            }
        });

        bodyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.body);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.back);
            }
        });

        legsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.legs);
            }
        });

    }
}
