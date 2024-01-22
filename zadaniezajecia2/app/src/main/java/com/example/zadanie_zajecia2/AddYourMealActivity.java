package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddYourMealActivity extends AppCompatActivity {

    private EditText editMealName;
    private EditText editProtein;
    private EditText editCarbs;
    private EditText editFat;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meal);

        editMealName = findViewById(R.id.editMealName);
        editProtein = findViewById(R.id.editProtein);
        editCarbs = findViewById(R.id.editCarbs);
        editFat = findViewById(R.id.editFat);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCalories();
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

    }

}
