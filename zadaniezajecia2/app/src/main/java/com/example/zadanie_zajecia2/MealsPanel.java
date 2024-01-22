package com.example.zadanie_zajecia2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MealsPanel extends AppCompatActivity {
    private MaterialButton breakfastButton, lunchButton, snacksButton, dinnerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals_panel_activity);

        breakfastButton = findViewById(R.id.breakfastbtn);
        lunchButton = findViewById(R.id.lunchbtn);
        snacksButton = findViewById(R.id.snacksbtn);
        dinnerButton = findViewById(R.id.dinnerbtn);

        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent explicitIntent = new Intent(getApplicationContext(), BreakfastActivity.class);
                startActivity(explicitIntent);
            }
        });

        dinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent explicitIntent = new Intent(getApplicationContext(), DinnerActivity.class);
                startActivity(explicitIntent);
            }
        });


    }
}
