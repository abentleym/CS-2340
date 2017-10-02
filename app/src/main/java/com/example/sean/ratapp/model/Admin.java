package com.example.sean.ratapp.model;

import java.io.Serializable;

/**
 * Created by jfahe on 10/2/2017.
 */

public class Admin extends User {
    private String _userName;
    private String _password;

    public Admin(String user, String password) {
        _userName = user;
        _password = password;
    }

    public String getUsername() {
        return _userName;
    }

    public String getPassword() {
        return _password;
    }

    public String toString() {
        return "Admin " + _userName;
    }
}
