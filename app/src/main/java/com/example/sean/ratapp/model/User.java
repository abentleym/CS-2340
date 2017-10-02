package com.example.sean.ratapp.model;

import android.os.Parcelable;
import android.widget.SectionIndexer;

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

    // user has not logged in yet
    public User() {
        this("user", "pass");
    }

    public Boolean logIn(String name, String password) {
        if (name.equals(_userName) && password.equals(_userPassword)) {
            _loggedIn = true;
            return true;
        } else {
            return false;
        }
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

    public void logOut() {
        _loggedIn = false;
    }

    public String toString() {
        return _userName;
    }
}
