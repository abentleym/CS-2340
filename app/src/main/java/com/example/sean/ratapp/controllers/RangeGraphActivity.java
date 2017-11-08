package com.example.sean.ratapp.controllers;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.graphics.Color;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;
import com.example.sean.ratapp.model.RatSighting;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 11/7/2017.
 */

public class RangeGraphActivity extends AppCompatActivity {//implements DatePickerDialog.OnDateSetListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sighting_range);

        // TODO: program button in layout to bring up another DatePickerDialog to specify an end
        // date for the range
        //final DatePickerDialog dpd;

        RatDataReader rdr = new RatDataReader();
       //load in rat data
        ArrayList<RatSighting> sightings = rdr.getRatDataArray();
        // sort data based on year (as an int)
        Collections.sort(sightings, new Comparator<RatSighting>() {
                    @Override
                    public int compare(RatSighting r1, RatSighting r2) {
                        return r1.getYear() - r2.getYear();
                    }
                });
        //establish max and min years for graphing purposes
        int minyear = sightings.get(0).getYear();
        int maxyear = sightings.get(sightings.size()-1).getYear();

        Map<Integer, Integer> points = new HashMap<>();

        //adds sightings to hashmap with value of 1. For each recurrence of the year increases the value by 1
        for(RatSighting r: sightings){
            if(points.containsKey(r.getYear())){
                points.put(r.getYear(), points.get(r.getYear()) + 1);
            } else {
                points.put(r.getYear(),1);
            }
        }

        List<DataPoint> dataPoints = new ArrayList<>();

        //cycle through hashmap and create new data point for each KV pair
            //with x coordinate being the key (year) and y coordinate
                //being the value (number of occurrences)
        for(Map.Entry<Integer,Integer> p : points.entrySet()){
            DataPoint x = new DataPoint( p.getKey(), p.getValue());
            dataPoints.add(x);
        }

        //convert arraylist to array bc the API will only accept an array
        DataPoint[] pointsarray = dataPoints.toArray(new DataPoint[dataPoints.size()]);

        GraphView graph = (GraphView) findViewById(R.id.graph);
       // graph.getViewport().setScrollable(true); // enables horizontal scrolling
        //graph.getViewport().setScrollableY(true); // enables vertical scrolling
       // graph.getViewport().setScalable(true); // enables horizontal zooming and scrolling
       // graph.getViewport().setScalableY(true); // enables vertical zooming and scrolling
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Date (Year)");
        graph.getGridLabelRenderer().setVerticalAxisTitle("Number of Sightings");

        LineGraphSeries<DataPoint> pointseries = new LineGraphSeries<>(pointsarray);

        graph.addSeries(pointseries);
        graph.getGridLabelRenderer().setHumanRounding(false);
        graph.setTitle("Historical Rat Data");






/**
        RatDataReader rdr = new RatDataReader();
        // Get an ArrayList of all the sightings
        ArrayList<RatSighting> sightings = rdr.getRatDataArray();
        // Create new ArrayList to put the dates of all the sightings into
        ArrayList<String> dates = new ArrayList<>();
        // HashMap: key = string representing date in format mm/yyyy
        //          value = number of sightings in that month
        HashMap<String, Integer> datesInt = new LinkedHashMap<>();
        // HashMap: key = Date object with month and year fields set, and date to 0
        //          value = number of rat sightings during a date
        HashMap<Date, Integer> dateDataPoints = new LinkedHashMap<>();

        try {
            // for each RatSighting, get the Date and add it to ArrayList dates
            for (RatSighting sight : sightings) {
                dates.add(sight.getDate());
            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Could not add date strings to ArrayList dates",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        try {
            // For each Date in ArrayList dates:
            for (String date : dates) {
                // extract the month and year from the date to use as a key
                String key = date.substring(0, 3) + date.substring(6);

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
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Could not load string dates with sighting count into HashMap datesInt",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        try {
            for (String date : datesInt.keySet()) {
                int numRatSightings = datesInt.get(date);
                Calendar calendar = Calendar.getInstance();
                int month = Integer.valueOf(date.substring(0, 2));
                int year = Integer.valueOf(date.substring(2));
                calendar.set(year, month, 1);
                Date dateData = calendar.getTime();

                dateDataPoints.put(dateData, numRatSightings);
            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Could not load Dates as data points into HashMap dateDataPoints",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        try {
            DataPoint[] dataPoints = new DataPoint[dateDataPoints.size()];
            int index = 0;
            for (Date dateDataPoint : dateDataPoints.keySet()) {
                dataPoints[index] = new DataPoint(dateDataPoint, dateDataPoints.get(dateDataPoint));
                index++;
            }

            GraphView graph = (GraphView) findViewById(R.id.graph);
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);

            graph.addSeries(series);
            //graph.setTitle("Rat Sightings through Time");
        } catch (Exception e) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Could not add DateDataPoints into final array dataPoints for Graph usage",
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

    }

    // for use with the DatePickerDialog
    //@Override
    //public void onDateSet(DatePicker view, int year, int month, int day) { }
}
**/
    }
}
