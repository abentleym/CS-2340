package com.example.sean.ratapp.controllers;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;
import com.example.sean.ratapp.model.RatSighting;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Alex on 11/7/2017.
 */

public class RangeGraphActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sighting_range);

        // TODO: program button in layout to bring up another DatePickerDialog to specify an end
        // date for the range
        final DatePickerDialog dpd;

        RatDataReader rdr = new RatDataReader();
        // Get an ArrayList of all the sightings
        ArrayList<RatSighting> sightings = rdr.getRatDataArray();
        // Create new ArrayList to put the dates of all the sightings into
        ArrayList<String> dates = new ArrayList<>();
        // HashMap: key = string representing date in format mm/yyyy
        //          value = number of sightings in that month
        HashMap<String, Integer> datesInt = new LinkedHashMap<>();

        // for each RatSighting, get the Date and add it to ArrayList dates
        for (RatSighting sight : sightings) {
            dates.add(sight.getDate());
        }

        // For each Date in ArrayList dates:
        for (String date : dates) {
            // extract the month and year from the date to use as a key
            String key = date.substring(0,3) + date.substring(6);

            // if the hashmap already contains the key, then increment the value, and update the
            // value mapped to that key
            if (datesInt.containsKey(key)) {
                int value = datesInt.get(key);
                value++;
                datesInt.remove(key);
                datesInt.put(key, value);
            } else { // if key is new then add to the hashmap with starting value of 1
                datesInt.put(key, 1);
            }
        }

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                // DataPoint(x, y)
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });

        graph.addSeries(series);
    }

    // for use with the DatePickerDialog
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) { }
}
