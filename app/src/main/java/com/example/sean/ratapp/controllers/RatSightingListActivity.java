package com.example.sean.ratapp.controllers;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jfahe on 10/8/2017.
 */

public class RatSightingListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratsightinglist);

        RatDataReader rdr = new RatDataReader();

        // open file that contains rat sighting data
        /*InputStream ins = getResources().openRawResource(getResources().getIdentifier(
                "rat_sightings", "raw", getPackageName()));

        // load rat sighting data from file onto device memory
        rdr.LoadRatData(ins, 40);*/
/*
        // create a list view to list rat sightings
        ListView listView = (ListView) findViewById(R.id.listOfRatSightings);

        // create an adapter to populate the list view with the unique ids of the rat sightings
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, rdr.getRatDataString());

        // send data from adapter to list view to display
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent search = new Intent(RatSightingList.this, RatSightingDetails.class);
                RatSightingDetails.setSelectedsighting(position);
                startActivity(search);

            }
            });
*/
        final EditText textDate = (EditText) findViewById(R.id.dateEditText);
        DateRangeInput dialogInput = new DateRangeInput();
        dialogInput.textDate = textDate;/*
        textDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                }
            }
        });*/
        /*
    <ListView
        android:id="@+id/listOfRatSightings"
        android:layout_width="match_parent"
        android:layout_height="match_parent"></ListView>*/
        final DatePickerDialog dpd;
        if (!startDateSet) {
            dpd = new DatePickerDialog(this, this, 2015, 9, 5);
        } else {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            int month = 9;
            int day = 0;
            int year = 2015;
            try {
                Date d = dateFormat.parse(startDate);
                month = Integer.parseInt(startDate.substring(0, 2));
                day = Integer.parseInt(startDate.substring(3, 5));
                year = Integer.parseInt(startDate.substring(6, 10));
            } catch (ParseException e) {
                System.out.println("error parsing date");
            }
            dpd = new DatePickerDialog(this, this, year, month, day);
        }
        ((Button) findViewById(R.id.pickDateButton))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dpd.show();
                    }
                });
    }

    boolean startDateSet = false;
    String startDate;
    String endDate;

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        if (!startDateSet) {
            startDate = month + "/" + day + "/" + year;
            startDateSet = true;
            System.out.println("Start: " + startDate);
        } else {
            endDate = month + "/" + day + "/" + year;
            startDateSet = false;
            System.out.println("end: " + endDate);

            startActivity(new Intent(RatSightingListActivity.this, MapActivity.class));
        }
    }

    @Override
    public void onMapReady(GoogleMap gmap) {

        LatLng atlanta = new LatLng(-34, 151);
        gmap.addMarker(new MarkerOptions().position(atlanta).title("Marker in Sydney"));
        gmap.moveCamera(CameraUpdateFactory.newLatLng(atlanta));
    }
}
