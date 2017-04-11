package edu.gatech.cs2340.a2340_android_dev_project.model;

import org.junit.Test;
import edu.gatech.cs2340.a2340_android_dev_project.model.Report;
import edu.gatech.cs2340.a2340_android_dev_project.model.ReportList;
import edu.gatech.cs2340.a2340_android_dev_project.controllers.MainActivity;

import static org.junit.Assert.*;

/**
 * Created by Thomas on 4/10/2017.
 */

public class ReportListTest {
    ReportList reports = new ReportList();
    Report report_one = new Report();
    Report report_two = new Report();
    Report report_three = new Report();
    Report report_four = new Report();

    @Test
    public void testAddReport() {
        reports.addReport(report_one);
        reports.addReport(report_two);
        reports.addReport(report_three);
        reports.addReport(report_four);

        assertEquals(reports.getReport(0), report_one);
        assertEquals(reports.getReport(1), report_two);
        assertEquals(reports.getReport(2), report_three);
        assertEquals(reports.getReport(3), report_four);
    }

    @Test
    public void testAddDuplicate() {
        reports.addReport(report_one);
        reports.addReport(report_one);

        assertEquals(reports.getReport(0), report_one);
    }

    @Test
    public void testDoesNotExist() {
        reports.addReport(report_one);

        assertNotEquals(reports.getReport(0), report_two);
    }
}
