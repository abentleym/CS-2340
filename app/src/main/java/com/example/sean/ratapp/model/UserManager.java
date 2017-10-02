package com.example.sean.ratapp.model;

import java.util.HashMap;

/**
 * Created by Sean on 10/1/2017.
 */

public class UserManager {
    private static HashMap<String, User> _user_hash_map = new HashMap<>(10);


    /**
     *
     * @param username the username a user has input
     * @param password the password the user believes corresponds to the username
     * @return if there is a user with the provided username and password
     */
    public static boolean checkUserLogin(String username, String password) {
        if (_user_hash_map.containsKey(username)) {
            return password == _user_hash_map.get(username).getUsername();
        }
        return false;
    }

    /**
     *
     * @param username the username to check if there is already a User for
     * @return if there is already a user with this name
     */
    public static boolean userExists(String username) {
        return _user_hash_map.containsKey(username);
    }

    /**
     *
     * @param username the name inputted by a user
     * @param password the password inputted by the user
     * @return false if a username with the username already exists, else a new user is added to the system
     */
    public static boolean addUser(String username, String password) {
        if (_user_hash_map.containsKey(username)) {
            return false;
        }

        _user_hash_map.put(username, new User(username, password));
        return true;
    }

    public static boolean addAdmin(String username, String password) {
        if (_user_hash_map.containsKey(username)) {
            return false;
        }

        _user_hash_map.put(username, new Admin(username, password));
        return true;
    }

    /**
     *
     * @param username the username of the user logging in
     * @param password the password the user believes is right
     * @return true if there is a user with the given username and the given password is correct
     */
    public static boolean loginUser(String username, String password) {

        if (_user_hash_map.containsKey(username) && password.equals(_user_hash_map.get(username).getPassword())) {
            _user_hash_map.get(username).logIn();
            return true;
        } else {
            return false;
        }
    }

    public static User getUser(String username) {
        return _user_hash_map.get(username);
    }
}
