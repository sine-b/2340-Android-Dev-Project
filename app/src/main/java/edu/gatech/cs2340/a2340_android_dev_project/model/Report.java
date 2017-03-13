package edu.gatech.cs2340.a2340_android_dev_project.model;


import com.google.android.gms.maps.model.LatLng;

import java.util.Date;

public class Report {

    private String date;
    private int id;
    private String reporter;
    private LatLng location;
    private WaterType type;
    private WaterCondition condition;

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getReporter() {
        return reporter;
    }

    public LatLng getLocation() {
        return location;
    }

    public WaterType getType() {
        return type;
    }

    public WaterCondition getCondition() {
        return condition;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public void setLocation(LatLng location) {
        this.location = location;
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
