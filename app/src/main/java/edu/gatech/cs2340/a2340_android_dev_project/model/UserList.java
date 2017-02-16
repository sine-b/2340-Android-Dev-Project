package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.util.Map;
import java.util.HashMap;

/**
 * Class that acts as a database of User objects.
 */

public class UserList {

    Map<String, User> userList = new HashMap<>();

    /**
     * Adds a new user to the user list using the name and
     * password provided.
     *
     * @param name the string that will serve as the new user's name
     * @param pass the string that will serve as the new user's password
     */
    public void addUser(String name, String pass) {
        User user = new User("name", "pass");
        userList.put(name, user);
    }

    /**
     * Authenticates the credentials provided, checking if the pairing
     * is associate with a user.
     *
     * @param name the name to be checked
     * @param pass the password to be checked
     * @return returns true if the name/pass pair is associated with a user,
     * false if it is not
     */
    public boolean authenticate(String name, String pass) {
        User user = userList.get(name);
        if (user != null) {
            return user.checkPass(pass);
        } else {
            return false;
        }
    }

}
