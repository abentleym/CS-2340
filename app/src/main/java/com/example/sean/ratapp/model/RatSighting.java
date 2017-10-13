package com.example.sean.ratapp.model;


import java.util.Random;

/**
 * Created by jfahe on 10/6/2017.
 */

public class RatSighting {
    private String locationType;
    private int key;
    private int zip;
    private String address;
    private String city;
    private double latitude;
    private double longitude;

    private  String createdDate;
    private String borough;


    public RatSighting(int key, String createdDate, String locationType, int zip,
                       String address, String city, String borough, double latitude, double longitude) {
        this.locationType = locationType;
        this.key = key;
        this.zip = zip;
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.createdDate = createdDate;
        this.borough = borough;
    }

    //constructor used for adding rat sightings where uniqueId creates id
    public RatSighting(String createdDate, String locationType, int zip, String address,
                       String city, String borough, double latitude, double longitude) {
        this(uniqueId(), createdDate, locationType,zip, address, city, borough, latitude,
                longitude);
    }

    public int getKey() { return key; }
    public String getDate() { return createdDate; }
    public String getLocation() { return locationType; }
    public int getZip() { return zip; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getBorough() { return borough; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    /**
     * method used to generate random id number
     * @return rand id number
     */
    public static int uniqueId() {
        Random rand = new Random();
        int id = rand.nextInt(100);
        id = id * rand.nextInt(50);
        id += rand.nextInt(100);
        return id;
    }
    // toString method to return some info as a string to be displayed in each entry in the ListView
    // that lists all rat sightings. Currently returns unique key of rat sighting.
    @Override
    public String toString() {
        return String.valueOf(key) + " " + this.getCity();
    }
}
