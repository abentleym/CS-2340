package com.example.sean.ratapp.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.sean.ratapp.R;

/**
 * Created by jfahe on 10/13/2017.
 */

public class AddSightingActivity extends AppCompatActivity {
    private EditText address;
    private EditText city;
    private EditText locationType;
    private EditText zip;
    private EditText borough;
    private EditText date;
    private EditText latitude;
    private EditText longitude;
    private Button addSighting;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sighting);

        // setting up edit texts to corresponding variables
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);
        locationType = (EditText) findViewById(R.id.locationType);
        zip = (EditText) findViewById(R.id.zipcode);
        borough = (EditText) findViewById(R.id.borough);
        date = (EditText) findViewById(R.id.date);
        latitude = (EditText) findViewById(R.id.latitude);
        longitude = (EditText) findViewById(R.id.longitude);

        addSighting = (Button) findViewById(R.id.add);

    }
}
