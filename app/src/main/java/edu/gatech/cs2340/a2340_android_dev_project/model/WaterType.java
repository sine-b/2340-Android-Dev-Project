package edu.gatech.cs2340.a2340_android_dev_project.model;

/**
 * Enumeration that defines possible values for a report's source type
 */
public enum WaterType {

    BOTTLED("Bottled"), WELL("Well"), STREAM("Stream"), LAKE("Lake"), SPRING("Spring"), OTHER("Other");

    private String rep;

    WaterType(String rep) {
        this.rep = rep;
    }

    @Override
    public String toString() {
        return rep;
    }

}
