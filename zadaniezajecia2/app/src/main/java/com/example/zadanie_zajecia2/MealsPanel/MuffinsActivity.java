package com.example.zadanie_zajecia2.MealsPanel;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zadanie_zajecia2.R;
import com.google.android.material.button.MaterialButton;

import database.databaseManager;

public class MuffinsActivity extends AppCompatActivity {
    private database.databaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muffins);
        MaterialButton checkBtn = findViewById(R.id.check1btn);
        databaseManager = new databaseManager();
        int calories = getCalories();


        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("You add calories: " + calories);
                databaseManager.addUserEatenCaloriesData(calories);
            }
        });
    }

    private int getCalories() {
        return 541;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    }

