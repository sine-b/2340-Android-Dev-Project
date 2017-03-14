package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import edu.gatech.cs2340.a2340_android_dev_project.controllers.RegisterActivity;

/**
 * Class that defines methods for and stores the current list of reports.
 * Utilizes an ArrayList to hold the reports.
 */
public class ReportList {
    ArrayList<Report> reportList = new ArrayList<>();
    int idCounter = 0;

    /**
     * Returns the ArrayList that holds the current
     * reports. Accessed by MapsActivity.
     *
     * @return an ArrayList of all current reports
     */
    public ArrayList<Report> getReportList() {
        return reportList;
    }

    /**
     * Adds a new report to the ReportList with a
     * system-assigned id
     *
     * @param report the Report to be added
     */
    public void addReport(Report report) {
        report.setId(idCounter);
        report.setReporter(RegisterActivity.user.getUser());
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm");
        Date date = new Date();
        report.setDate(dateFormat.format(date));
        reportList.add(report);
        idCounter++;
    }
}
