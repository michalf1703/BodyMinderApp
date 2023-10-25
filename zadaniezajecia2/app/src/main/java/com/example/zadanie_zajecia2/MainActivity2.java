package com.example.zadanie_zajecia2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView hello =(TextView) findViewById(R.id.hello);
        TextView check =(TextView) findViewById(R.id.check);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) MaterialButton loginbtn = (MaterialButton) findViewById(R.id.checkbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(explicitIntent);

            }
        });
    }
}