package com.example.zadanie_zajecia2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SnacksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snacks);
        MaterialButton checkBtn = findViewById(R.id.check1btn);
        MaterialButton checkBtn2 = findViewById(R.id.check2btn);
        MaterialButton checkBtn3 = findViewById(R.id.check3btn);


        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent explicitIntent = new Intent(getApplicationContext(), RollsActivity.class);
                startActivity(explicitIntent);
            }
        });

        checkBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent explicitIntent = new Intent(getApplicationContext(), FriesActivity.class);
                startActivity(explicitIntent);
            }
        });

        checkBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent explicitIntent = new Intent(getApplicationContext(), MuffinsActivity.class);
                startActivity(explicitIntent);
            }
        });
    }
}
