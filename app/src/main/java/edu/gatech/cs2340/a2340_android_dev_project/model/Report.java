package edu.gatech.cs2340.a2340_android_dev_project.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Class that specifies the attributes a Report can have and
 * defines getters and setters for each.
 */
public class Report {
    private String date;
    private int id;
    private String reporter;
    private LatLng location;
    private WaterType type;
    private WaterCondition condition;

    /**
     * Gets the date, in MMDDYYYY format, this
     * report was created.
     *
     * @return a string representation of the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the self-generated ID of the report,
     * in ascending order starting with zero.
     *
     * @return the integer ID of this report
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the name of the user who created
     * the report.
     *
     * @return the person who made this report
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * Returns the location of the report, in LatLng
     *
     * @return a LatLng of the report's location
     */
    public LatLng getLocation() {
        return location;
    }

    /**
     * Returns an enum value describing the type
     * of water source the report details.
     *
     * @return a WaterType value corresponding to the source type
     */
    public WaterType getType() {
        return type;
    }

    /**
     * Returns an enum value describing the condition
     * of the water source the report details.
     *
     * @return a WaterCondition value corresponding to the source condition
     */
    public WaterCondition getCondition() {
        return condition;
    }

    /**
     * Sets the date to the specified date. While the default
     * date is in MMDDYYYY format, this method will accept
     * any string.
     *
     * @param date the String date will be set to
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Sets the ID to the specified int. The system automatically
     * assigns each report an ID, but it can be manually changed here.
     *
     * @param id the int the report's id will be set to
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the name of the reported to the specified String. The system
     * assigns this by username at time of report creation.
     *
     * @param reporter the new name that will be attached to the report
     */
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    /**
     * Sets the location of the report to the specified LatLng.
     *
     * @param location the new location of the report, in LatLng
     */
    public void setLocation(LatLng location) {
        this.location = location;
    }

    /**
     * Sets the type of water source.
     *
     * @param type the WaterType value that describes the type of water source.
     */
    public void setType(WaterType type) {
        this.type = type;
    }

    /**
     * Sets the condition of water source.
     *
     * @param condition the WaterCondition value that describes the type of water source.
     */
    public void setCondition(WaterCondition condition) {
        this.condition = condition;
    }

    public void setContaminantNumber(int contaminantNumber) {}
    public void setVirusNumber(int virusNumber) {}

    @Override
    public String toString() {
        return id + " - " + type + ", " + condition;
    }
}
