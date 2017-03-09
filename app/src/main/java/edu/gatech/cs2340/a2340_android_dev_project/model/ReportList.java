package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import edu.gatech.cs2340.a2340_android_dev_project.controllers.RegisterActivity;

public class ReportList {

    ArrayList<Report> reportList = new ArrayList<>();
    int idCounter = 0;

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

    /**
     * Returns an array of the Reports in the
     * ReportList. For use with ArrayAdapters.
     *
     * @return array of ReportList's reports
     */
    public Report[] getReports() {
        Report[] reportArray = new Report[reportList.size()];
        for (int i = 0; i < reportArray.length; i++) {
            reportArray[i] = reportList.get(i);
        }
        return reportArray;
    }

}
