package com.example.sean.ratapp.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import com.example.sean.ratapp.model.User;
import android.view.View;
import android.widget.TextView;


import com.example.sean.ratapp.R;

/**
 * Created by jfahe on 9/23/2017.
 */

public class HomeActivity extends AppCompatActivity {
    private Button logOutButton;
    private Button searchSighting;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logOutButton = (Button) findViewById(R.id.logOut);
        searchSighting = (Button) findViewById(R.id.searchSighting);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent logoutattempt = new Intent(HomeActivity.this, StartScreenActivity.class);
                startActivity(logoutattempt);
            }
        });

        searchSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(HomeActivity.this, RatSightingList.class);
                startActivity(search);
            }
        });
    }
}
