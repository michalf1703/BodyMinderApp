package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zadanie_zajecia2.R;

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
        // Pobierz wartości wprowadzone przez użytkownika
        boolean isMale = checkBox1.isChecked();
        boolean isFemale = checkBox2.isChecked();
        int age = agePicker.getValue();
        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString());

        // Wykonaj obliczenia BMI
        double bmi = calculateBMIValue(weight, height);
        // Określ stopień BMI
        String bmiCategory = getBMICategory(bmi);

        // Wyświetl wynik
        String resultMessage = "BMI: " + bmi + "\nKategoria: " + bmiCategory;
        Toast.makeText(this, resultMessage, Toast.LENGTH_SHORT).show();

    }

    private double calculateBMIValue(double weight, double heightInCm) {
        // Przekształć wzrost z centymetrów na metry
        double heightInMeters = heightInCm / 100.0;

        // Oblicz BMI
        // Wzór BMI: BMI = masa ciała (kg) / (wzrost (m) * wzrost (m))
        return weight / (heightInMeters * heightInMeters);
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Niedowaga";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Pożądana masa ciała";
        } else if (bmi >= 25 && bmi <= 29.9) {
            return "Nadwaga";
        } else if (bmi >= 30 && bmi <= 34.9) {
            return "Otyłość I stopnia";
        } else if (bmi >= 35 && bmi <= 39.9) {
            return "Otyłość II stopnia";
        } else {
            return "Otyłość III stopnia";
        }

    }
}