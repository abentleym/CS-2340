package com.example.sean.ratapp.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.sean.ratapp.controllers.HomeActivity;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 10/9/2017.
 */

public class RatDataReader extends AsyncTask<InputStream, Integer, Long> {

    private RatSighting[] ratData;
    private String[] ratDataString;

    // Loads rat sighting data from file and formats into various data structures to return later
    // TODO: right now about three data structures are created from the data in the file, using up
    // a lot of memory; limit the number of data structures created in this method so that memory
    // isn't wasted.
    public void LoadRatData(InputStream ins, int maxEntriesToRead) {

        ArrayList<RatSighting> ratSightList = new ArrayList<RatSighting>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(ins, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            while ((line = br.readLine()) != null && maxEntriesToRead-- > 0) {
                String[] tokens = line.split(",");

                ratSightList.add(new RatSighting(Integer.parseInt(tokens[0]), tokens[1], tokens[7],
                        Integer.parseInt(tokens[8]), tokens[9], tokens[16], tokens[23],
                        Double.parseDouble(tokens[49]), Double.parseDouble(tokens[50])));
            }
            br.close();
        } catch (IOException e) {
            Log.e("Tag", "error reading assets", e);
        }

        ratData = new RatSighting[ratSightList.size()];
        ratDataString = new String[ratSightList.size()];

        for (int i = 0; i < ratSightList.size(); i++) {
            ratData[i] = ratSightList.get(i);
            ratDataString[i] = String.valueOf(ratSightList.get(i).getKey());
        }
    }

    // returns rat sightings with complete set of data
    public RatSighting[] getRatDataArray() {
        return ratData;
    }

    // returns rat sightings as a unique id only
    public String[] getRatDataString() { return ratDataString; }

    @Override
    protected Long doInBackground(InputStream... params) {

        return null;
    }

    protected void onProgressUpdate(Integer... progress) {

    }

    protected void onPostExecute(Long result) {

    }
}
