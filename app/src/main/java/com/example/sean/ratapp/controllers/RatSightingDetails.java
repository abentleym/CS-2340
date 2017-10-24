package com.example.sean.ratapp.controllers;

import com.example.sean.ratapp.R;
import com.example.sean.ratapp.model.RatDataReader;
import com.example.sean.ratapp.model.RatSighting;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by nandanj.gouri on 10/11/17.
 */

class RatSightingDetails extends AppCompatActivity  {
    private static int selectedsighting;//for getting the item in the list view

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratsightingdetails);
        RatDataReader rdr = new RatDataReader();
        ArrayList<RatSighting> ratadata = rdr.getRatDataArray();
        RatSighting selectedratsighting = ratadata.get(selectedsighting);
        TextView textview = (TextView) findViewById(R.id.ratsightingdetails);
        String ratInformation = new String();
        ratInformation += "Address : " + selectedratsighting.getAddress() + "\n";
        ratInformation += "City : " + selectedratsighting.getCity() + "\n";
        ratInformation += "Location : " + selectedratsighting.getLocation() + "\n";
        ratInformation += "Zip : " + selectedratsighting.getZip() + "\n";
        ratInformation += "Borough : " + selectedratsighting.getBorough() + "\n";
        ratInformation += "Date : " + selectedratsighting.getDate() + "\n";
        ratInformation += "Latitude : " + selectedratsighting.getLatitude() + "\n";
        ratInformation += "Longitude : " + selectedratsighting.getLongitude() + "\n";
        textview.setText(ratInformation);
    }



    public static void setSelectedsighting(int pos) {
        selectedsighting = pos;
    }

}



