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

class RatSightingDetails extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;//for map testing purposes
    private static int selectedsighting;//for getting the item in the list view
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.ratsightingdetails);
        RatDataReader rdr = new RatDataReader();
        ArrayList<RatSighting> ratadata = rdr.getRatDataArray();
        RatSighting selectedratsighting = ratadata.get(selectedsighting);
        TextView textview = (TextView)findViewById(R.id.ratsightingdetails);
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

        /**
         * Early code to get this fragment running in the right place and at the right time.
         * Still researching this
         */
        setContentView(R.layout.ratsightingdetails);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }






    public static void setSelectedsighting(int pos) {
        selectedsighting = pos;
    }

}



