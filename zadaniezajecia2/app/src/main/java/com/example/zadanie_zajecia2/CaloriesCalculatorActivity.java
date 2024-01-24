package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import database.databaseManager;

public class CaloriesCalculatorActivity extends AppCompatActivity {

    private Spinner weightGoalSpinner;
    private CheckBox checkBox1, checkBox2;
    private EditText weightEditText, heightEditText;
    private NumberPicker agePicker;
    private Spinner activityLevelSpinner;
    private Button calculateButton;

    private databaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        agePicker = findViewById(R.id.agePicker);
        activityLevelSpinner = findViewById(R.id.activityLevelSpinner);
        calculateButton = findViewById(R.id.calculateButton);
        weightGoalSpinner = findViewById(R.id.weightGoalSpinner);
        agePicker.setMinValue(1);
        agePicker.setMaxValue(100);
        agePicker.setValue(18);

        databaseManager = new databaseManager();

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCaloricNeeds();
            }
        });
    }

    private void calculateCaloricNeeds() {
        boolean isMale = checkBox1.isChecked();
        boolean isFemale = checkBox2.isChecked();
        int age = agePicker.getValue();
        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString());
        double activityFactor = getActivityFactor();
        double bmr;
        if (isMale) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        double totalCalories = bmr * activityFactor;
        String selectedWeightGoal = weightGoalSpinner.getSelectedItem().toString();
        switch (selectedWeightGoal) {
            case "Lose Weight":
                totalCalories -= 400;
                break;
            case "Maintain Weight":
                break;
            case "Gain Weight":
                totalCalories += 400;
                break;
            default:
                break;
        }

        String resultMessage = "Total Calories: " + totalCalories;
        Toast.makeText(this, resultMessage, Toast.LENGTH_SHORT).show();
        databaseManager.addUserCaloriesData(totalCalories);
    }

    private double getActivityFactor() {
        String selectedActivityLevel = activityLevelSpinner.getSelectedItem().toString();

        double activityFactor;
        switch (selectedActivityLevel) {
            case "Lack of activity":
                activityFactor = 1.2;
                break;
            case "Light activity":
                activityFactor = 1.375;
                break;
            case "Average activity":
                activityFactor = 1.55;
                break;
            case "Large activity":
                activityFactor = 1.725;
                break;
            default:
                activityFactor = 1.2;
                break;
        }

        return activityFactor;
    }
}
