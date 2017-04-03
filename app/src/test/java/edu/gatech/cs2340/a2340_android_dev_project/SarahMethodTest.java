package edu.gatech.cs2340.a2340_android_dev_project;

import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;
import edu.gatech.cs2340.a2340_android_dev_project.model.User;
import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by shdang28 on 4/3/17.
 */
public class SarahMethodTest {
    private static final int TIMEOUT = 200;
    private static UserList list = new UserList();
    private static User sarah = new User("Sarah", "pass1", AccType.BASICUSER);
    private static User ethan = new User("Ethan", "pass2", AccType.ADMIN);
    private static User ethan2 = new User("Ethan", "pass6", AccType.ADMIN);
    private static User thomas = new User("Thomas", "pass3", AccType.MANAGER);
    private static User nate = new User("Nate", "pass4", AccType.WORKER);
    private static User wesley = new User("Wesley", "pass5", AccType.WORKER);
    private static User insung = new User("Insung", "pass2", AccType.BASICUSER);

    @Test(timeout = TIMEOUT)
    public void testAddUser() {
        list.addUser(sarah);
        list.addUser(ethan);
        list.addUser(thomas);
        list.addUser(nate);
        list.addUser(wesley);
        list.addUser(insung);

        // test if users are there
        assertEquals(list.getUser("Sarah"), sarah);
        assertEquals(list.getUser("Ethan"), ethan);
        assertEquals(list.getUser("Thomas"), thomas);
        assertEquals(list.getUser("Nate"), nate);
        assertEquals(list.getUser("Wesley"), wesley);
        assertEquals(list.getUser("Insung"), insung);
    }

    @Test
    public void addDuplicate() {
        list.addUser(sarah);
        list.addUser(sarah);
        list.addUser(insung);
        list.addUser(insung);

        assertEquals(list.getUser("Sarah"), sarah);
        assertEquals(list.getUser("Insung"), insung);
    }

    @Test
    public void addSameName() {
        list.addUser(ethan);
        list.addUser(ethan2);

        assertEquals(list.getUser("Ethan"), ethan);
        assertEquals(list.getUser("Ethan"), ethan2);
    }

    @Test
    public void nameNotAdded() {
        assertEquals(list.getUser("Chandler"), null);
    }
}
