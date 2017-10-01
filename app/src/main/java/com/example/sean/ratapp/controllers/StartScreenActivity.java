package com.example.sean.ratapp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.sean.ratapp.R;

public class StartScreenActivity extends AppCompatActivity {

    Button logInButton;
    Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);

        logInButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent loginattempt = new Intent(StartScreenActivity.this, LogginginActivity.class);
                startActivity(loginattempt);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                finish();
                Intent registerAttempt = new Intent(StartScreenActivity.this, RegisterActivity.class);
                startActivity(registerAttempt);
            }
        });
    }
}
