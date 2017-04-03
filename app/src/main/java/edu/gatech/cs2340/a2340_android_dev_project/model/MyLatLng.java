package edu.gatech.cs2340.a2340_android_dev_project.model;

/**
 * Creating a bootleg version of Google Maps' LatLng class, because apparently
 * Google forgot to write a constructor that takes no arguments.
 */
public class MyLatLng {

    private double latitude;
    private double longitude;

    public MyLatLng() {}

    public MyLatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns the latitude at this
     * MyLatLng
     *
     * @return numerical latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of this MyLatLng to
     * a new value.
     *
     * @param latitude new latitude value
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Returns the longitude at this
     * MyLatLng
     *
     * @return numerical longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of this MyLatLng to
     * a new value.
     *
     * @param longitude new longitude value
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
