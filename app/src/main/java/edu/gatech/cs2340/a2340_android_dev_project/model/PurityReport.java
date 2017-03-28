package edu.gatech.cs2340.a2340_android_dev_project.model;

import com.google.android.gms.maps.model.LatLng;

public class PurityReport extends Report {
    private String date;
    private int id;
    private String reporter;
    private LatLng location;
    private int virusNumber;
    private int contaminantNumber;
    private ConditionType conditionType;

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
     * Gets the virus PPM
     *
     * @return the virus PPM
     */
    public int getVirus() {
        return virusNumber;
    }

    /**
     * Gets the contaminant PPM
     *
     * @return the contaminant PPM
     */
    public int getContaminant() {
        return contaminantNumber;
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
     * Returns a string representation of the
     * water source's condition type
     *
     * @return the condition type of the water
     */
    public ConditionType getConditionType() {
        return conditionType;
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
     * Sets the virus PPM
     *
     * @param virusNumber the virus PPM
     */
    public void setVirusNumber(int virusNumber) {
        this.virusNumber = virusNumber;
    }

    /**
     * Sets the contaminant PPM
     *
     * @param contaminantNumber the contaminant PPM
     */
    public void setContaminantNumber(int contaminantNumber) {
        this.contaminantNumber = contaminantNumber;
    }

    /**
     * Sets the condition type of the water
     *
     * @param conditionType the current condition of the water
     */
    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }

    @Override
    public String toString() {
        return id + " - " + conditionType + ", " + "Virus PPM: " + virusNumber + "Contaminant PPM: " + contaminantNumber;
    }
}
