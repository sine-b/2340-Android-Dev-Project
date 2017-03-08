package edu.gatech.cs2340.a2340_android_dev_project.model;


import java.util.Date;

public class Report {

    private Date date;
    private int id;
    private User reporter;
    private double latitude;
    private double longitude;
    private WaterType type;
    private WaterCondition condition;

    /**
     * Getter for Date object. Returns the Date
     * tied to this Report
     *
     * @return the Date that belongs to this report
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter for id attribute. Returns the id
     * tied to this Report
     *
     * @return the id that belongs to this report
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for reporter name. Returns the reporter
     * tied to this Report
     *
     * @return the reporter that belongs to this report
     */
    public User getReporter() {
        return reporter;
    }

    /**
     * Getter for the latitude attribute. Returns the latitude
     * tied to this Report
     *
     * @return the latitude that belongs to this report
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Getter for the longitude attribute. Returns the longitude
     * tied to this Report
     *
     * @return the longitude that belongs to this report
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Getter for the type property. Returns the WaterType
     * tied to this Report
     *
     * @return the WaterType that belongs to this report
     */
    public WaterType getType() {
        return type;
    }

    /**
     * Getter for condition property. Returns the WaterCondition
     * tied to this Report
     *
     * @return the WaterCondition that belongs to this report
     */
    public WaterCondition getCondition() {
        return condition;
    }

    /**
     * Setter for Date object. Sets the Date
     * associated with this Report
     *
     * @param date the Date the report is changed to
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Setter for id object. Sets the id
     * associated with this Report
     *
     * @param id the id the report is changed to
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for reporter attribute. Sets the reporter
     * associated with this Report
     *
     * @param reporter the name of the reporter the report is changed to
     */
    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    /**
     * Setter for latitude property. Sets the latitude
     * associated with this Report
     *
     * @param latitude the latitude the report is changed to
     */
    public void setLatitude(double latitude) {
        this.latitude  = latitude;
    }

    /**
     * Setter for longitude property. Sets the longitude
     * associated with this Report
     *
     * @param longitude the longitude the report is changed to
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Setter for type property. Sets the WaterType
     * associated with this Report
     *
     * @param type the WaterType value the report is changed to
     */
    public void setType(WaterType type) {
        this.type = type;
    }

    /**
     * Setter for condition property. Sets the WaterCondition
     * associated with this Report
     *
     * @param condition the WaterCondition value the report is changed to
     */
    public void setCondition(WaterCondition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return id + " - " + type + ", " + condition;
    }

}
