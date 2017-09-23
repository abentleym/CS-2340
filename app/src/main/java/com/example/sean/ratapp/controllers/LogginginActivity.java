package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sean.ratapp.R;

/**
 * Created by jfahe on 9/22/2017.
 */

public class LogginginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button logIn;
    private Button error;
    private int x = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggingin);

        userName = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        logIn = (Button) findViewById(R.id.enter_login);
        error = (Button) findViewById(R.id.error);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (x == 10) {
                    startActivity(new Intent(LogginginActivity.this, HomeActivity.class));
                } else {
                    error.setVisibility(View.VISIBLE);
                }
            }
        });

        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                error.setVisibility(View.INVISIBLE);
            }
        });
    }
}
