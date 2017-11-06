package com.example.sean.ratapp.model;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Sean on 10/9/2017.
 */

public class RatDataReader extends AsyncTask<InputStream, Integer, Long> {

    private static ArrayList<RatSighting> ratData = new ArrayList<RatSighting>();
    private static ArrayList<String> ratDataString = new ArrayList<String>();

    // Loads rat sighting data from file and formats into various data structures to return later
    // TODO: right now about three data structures are created from the data in the file, using up
    // a lot of memory; limit the number of data structures created in this method so that memory
    // isn't wasted.
    public void LoadRatData(InputStream ins, int maxEntriesToRead) {

        int i = 0;
        ArrayList<RatSighting> ratSightList = new ArrayList<RatSighting>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(ins, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            while ((line = br.readLine()) != null && maxEntriesToRead-- > 0) {
                String[] tokens = line.split(",");
                //Error at key 31473349, entry 75  in CSV

                if (tokens.length == 53) {
                        System.out.println("Read entry " + i++);

                    if (i > 69) {
                        System.out.println("Entry " + i + " has key " + tokens[0] + " and split has " + tokens
                                .length + " tokens.");
                    }
                    ratSightList.add(new RatSighting(Integer.parseInt(tokens[0]), tokens[1], tokens[7],
                            Integer.parseInt(tokens[8]), tokens[9], tokens[16], tokens[23],
                            Double.parseDouble(tokens[49]), Double.parseDouble(tokens[50])));
                }
            }
            br.close();
        } catch (IOException e) {
            Log.e("Tag", "error reading assets", e);
        }
        Collections.sort(ratSightList, new Comparator<RatSighting>() {
            @Override
            public int compare(RatSighting o1, RatSighting o2) {

                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Date date1;

                try{
                    date1 = sdf.parse(o1.getDate().substring(0, 10));
                } catch (ParseException pe) {
                    System.out.println("Error: Date " + o1.getDate().substring(0, 10));
                    return -1;
                }
                Date date2;

                try{
                    date2 = sdf.parse(o2.getDate().substring(0, 10));
                } catch (ParseException pe) {
                    System.out.println("Error: Date " + o2.getDate().substring(0, 10));
                    return -1;
                }
                if (date1.after(date2)) {
                    return 1;
                }
                return -1;
            }
        });

        for (RatSighting r : ratSightList) {
            i++;
            ratData.add(r);
            ratDataString.add(r.getKey() + " " + r.getCity());
        }
        System.out.println(i + " entries parsed.");
    }

    /**
     * getter for rat data array
     * @return the rat data array
     */
    public static ArrayList<RatSighting> getRatDataArray() {
        return ratData;
    }

    /**
     * getter for rat data string array
     * @return array of rat data strings
     */
    public ArrayList<String> getRatDataString() { return ratDataString; }

    /**
     * adds a new rat sighting to the rat data array
     */
    public void addSighting(RatSighting sighting) {
        ratData.add(0, sighting);
        ratDataString.add(0, sighting.toString());
    }

    @Override
    protected Long doInBackground(InputStream... params) {

        return null;
    }

    protected void onProgressUpdate(Integer... progress) {

    }

    protected void onPostExecute(Long result) {

    }

    /**
     * saves rat data by calling ratsighting saveAsText method
     * @param writer object used to write to the text file
     */
    void saveAsText(PrintWriter writer) {
        System.out.println("Manager saving: " + ratData.size() + " rat sightings" );
        writer.println(ratData.size());
        for(RatSighting s : ratData) {
            s.saveAsText(writer);
        }
    }

    /**
     * loads rat text by creating new rat sightings from the text file and adds them back to the
     * arraylist
     * also recreates the string array list
     * @param reader the object that reads the file data
     */
    void loadFromText(BufferedReader reader) {
        System.out.println("Loading Text File");
        ratData.clear();
        ratDataString.clear();
        try {
            String countStr = reader.readLine();
            assert countStr != null;
            int count = Integer.parseInt(countStr);

            //then read in each user to model
            for (int i = 0; i < count; ++i) {
                String line = reader.readLine();
                RatSighting s = RatSighting.parseEntry(line);
                if (s != null) {
                    ratData.add(s);
                    ratDataString.add(s.toString());
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done loading text file with " + ratData.size() + " rat sightings");
    }
}
