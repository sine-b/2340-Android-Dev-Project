package edu.gatech.cs2340.a2340_android_dev_project.model;

import org.junit.Test;
import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReport;
import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReportList;
import edu.gatech.cs2340.a2340_android_dev_project.controllers.MainActivity;

import static org.junit.Assert.*;

/**
 * Created by Ethan Dam.
 */
public class PurityReportListTest {
    PurityReportList reportList = new PurityReportList();
    PurityReport report1 = new PurityReport();
    PurityReport report2 = new PurityReport();
    PurityReport report3 = new PurityReport();

    @Test
    public void testAddReport() {
        reportList.addReport(report1);
        reportList.addReport(report2);
        reportList.addReport(report3);

        assertEquals(reportList.getReport(0), report1);
        assertEquals(reportList.getReport(1), report2);
        assertEquals(reportList.getReport(2), report3);
    }

    @Test
    public void testAddDupe() {
        reportList.addReport(report1);
        reportList.addReport(report1);

        assertEquals(reportList.getReport(0), report1);
    }

    @Test
    public void notExist() {
        reportList.addReport(report1);

        assertNotEquals(reportList.getReport(0), report2);
    }

}