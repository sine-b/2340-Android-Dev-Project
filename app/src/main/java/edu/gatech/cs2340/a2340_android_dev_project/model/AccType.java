package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.io.Serializable;

/**
 * Handles the different accounts the user can have currently has no restrictions
 */
public enum AccType implements Serializable {
    BASICUSER("Basic User"), WORKER("Worker"), MANAGER("Manager"), ADMIN("Admin");

    private String value;

    AccType(String value) {
        this.value = value;
    }

    /**
     * Returns the string representation of an account type.
     *
     * @return the string representation of this enum value
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
