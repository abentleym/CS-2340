package com.example.sean.ratapp.model;

import android.util.Log;

import java.util.List;

/**
 * Created by jfahe on 10/6/2017.
 */

public class Model {
    public static final Model INSTANCE = new Model();

    private List<RatSighting> ratSighting;

    public void addItem(RatSighting rat) { ratSighting.add(rat); }

    public List<RatSighting> getItems() {
        return ratSighting;
    }

    public RatSighting findSightingById(int id) {
        for (RatSighting r : ratSighting) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }
}
