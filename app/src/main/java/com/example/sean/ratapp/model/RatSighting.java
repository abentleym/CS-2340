package com.example.sean.ratapp.model;

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

    public RatSighting(String loc, int key, int zip, String address, String city, int longitude,
                       int latitude, String date) {
        this.locationType = loc;
        this.key = key;
        this.zip = zip;
        this.address = address;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.createdDate = date;
    }

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

    public int getKey() { return key; }
    public String getDate() { return createdDate; }
    public String getLocation() { return locationType; }
    public int getZip() { return zip; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getBorough() { return borough; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
}
