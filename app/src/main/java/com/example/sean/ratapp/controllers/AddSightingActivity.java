package com.example.sean.ratapp.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;
import com.example.sean.ratapp.model.RatSighting;

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
    private RatDataReader rdr;

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

        rdr = new RatDataReader();

        /*when add sighting button is clicked we create new new sighting object then add it to the
        ratsightings array list then it takes you to the activity with all the sightings in a
        list*/
        addSighting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatSighting sighting = new RatSighting(date.getText().toString(),
                        locationType.getText().toString(), Integer.parseInt(zip.getText().toString()),
                        address.getText().toString(), city.getText().toString(),
                        borough.getText().toString(), Double.parseDouble(latitude.getText().toString()),
                        Double.parseDouble(longitude.getText().toString()));

               if(isValid(sighting)){//adds sighting iff it has data in each field
                   rdr.addSighting(sighting);
                   finish();
                   Intent go = new Intent(AddSightingActivity.this, RatSightingList.class);
                   startActivity(go);
               }
            }
        });

    }
    public boolean isValid(RatSighting sighting){//makes sure all data fields are full
        if(address == null || city == null || locationType == null || zip == null
                || borough == null || date == null || latitude == null || longitude == null){
            return false;
        }
        return true;

    }
}
