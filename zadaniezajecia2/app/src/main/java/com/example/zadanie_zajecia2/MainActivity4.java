package com.example.zadanie_zajecia2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mAuth = FirebaseAuth.getInstance();

        EditText emailEditText = findViewById(R.id.mail);
        EditText passwordEditText = findViewById(R.id.password);
        EditText repeatPasswordEditText = findViewById(R.id.repat_password);
        MaterialButton registerButton = findViewById(R.id.registerbtn);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String repeatPassword = repeatPasswordEditText.getText().toString();

                if (!password.equals(repeatPassword)) {
                    Toast.makeText(MainActivity4.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity4.this, task -> {
                            if (task.isSuccessful()) {
                                // Registration success
                                Toast.makeText(MainActivity4.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent explicitIntent = new Intent(getApplicationContext(), MainActivity2.class);
                                startActivity(explicitIntent);
                            } else {
                                // If registration fails, display a message to the user.
                                Toast.makeText(MainActivity4.this, "Registration failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
