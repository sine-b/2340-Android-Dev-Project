package edu.gatech.cs2340.a2340_android_dev_project.model;


import java.util.Date;

public class Report {

    private Date date;
    private int id;
    private User reporter;
    private double latitude;
    private double longitude;
    private WaterType type;
    private WaterCondition condition;

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public User getReporter() {
        return reporter;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public WaterType getType() {
        return type;
    }

    public WaterCondition getCondition() {
        return condition;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public void setLatitude(double latitude) {
        this.latitude  = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setType(WaterType type) {
        this.type = type;
    }

    public void setCondition(WaterCondition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return id + " - " + type + ", " + condition;
    }

}
