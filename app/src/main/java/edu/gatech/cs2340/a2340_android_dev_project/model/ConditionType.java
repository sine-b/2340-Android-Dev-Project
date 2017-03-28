package edu.gatech.cs2340.a2340_android_dev_project.model;

/**
 * Enumeration that defines water conditions for purity reports
 */
public enum ConditionType {
    SAFE("Safe"), TREATABLE("Treatable"), UNSAFE("Unsafe");

    private String rep;

    ConditionType(String rep) {
        this.rep = rep;
    }

    @Override
    public String toString() {
        return rep;
    }
}
