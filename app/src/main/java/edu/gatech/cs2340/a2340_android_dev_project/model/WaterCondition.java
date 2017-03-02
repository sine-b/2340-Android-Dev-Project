package edu.gatech.cs2340.a2340_android_dev_project.model;



public enum WaterCondition {

    WASTE("Waste"), TREATABLECLEAR("Treatable-Clear"), TREATABLEMUDDY("Treatable-Muddy"), POTABLE("Potable");

    private String rep;

    WaterCondition(String rep) {
        this.rep = rep;
    }

    @Override
    public String toString() {
        return rep;
    }

}
