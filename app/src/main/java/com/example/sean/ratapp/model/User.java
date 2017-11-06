package com.example.sean.ratapp.model;

import java.io.Serializable;


/**
 * Created by jfahe on 9/22/2017.
 */

public class User implements Serializable{
    private String _userName; //string of user id
    private String _userPassword; //string of user password
    private Boolean _loggedIn; //used to tell if user is logged in

    public User(String name, String password) {
        _userName = name;
        _userPassword = password;
        _loggedIn = false; // false upon app start up
    }

    public User() {
        _userPassword = "pass";
        _userName = "user";
    }



    public void logIn() {
        _loggedIn = true;
    }

    public String getUsername() {
        return _userName;
    }

    public String getPassword() {
        return _userPassword;
    }

    public String toString() {
        return _userName;
    }

    public boolean isAdmin() {
        return false;
    }

}