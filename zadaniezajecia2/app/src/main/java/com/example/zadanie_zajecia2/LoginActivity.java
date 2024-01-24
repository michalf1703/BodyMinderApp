package com.example.zadanie_zajecia2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        MaterialButton loginbtn = findViewById(R.id.loginbtn);
        MaterialButton registerbtn = findViewById(R.id.registerbtn);
        MaterialButton restartbnt = findViewById(R.id.restartbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = username.getText().toString();
                String userPassword = password.getText().toString();

                mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                        .addOnCompleteListener(LoginActivity.this, task -> {
                            if (task.isSuccessful()) {
                                // Sign in success
                                Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                Intent explicitIntent = new Intent(getApplicationContext(), GeneralPanelActivity.class);
                                startActivity(explicitIntent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LoginActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(explicitIntent);
            }
        });

        restartbnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explicitIntent = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                startActivity(explicitIntent);
            }
        });
    }
}
