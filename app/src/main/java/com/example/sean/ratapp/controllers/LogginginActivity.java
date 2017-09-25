package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.User;

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
    private User _user = new User(); // use default values for username and password

    // hash map of users where the key is the username of the user and the value is the user's
    // account information. Due to this, each username must be unique, but passwords do not.
    // The initial capacity is 10 users. The user account info is stored in the mobile device's
    // cache until a functioning database is available.
    // TODO: move to registration class when available
    private HashMap<String, User> _user_hash_map = new HashMap<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggingin);

        userName = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        logIn = (Button) findViewById(R.id.enter_login);
        error = (Button) findViewById(R.id.error);
        back = (Button) findViewById(R.id.back);
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("user", _user);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_user.logIn(userName.getText().toString(), password.getText().toString())) {
                    finish();
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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(LogginginActivity.this, LoginActivity.class));
            }
        });
    }
}
