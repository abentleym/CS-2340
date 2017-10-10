package com.example.sean.ratapp.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;
import com.example.sean.ratapp.model.RatSighting;

import java.io.InputStream;

/**
 * Created by jfahe on 10/8/2017.
 */

public class RatSightingList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratsighting_list);

        TextView test = (TextView)findViewById(R.id.textView5);
        RatDataReader rdr = new RatDataReader();


        InputStream ins = getResources().openRawResource(
                getResources().getIdentifier("rat_sightings",
                        "raw", getPackageName()));

        RatSighting[] ratData = rdr.GetRatData(ins, 5);

        String testString = "";
        boolean condition = true;

        test.setText(ratData[0].getKey() + "\n" + ratData[0].getDate()+ "\n" + ratData[0].getLocation()
                + "\n" + ratData[0].getZip()+ "\n" + ratData[0].getAddress()+ "\n" + ratData[0].getCity()
                + "\n" + ratData[0].getBorough()+ "\n" + ratData[0].getLatitude()+ "\n" + ratData[0].getLongitude());
    }

    void StartDataReading() {

    }
}
