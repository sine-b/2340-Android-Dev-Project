package edu.gatech.cs2340.a2340_android_dev_project;

import org.junit.Test;

import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;
import edu.gatech.cs2340.a2340_android_dev_project.model.User;
import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;

import static org.junit.Assert.*;


public class AuthenticateTest {

    UserList userList = new UserList();
    User user = new User("user", "password", AccType.BASICUSER);

    @Test
    public void tryGoodCredentials() {

        userList.addUser(user);

        assertTrue(userList.authenticate("user", "password"));

    }

    @Test
    public void tryBadPassword() {

        userList.addUser(user);

        assertFalse(userList.authenticate("user", "notthepassword"));

    }

    @Test
    public void tryBadUsername() {

        userList.addUser(user);

        assertFalse(userList.authenticate("someguy", "password"));

    }

    @Test
    public void tryMissingInput() {

        userList.addUser(user);

        assertFalse(userList.authenticate("", ""));
        assertFalse(userList.authenticate("", "password"));
        assertFalse(userList.authenticate("user", ""));

    }

    @Test
    public void tryWhitespace() {

        userList.addUser(user);

        assertTrue(userList.authenticate("user  ", "  password"));

    }

}
