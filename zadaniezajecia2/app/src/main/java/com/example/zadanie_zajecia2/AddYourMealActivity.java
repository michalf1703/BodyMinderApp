package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import database.databaseManager;

public class AddYourMealActivity extends AppCompatActivity {
    private database.databaseManager databaseManager;

    private EditText editMealName;
    private EditText editProtein;
    private EditText editCarbs;
    private EditText addCalories;
    private EditText editFat;
    private Button btnCalculate, btnAddCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meal);
        databaseManager = new databaseManager();
        editMealName = findViewById(R.id.editMealName);
        editProtein = findViewById(R.id.editProtein);
        editCarbs = findViewById(R.id.editCarbs);
        editFat = findViewById(R.id.editFat);
        addCalories = findViewById(R.id.editCalories);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnAddCalories = findViewById(R.id.btnAddCalories);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCalories();
            }
        });
        btnAddCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCalories();
            }
        });
    }


    private void calculateCalories() {
        String mealName = editMealName.getText().toString();
        double protein = Double.parseDouble(editProtein.getText().toString());
        double carbs = Double.parseDouble(editCarbs.getText().toString());
        double fat = Double.parseDouble(editFat.getText().toString());
        double calories = (protein * 4) + (carbs * 4) + (fat * 9);

        Toast.makeText(this, "Calories for " + mealName + ": " + calories, Toast.LENGTH_SHORT).show();
        databaseManager.addUserEatenCaloriesData(calories);

    }
    private void addCalories() {
        double calories = Double.parseDouble(addCalories.getText().toString());

        Toast.makeText(this, "You add: " + calories + " calories!", Toast.LENGTH_SHORT).show();
        databaseManager.addUserEatenCaloriesData(calories);

    }

}
