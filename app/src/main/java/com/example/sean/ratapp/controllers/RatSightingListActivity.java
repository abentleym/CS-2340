package com.example.sean.ratapp.controllers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jfahe on 10/8/2017.
 */

public class RatSightingListActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratsightinglist);

        RatDataReader rdr = new RatDataReader();

        // create an adapter to populate the list view with the unique ids of the rat sightings
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, rdr.getRatDataString());

        ListView listView =  (ListView) findViewById(R.id.AllRatSightList);

        // send data from adapter to list view to display
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                           long id) {
                    Intent search = new Intent(RatSightingListActivity.this, RatSightingDetails.class);
                    RatSightingDetails.setSelectedsighting(position);
                    startActivity(search);
              }
        });

        final DatePickerDialog dpd;
        if (!startDateSet) {
            dpd = new DatePickerDialog(this, this, 2015, 8, 4);
        } else {
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            int month = 9;
            int day = 0;
            int year = 2015;
            try {
                Date d = dateFormat.parse(startDateString);
                month = Integer.parseInt(startDateString.substring(0, 2));
                day = Integer.parseInt(startDateString.substring(3, 5));
                year = Integer.parseInt(startDateString.substring(6, 10));
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
    String startDateString;
    String endDateString;

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        if (!startDateSet) {
            startDateString = "";
            if (++month < 10) {
                startDateString += "0";
            }
            startDateString += month + "/";
            if (day < 10) {
                startDateString += "0";
            }
            startDateString += day + "/" + year;
            startDateSet = true;
            System.out.println("Start: " + startDateString);
            ((Button) findViewById(R.id.pickDateButton)).setText("What's the latest date to search for?");
        } else {
            endDateString = "";
            if (++month < 10) {
                endDateString += "0";
            }
            endDateString += month + "/";
            if (day < 10) {
                endDateString += "0";
            }
            endDateString += day + "/" + year;
            startDateSet = false;
            System.out.println("end: " + endDateString);

            MapActivity.SetDateRange(startDateString, endDateString);
            startActivity(new Intent(RatSightingListActivity.this, MapActivity.class));
            ((Button) findViewById(R.id.pickDateButton)).setText("What's the earliest date to search for?");
        }
    }

    public String getStartDate() {
        return startDateString;
    }

    public String getEndDate() {
        return endDateString;
    }
}
