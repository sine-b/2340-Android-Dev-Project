package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.a2340_android_dev_project.model.Report;

/**
 * Activity that displays detailed information about a report. Another activity
 * sets its report attribute and then this activity displays more information about
 * it.
 */
public class ReportDetailsActivity extends AppCompatActivity {
    private static Report report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_details);

        TextView dateReported = (TextView) findViewById(R.id.dateReported);
        TextView reportId = (TextView) findViewById(R.id.reportID);
        TextView reportedBy = (TextView) findViewById(R.id.reportedBy);
        TextView sourceType = (TextView) findViewById(R.id.sourceType);
        TextView sourceCondition = (TextView) findViewById(R.id.sourceCondition);

        dateReported.setText(report.getDate());
        reportId.setText("" + report.getId());
        reportedBy.setText(report.getReporter());
        sourceType.setText(report.getType().toString());
        sourceCondition.setText(report.getCondition().toString());

        Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    /**
     * Sets this activity's report to the one specified.
     * Acts as a means for MapsActivity and ListReportActivity
     * to "pass in" the report that is tapped.
     *
     * @param r the report whose information is to be displayed
     */
    public static void setReport(Report r) {
        report = r;
    }

}
