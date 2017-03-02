package edu.gatech.cs2340.a2340_android_dev_project.model;

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
