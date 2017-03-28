package edu.gatech.cs2340.a2340_android_dev_project.model;

/**
 * Enumeration that defines water conditions for purity reports
 */
public enum ConditionType {
    SAFE("SAFE"), TREATABLE("TREATABLE"), UNSAFE("UNSAFE");

    private String rep;

    ConditionType(String rep) {
        this.rep = rep;
    }

    @Override
    public String toString() {
        return rep;
    }
}
