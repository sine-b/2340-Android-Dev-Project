package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReport;

public class PurityDetailsActivity extends AppCompatActivity {
    private static PurityReport report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_details);

        TextView purityDate = (TextView) findViewById(R.id.purityDate);
        TextView purityId = (TextView) findViewById(R.id.purityID);
        TextView purityWorker = (TextView) findViewById(R.id.purityWorker);
        TextView purityCondition = (TextView) findViewById(R.id.purityCondition);
        TextView purityVirus = (TextView) findViewById(R.id.purityVirus);
        TextView purityContaminant = (TextView) findViewById(R.id.purityContaminant);

        purityDate.setText(report.getDate());
        purityId.setText("" + report.getId());
        purityWorker.setText(report.getReporter());
        purityCondition.setText(report.getConditionType().toString());
        purityVirus.setText("" + report.getVirus());
        purityContaminant.setText("" + report.getContaminant());

        Button purityDone = (Button) findViewById(R.id.purityDone);
        purityDone.setOnClickListener(new View.OnClickListener() {
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
    public static void setReport(PurityReport r) {
        report = r;
    }

}
