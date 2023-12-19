package com.example.zadanie_zajecia2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity5 extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        mAuth = FirebaseAuth.getInstance();

        EditText emailEditText = findViewById(R.id.mail);
        MaterialButton sendMailButton = findViewById(R.id.sendMail);

        sendMailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();

                mAuth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                // Password reset email sent successfully
                                Toast.makeText(MainActivity5.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                                // You can add additional logic here if needed
                            } else {
                                // If sending fails, display a message to the user.
                                Toast.makeText(MainActivity5.this, "Failed to send password reset email: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
