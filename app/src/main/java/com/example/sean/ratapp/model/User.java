package com.example.sean.ratapp.model;

import java.io.Serializable;


/**
 * Created by jfahe on 9/22/2017.
 */

@SuppressWarnings("ALL")
public class User implements Serializable{
    private final String _userName; //string of user id
    private final String _userPassword; //string of user password

    public User(String name, String password) {
        _userName = name;
        _userPassword = password;
    }

    User() {
        _userPassword = "pass";
        _userName = "user";
    }



    public void logIn() {
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