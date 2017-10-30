package com.example.sean.ratapp.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.Model;
import com.example.sean.ratapp.model.RatDataReader;
import com.example.sean.ratapp.model.UserManager;

import java.io.File;
import java.io.InputStream;

public class StartScreenActivity extends AppCompatActivity {

    Button logInButton;
    Button registerButton;
    private File ratFile;
    private File userFile;
    private Model model = Model.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);

        logInButton = (Button) findViewById(R.id.loginButton);
        registerButton = (Button) findViewById(R.id.registerButton);

        RatDataReader rdr = new RatDataReader();

        ratFile = new File(this.getFilesDir(), model.DEFAULT_RATTEXT_FILE_NAME);
        userFile = new File(this.getFilesDir(), model.DEFAULT_USERTEXT_FILE_NAME);
        model.loadRatText(ratFile);
        RegisterActivity.loadUsersFromJSON(userFile);

            // open file that contains rat sighting data
            InputStream ins = getResources().openRawResource(getResources().getIdentifier(
                    "rat_sightings", "raw", getPackageName()));

            // load rat sighting data from file onto device memory
            rdr.LoadRatData(ins, 70);
            // TODO: For some reason outOfBounds errors occur after around 70 lines.

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent loginattempt = new Intent(StartScreenActivity.this, LogginginActivity.class);
                startActivity(loginattempt);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                finish();
                Intent registerAttempt = new Intent(StartScreenActivity.this, RegisterActivity.class);
                startActivity(registerAttempt);
            }
        });
    }
}
