package com.example.sean.ratapp.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import com.example.sean.ratapp.model.User;
import android.view.View;
import com.example.sean.ratapp.controllers.LoginActivity;





import com.example.sean.ratapp.R;

/**
 * Created by jfahe on 9/23/2017.
 */

public class HomeActivity extends AppCompatActivity {
    private Button logOutButton;
    private User _user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i = getIntent();
        _user = (User) i.getSerializableExtra("user");

        logOutButton = (Button) findViewById(R.id.logOut);


        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent logoutattempt = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(logoutattempt);
            }
        });
    }
}
