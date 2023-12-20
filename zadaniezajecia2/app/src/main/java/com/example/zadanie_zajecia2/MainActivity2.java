package com.example.zadanie_zajecia2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView userEmailTextView = findViewById(R.id.userEmailTextView);
        MaterialButton checkBtn = findViewById(R.id.checkbtn);
        MaterialButton checkBtn2 = findViewById(R.id.checkbtn2);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            String userEmail = currentUser.getEmail();
            userEmailTextView.setText(userEmail);
        }

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
    }
}
