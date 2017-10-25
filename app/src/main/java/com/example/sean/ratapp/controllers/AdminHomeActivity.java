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
 * Created by jfahe on 10/4/2017.
 */

public class AdminHomeActivity extends AppCompatActivity {
    private Button logOutButton;
    private Button searchSighting;
    private Button addSighting;
    private Model model = Model.INSTANCE;
    private File file;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);

        logOutButton = (Button) findViewById(R.id.logOut);
        searchSighting = (Button) findViewById(R.id.searchSighting);
        addSighting = (Button) findViewById(R.id.addSighting);

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

        addSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(AdminHomeActivity.this, AddSightingActivity.class);
                startActivity(add);
            }
        });
    }
}
