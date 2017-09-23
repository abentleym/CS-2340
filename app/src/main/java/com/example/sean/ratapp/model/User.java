package com.example.sean.ratapp.model;

/**
 * Created by jfahe on 9/22/2017.
 */

public class User {
    private String _userName; //string of user id
    private String _userPassword; //string of user password
    private Boolean _loggedIn; //used to tell if user is logged in

    public User(String name, String password) {
        _userName = name;
        _userPassword = password;
        _loggedIn = true; //sets logged in for true on registration
    }

    public Boolean logIn(String name, String password) {
        if (name.equals(_userName) && password.equals(_userPassword)) {
            _loggedIn = true;
            return true;
        } else {
            return false;
        }
    }

    public void logOut() {
        _loggedIn = false;
    }
}
