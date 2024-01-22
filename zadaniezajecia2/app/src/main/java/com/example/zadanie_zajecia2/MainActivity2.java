package com.example.zadanie_zajecia2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import database.databaseManager;

public class MainActivity2 extends AppCompatActivity {
    private database.databaseManager databaseManager;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView userEmailTextView = findViewById(R.id.userEmailTextView);
        MaterialButton checkBtn = findViewById(R.id.checkbtn);
        MaterialButton checkBtn2 = findViewById(R.id.checkbtn2);
        MaterialButton checkBtn3 = findViewById(R.id.checkbtn3);
        MaterialButton checkBtn4 = findViewById(R.id.checkbtn4);
        MaterialButton checkBtn5 = findViewById(R.id.checkbtn5);


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
                // Tutaj możesz obsłużyć otrzymane dane, na przykład wyświetlić w TextView
                TextView caloriesTextView = findViewById(R.id.caloriesConsumedTextView);
                caloriesTextView.setText("You consumed " + " of " + (int)calories + " calories today ");
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
    }
}
