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

    // hash map of users where the key is the username of the user and the value is the user's
    // account information. Due to this, each username must be unique, but passwords do not.
    // The initial capacity is 10 users. The user account info is stored in the mobile device's
    // cache until a functioning database is available.
    // TODO: move to registration class when available
    private HashMap<String, User> _user_hash_map = new HashMap<>(10);

    // Note: you can either create an instance of User from scratch using a constructor, or use the hashmap
    // to try and return an instance. If you do the latter, you may need to change the login
    // validation conditional statements below.
    // Also, see my note about the Extra used below
    private User _user;
    // username and password stored in a String, since they are used in multiple places in the code
    private String _user_name;
    private String _pass_word;

    // TODO: When the registration class is available, add a reference to the instance of the
    // hash map of users into this class

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

        // Note: if this is not really needed, you could delete all instances of _user from this
        // class and use _user_hash_map.get(_user_name).logIn(_user_name, _pass_word)
        // to check if a user is logged in (like I already did below)
        i.putExtra("user", _user);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _user_name = userName.getText().toString();
                _pass_word = password.getText().toString();

                // TODO: Move to registration class when available
                // creates a new User when clicked and stores in hash map
                _user = new User(_user_name, _pass_word);
                _user_hash_map.put(_user_name, _user);

                // if the user has registered and is in the hash map, check login information
                // note: leave as is if you created an instance of user in this class using a
                // constructor. Change if you returned an instance from the hash map.
                if (_user_hash_map.containsKey(_user_name) &&
                        _user_hash_map.get(_user_name).logIn(_user_name, _pass_word)) {
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
