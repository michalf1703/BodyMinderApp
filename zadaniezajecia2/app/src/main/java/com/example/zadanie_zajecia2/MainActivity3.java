package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity3 extends AppCompatActivity {

    private CheckBox checkBox1, checkBox2;
    private EditText weightEditText, heightEditText;
    private NumberPicker agePicker;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        agePicker = findViewById(R.id.agePicker);
        calculateButton = findViewById(R.id.calculateButton);
        agePicker.setMinValue(1);
        agePicker.setMaxValue(100);
        agePicker.setValue(18);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        boolean isMale = checkBox1.isChecked();
        boolean isFemale = checkBox2.isChecked();
        int age = agePicker.getValue();
        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString());
        double bmi = calculateBMIValue(weight, height);
        String bmiCategory = getBMICategory(bmi);
        String resultMessage = "BMI: " + bmi + "\nKategoria: " + bmiCategory;
        Toast.makeText(this, resultMessage, Toast.LENGTH_SHORT).show();

    }

    private double calculateBMIValue(double weight, double heightInCm) {
        double heightInMeters = heightInCm / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Desired body weight";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Overweight";
        } else if (bmi >= 30 && bmi <= 34.9) {
            return "Grade I obesity";
        } else if (bmi >= 35 && bmi <= 39.9) {
            return "Grade II obesity";
        } else {
            return "Grade III obesity";
        }

    }
}