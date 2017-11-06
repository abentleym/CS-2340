package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.Model;

import java.io.File;

/**
 * Created by jfahe on 9/23/2017.
 */

public class HomeActivity extends AppCompatActivity {
    private Button logOutButton;
    private Button searchSighting;
    private Button addSighting;
    private Model model = Model.INSTANCE;
    private File file;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logOutButton = (Button) findViewById(R.id.logOut);
        searchSighting = (Button) findViewById(R.id.searchSighting);
        addSighting = (Button) findViewById(R.id.addSighting);

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
                Intent search = new Intent(HomeActivity.this, RatSightingListActivity.class);
                startActivity(search);
            }
        });

        addSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(HomeActivity.this, AddSightingActivity.class);
                startActivity(add);
            }
        });

    }
}
