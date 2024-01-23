package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import database.databaseManager;

public class PancakesActivity extends AppCompatActivity {
    private database.databaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pancakes);
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
        return 860;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    }
