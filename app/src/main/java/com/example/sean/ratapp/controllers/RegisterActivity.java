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
 * Created by jfahe on 9/29/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText _userName;
    private EditText _password;
    private Button _register;
    private Button _error;
    private String _user_name;
    private String _pass_word;
    private User _user;
    private HashMap<String, User> _user_hash_map = new HashMap<>(10);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        _register = (Button) findViewById(R.id.registerBtn);
        _error = (Button) findViewById(R.id.badRegistration);
        _userName = (EditText) findViewById(R.id.userNameText);
        _password = (EditText) findViewById(R.id.passwordText);

        _register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _user_name = _userName.getText().toString();
                _pass_word = _password.getText().toString();
                if (!_user_hash_map.containsKey(_user_name)) {
                    _user = new User(_user_name, _pass_word);
                    _user_hash_map.put(_user_name, _user);
                    finish();
                    startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                } else {
                    _error.setVisibility(View.VISIBLE);
                }
            }
        });

        _error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _error.setVisibility(View.INVISIBLE);
            }
        });

    }
}
