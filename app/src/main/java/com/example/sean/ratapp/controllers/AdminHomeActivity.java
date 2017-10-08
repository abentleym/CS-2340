package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sean.ratapp.R;

/**
 * Created by jfahe on 10/4/2017.
 */

public class AdminHomeActivity extends AppCompatActivity {
    private Button logOutButton;
    private Button searchSighting;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);

        logOutButton = (Button) findViewById(R.id.logOut);
        searchSighting = (Button) findViewById(R.id.searchSighting);

        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent logoutattempt = new Intent(AdminHomeActivity.this, StartScreenActivity.class);
                startActivity(logoutattempt);
            }
        });

        searchSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent search = new Intent(AdminHomeActivity.this, RatSightingList.class);
                startActivity(search);
            }
        });
    }
}
