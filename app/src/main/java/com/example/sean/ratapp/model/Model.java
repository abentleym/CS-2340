package com.example.sean.ratapp.model;

import android.util.Log;

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

    public RatSighting findSightingById(int id) {
        for (RatSighting r : ratSightingList) {
            if (r.getKey() == id) {
                return r;
            }
        }
        return null;
    }
}
