package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.a2340_android_dev_project.R;

public class ReportTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_type);

        Button goToReportButton = (Button) findViewById(R.id.report_button);
        goToReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGoToReportButtonPressed(view);
            }
        });

        Button goToPurityReportButton = (Button) findViewById(R.id.purity_report_button);
        goToReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGoToPurityReportButtonPressed(view);
            }
        });

    }

    /**
     * Function for the goToReport button's onClick method.
     * Takes the worker to the report submission screen.
     *
     * @param view the view the onClickListener belongs to
     */
    public void onGoToReportButtonPressed(View view) {
        Intent intent = new Intent(this, SubmitReportActivity.class);
        startActivity(intent);
    }

    /**
     * Function for the goToPurityReport button's onClick method.
     * Takes the worker to the purity report submission screen.
     *
     * @param view the view the onClickListener belongs to
     */
    public void onGoToPurityReportButtonPressed(View view) {
        Intent intent = new Intent(this, SubmitPurityActivity.class);
        startActivity(intent);
    }

}
