package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.Model;
import com.example.sean.ratapp.model.RatDataReader;
import java.io.File;
import java.io.InputStream;

public class StartScreenActivity extends AppCompatActivity {

    private final Model model = Model.INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startscreen);

        Button logInButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        RatDataReader rdr = new RatDataReader();

        File ratFile = new File(this.getFilesDir(), Model.DEFAULT_RATTEXT_FILE_NAME);
        File userFile = new File(this.getFilesDir(), Model.DEFAULT_USERTEXT_FILE_NAME);
        model.loadRatText(ratFile);
        RegisterActivity.loadUsersFromJSON(userFile);

            // open file that contains rat sighting data
            InputStream ins = getResources().openRawResource(getResources().getIdentifier(
                    "rat_sightings", "raw", getPackageName()));

            // load rat sighting data from file onto device memory
            rdr.LoadRatData(ins, 800);
            // TODO: For some reason outOfBounds errors occur after around 70 lines.

        logInButton.setOnClickListener(v -> {
            finish();
            Intent loginAttempt = new Intent(StartScreenActivity.this, LogginginActivity.class);
            startActivity(loginAttempt);
        });

        registerButton.setOnClickListener(v -> {
            finish();
            Intent registerAttempt = new Intent(StartScreenActivity.this, RegisterActivity.class);
            startActivity(registerAttempt);
        });
    }
}
