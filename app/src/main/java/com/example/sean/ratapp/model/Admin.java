package com.example.sean.ratapp.model;


/**
 * Created by jfahe on 10/2/2017.
 */

public class Admin extends User {
    private String _userName;
    private String _password;

    /**
     *
     * @param user username for admin
     * @param password password for admin
     */
    public Admin(String user, String password) {
        _userName = user;
        _password = password;
    }

    /**
     * gets Admin Username
     * @return String Username
     */
    public String getUsername() {
        return _userName;
    }
    /**
     * gets Admin password
     * @return String that is the password
     */
    public String getPassword() {
        return _password;
    }
    /**
     * gets Admin password
     * @return String that is the password
     */
    public String toString() {
        return "Admin " + _userName;
    }

    @Override
    /**
     * Tells whether the user is an admin.
     */
    public boolean isAdmin() {
        return true;
    }
}
