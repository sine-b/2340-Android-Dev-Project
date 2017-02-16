package edu.gatech.cs2340.a2340_android_dev_project.model;

/**
 * User object for that represents one user in the system. Contains
 * username and password attributes for now, may have role or privilege
 * attribute later.
 */

public class User {

    String user;
    String pass;

    /**
     * Constructs a new user with the username and password provided.
     *
     * @param user the string that will serve as the username
     * @param pass the string that will serve as the password
     */
    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    /**
     * Checks if the password belongs to this user.
     *
     * @param pass the string to be checked
     * @return true if the password is valid, false if it is not
     */
    public boolean checkPass(String pass) {
        return pass.equals(this.pass);
    }

}
