package com.example.sean.ratapp.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;
import com.example.sean.ratapp.model.RatSighting;

import java.io.InputStream;
import java.util.List;

/**
 * Created by jfahe on 10/8/2017.
 */

public class RatSightingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratsightinglist);

        RatDataReader rdr = new RatDataReader();

        // open file that contains rat sighting data
        InputStream ins = getResources().openRawResource(getResources().getIdentifier(
                "rat_sightings", "raw", getPackageName()));

        // load rat sighting data from file onto device memory
        rdr.LoadRatData(ins);

        // create a list view to list rat sightings
        ListView listView = (ListView) findViewById(R.id.listOfRatSightings);

        // create an adapter to populate the list view with the unique ids of the rat sightings
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, rdr.getRatDataString());

        // send data from adapter to list view to display
        listView.setAdapter(adapter);
    }
}
