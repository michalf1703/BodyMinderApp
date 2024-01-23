package com.example.zadanie_zajecia2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DecimalFormat;

import database.databaseManager;
public class MainActivity2 extends AppCompatActivity {
    private database.databaseManager databaseManager;
    private FirebaseAuth mAuth;
    private TextView infoCalorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView userEmailTextView = findViewById(R.id.userEmailTextView);
        infoCalorie = findViewById(R.id.caloriesConsumedTextView3);
        MaterialButton checkBtn = findViewById(R.id.checkbtn);
        MaterialButton checkBtn2 = findViewById(R.id.checkbtn2);
        MaterialButton checkBtn3 = findViewById(R.id.checkbtn3);
        MaterialButton checkBtn4 = findViewById(R.id.checkbtn4);
        MaterialButton checkBtn5 = findViewById(R.id.checkbtn5);
        MaterialButton checkBtn6 = findViewById(R.id.checkbtn6);

        databaseManager = new databaseManager();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            String userEmail = currentUser.getEmail();
            userEmailTextView.setText(userEmail);
        }

        databaseManager.getCaloriesForUser(new databaseManager.CaloriesCallback() {
            @Override
            public void onCaloriesReceived(double calories) {
                updateCaloriesTextView(calories);
            }
        });

        databaseManager.getEatenCaloriesForUser(new databaseManager.CaloriesCallback() {
            @Override
            public void onCaloriesReceived(double calories) {
                updateEatenCaloriesTextView(calories);
                updateInfoCalorie();
            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(explicitIntent);
            }
        });

        checkBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(explicitIntent);
            }
        });

        checkBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), MainActivityGymExercises.class);
                startActivity(explicitIntent);
            }
        });

        checkBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), MealsPanel.class);
                startActivity(explicitIntent);
            }
        });

        checkBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), AddYourMealActivity.class);
                startActivity(explicitIntent);
            }
        });

        checkBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseManager.resetEatenCaloriesForUser();
            }
        });
    }

    private void updateCaloriesTextView(double calories) {
        TextView caloriesTextView = findViewById(R.id.caloriesConsumedTextView);
        caloriesTextView.setText((int) calories + "");
    }

    private void updateEatenCaloriesTextView(double calories) {
        TextView caloriesTextView = findViewById(R.id.caloriesConsumedTextView2);
        caloriesTextView.setText((int) calories + "");
    }

    private void updateInfoCalorie() {
        TextView eat = findViewById(R.id.caloriesConsumedTextView2); // Zmień textViewId na rzeczywiste ID swojego TextView
        String eat2 = eat.getText().toString();
        int eatenCalories = Integer.parseInt(eat2);
        TextView eat3 = findViewById(R.id.caloriesConsumedTextView);
        String eat4 = eat3.getText().toString();
        int totalCalories = Integer.parseInt(eat4);
        double remainingCalories = totalCalories - eatenCalories;
        if(remainingCalories >= 0) {
            infoCalorie.setText("Remaining calories: " + (int) remainingCalories);
        }
        if(remainingCalories <0){
            infoCalorie.setText("Remaining calories: " + (int) remainingCalories + "\nSo you consumed more calories than you should. \nTo burn it you have to:" +
                    "\n*Run for " + (int)running(remainingCalories) + " minutes" +
                    "\n*Cycle for " + (int)cycling(remainingCalories) + " minutes" +
                    "\n*Walk for " + (int)walking(remainingCalories) + " minutes" +
                    "\nor perform any physical activity that you enjoy. \nRemember that you are doing it for yourself"
            );
        }

    }

    private double running(double calories){
        double time;
        time = (-1) * calories / 10.30;
        return time;
    }

    private double cycling(double calories){
        double time;
        time = (-1) * calories / 7.5;
        return time;
    }

    private double walking(double calories){
        double time;
        time = (-1) * calories / 5.0;
        return time;
    }

    @Override
    protected void onResume() {
        super.onResume();

        databaseManager.addCaloriesListener(new databaseManager.CaloriesCallback() {
            @Override
            public void onCaloriesReceived(double calories) {
                updateCaloriesTextView(calories);
            }
        });

        databaseManager.addEatenCaloriesListener(new databaseManager.CaloriesCallback() {
            @Override
            public void onCaloriesReceived(double calories) {
                updateEatenCaloriesTextView(calories);
                updateInfoCalorie();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        databaseManager.removeCaloriesListener();
        databaseManager.removeEatenCaloriesListener();
    }
}
