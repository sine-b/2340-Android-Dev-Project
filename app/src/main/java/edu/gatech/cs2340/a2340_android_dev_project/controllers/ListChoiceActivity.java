package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_choice);

        Button goToListReport = (Button) findViewById(R.id.reports_list);
        goToListReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGoToReportsListButtonPressed(view);
            }
        });

        Button goToPurityListReport = (Button) findViewById(R.id.purity_reports_list);
        goToPurityListReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGoToPurityReportsListButtonPressed(view);
            }
        });
    }

    /**
     * Function for the goToListReport button's onClick method.
     * Takes the worker to the report submission screen.
     *
     * @param view the view the onClickListener belongs to
     */
    public void onGoToReportsListButtonPressed(View view) {
        Intent intent = new Intent(this, ListReportActivity.class);
        startActivity(intent);
    }

    /**
     * Function for the goToPurityListReport button's onClick method.
     * Takes the worker to the purity report submission screen.
     *
     * @param view the view the onClickListener belongs to
     */
    public void onGoToPurityReportsListButtonPressed(View view) {
        Intent intent = new Intent(this, ListPurityActivity.class);
        startActivity(intent);
    }

}
