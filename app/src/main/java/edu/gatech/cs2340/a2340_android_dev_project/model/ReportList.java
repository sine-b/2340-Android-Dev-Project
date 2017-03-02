package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.util.ArrayList;

public class ReportList {

    ArrayList<Report> reportList = new ArrayList<>();
    int idCounter = 0;

    public void addReport(Report report) {
        report.setId(idCounter);
        reportList.add(report);
        idCounter++;
    }

    public Report[] getReports() {
        Report[] reportArray = new Report[reportList.size()];
        for (int i = 0; i < reportArray.length; i++) {
            reportArray[i] = reportList.get(i);
        }
        return reportArray;
    }

}
