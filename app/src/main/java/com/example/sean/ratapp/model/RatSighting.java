package com.example.sean.ratapp.model;

/**
 * Created by jfahe on 10/6/2017.
 */

public class RatSighting {
    private String locationType;
    private int id;
    private int zip;
    private String address;
    private String city;
    private int latitude;
    private int longitude;
    private String date;

    public RatSighting(String loc, int id, int zip, String address, String city, int longitude,
                       int latitude, String date) {
        this.locationType = loc;
        this.id = id;
        this.zip = zip;
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }

    public int getId() { return id; }
}
