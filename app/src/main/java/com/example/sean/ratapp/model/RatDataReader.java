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

    public RatSighting[] GetRatData(InputStream ins, int numEntriesToGet) {

        ArrayList<RatSighting> ratSightList = new ArrayList<RatSighting>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(ins, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            while ((line = br.readLine()) != null && numEntriesToGet-- > 0) {
                String[] tokens = line.split(",");

                ratSightList.add(new RatSighting(Integer.parseInt(tokens[0]), tokens[1], tokens[7],
                        Integer.parseInt(tokens[8]), tokens[9], tokens[16], tokens[23],
                        Double.parseDouble(tokens[49]), Double.parseDouble(tokens[50])));
            }
            br.close();
        } catch (IOException e) {
            Log.e("Tag", "error reading assets", e);
        }

        RatSighting[] ratData = new RatSighting[ratSightList.size()];
        for (int i = 0; i < ratSightList.size(); i++) {
            ratData[i] = ratSightList.get(i);
        }

        return ratData;
    }

    @Override
    protected Long doInBackground(InputStream... params) {

        return null;
    }

    protected void onProgressUpdate(Integer... progress) {

    }

    protected void onPostExecute(Long result) {

    }
}
