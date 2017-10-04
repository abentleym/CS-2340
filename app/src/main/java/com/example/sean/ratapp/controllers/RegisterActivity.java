package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.User;
import com.example.sean.ratapp.model.UserManager;

import java.util.HashMap;

/**
 * Created by jfahe on 9/29/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText _userName;
    private EditText _password;
    private Button _register;
    private Button _error;
    private String _user_name;
    private String _pass_word;
    private CheckBox _admin;
    private Button _back;
    private User _user;
    private String _userName_text;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _register = (Button) findViewById(R.id.registerBtn);
        _error = (Button) findViewById(R.id.badRegistration);
        _back = (Button) findViewById(R.id.cancel);
        _userName = (EditText) findViewById(R.id.userNameText);
        _password = (EditText) findViewById(R.id.passwordText);
        _admin = (CheckBox) findViewById(R.id.admin);

        _register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _user_name = _userName.getText().toString();
                _pass_word = _password.getText().toString();

                if (_admin.isChecked()) {
                    if (UserManager.addAdmin(_user_name, _pass_word)) {
                        finish();
                        startActivity(new Intent(RegisterActivity.this, AdminHomeActivity.class));
                    } else {
                        _error.setVisibility(View.VISIBLE);
                    }
                } else {
                    if (UserManager.addUser(_user_name, _pass_word)) {
                        finish();
                        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                    } else {
                        _error.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        _error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _error.setVisibility(View.INVISIBLE);
            }
        });

        _back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(RegisterActivity.this, StartScreenActivity.class));
            }
        });

    }
}
