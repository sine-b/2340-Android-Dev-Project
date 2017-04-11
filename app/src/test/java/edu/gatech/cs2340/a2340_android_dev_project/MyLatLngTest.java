package edu.gatech.cs2340.a2340_android_dev_project;

import org.junit.Test;

import edu.gatech.cs2340.a2340_android_dev_project.model.MyLatLng;

import static org.junit.Assert.assertEquals;

/**
 * Created by Wesley Ogata
 */
public class MyLatLngTest {
    private static final int TIMEOUT = 200;
    private static MyLatLng loc = new MyLatLng();
    private static MyLatLng loc2 = new MyLatLng();

    @Test
    public void testEquals() throws Exception {
        loc.setLatitude(1);
        loc.setLongitude(2);
        loc2.setLatitude(1);
        loc2.setLongitude(2);

        assertEquals(loc.equals(loc2), true);
    }

    @Test
    public void testNotEquals() throws Exception {
        loc.setLatitude(2);
        loc.setLongitude(1);
        loc2.setLatitude(1);
        loc2.setLongitude(2);
        assertEquals(loc.equals(loc2), false);
    }

    @Test
    public void testSameEquals() throws Exception {
        loc.setLatitude(1);
        loc.setLongitude(2);
        loc2.setLatitude(1);
        loc2.setLongitude(2);

        assertEquals(loc.equals(loc), true);
        assertEquals(loc2.equals(loc2), true);
    }
}