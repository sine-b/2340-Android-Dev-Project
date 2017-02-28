package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.io.Serializable;

/**
 *
 * Handles the differnt accounts the user can have currently has no restrictions
 */

public enum AccType implements Serializable {
    BASICUSER("Basic User"), WORKER("Worker"), MANAGER("Manager"), ADMIN("Admin");
    private String value;

    AccType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
