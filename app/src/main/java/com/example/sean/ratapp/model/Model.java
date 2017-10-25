package com.example.sean.ratapp.model;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by jfahe on 10/6/2017.
 */

public class Model {
    public static final Model INSTANCE = new Model();

    private List<RatSighting> ratSightingList;

    public void addItem(RatSighting ratSighting) { ratSightingList.add(ratSighting); }

    public List<RatSighting> getItems() {
        return ratSightingList;
    }

    private RatDataReader rdr = new RatDataReader();

    public final static String DEFAULT_RATTEXT_FILE_NAME = "ratdata.txt";


    public RatSighting findSightingById(int id) {
        for (RatSighting r : ratSightingList) {
            if (r.getKey() == id) {
                return r;
            }
        }
        return null;
    }

    public boolean saveText(File file) {
        System.out.println("Saving as a text file");
        try {
            PrintWriter pw = new PrintWriter(file);
            rdr.saveAsText(pw);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("UserManagerFacade", "Error opening the text file for save!");
            return false;
        }

        return true;
    }

    public boolean loadText(File file) {
        try {
            //make an input object for reading
            BufferedReader reader = new BufferedReader(new FileReader(file));
            rdr.loadFromText(reader);

        } catch (FileNotFoundException e) {
            Log.e("ModelSingleton", "Failed to open text file for loading!");
            return false;
        }

        return true;
    }
}
