package edu.gatech.cs2340.a2340_android_dev_project.model;

import java.util.LinkedList;
import java.util.List;

public class ReportList {

    List<Report> reportList = new LinkedList<>();
    int idCounter = 0;

    public void addReport(Report report) {
        report.setId(idCounter);
        reportList.add(report);
        idCounter++;
    }

    public Report[] getReports() {
        return (Report[]) reportList.toArray();
    }

}
