package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.User;
import com.example.sean.ratapp.model.UserManager;

import java.util.HashMap;

/**
 * Created by jfahe on 9/22/2017.
 */

public class LogginginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button logIn;
    private Button error;
    private Button back;

    // username and password stored in a String, since they are used in multiple places in the code
    private String _user_name;
    private String _pass_word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggingin);

        userName = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);

        logIn = (Button) findViewById(R.id.enter_login);
        error = (Button) findViewById(R.id.error);
        back = (Button) findViewById(R.id.back);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _pass_word = password.getText().toString();
                _user_name = userName.getText().toString();

                // if the user has registered and is in the hash map, check login information.
                if (UserManager.loginUser(_user_name, _pass_word)) {
                    if (UserManager.getUser(_user_name).isAdmin()) {
                        finish();
                        startActivity(new Intent(LogginginActivity.this, AdminHomeActivity.class));
                    } else {
                        finish();
                        startActivity(new Intent(LogginginActivity.this, HomeActivity.class));
                    }
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LogginginActivity.this, StartScreenActivity.class));
            }
        });
    }
}
