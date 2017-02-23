package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.io.Serializable;

/**
 * Created by wes on 2/21/2017.
 */

public enum AccType implements Serializable {
    WORKER("Worker"), MANAGER("Manager"), ADMIN("Admin");
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
