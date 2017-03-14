package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import edu.gatech.cs2340.a2340_android_dev_project.model.Report;

import static edu.gatech.cs2340.a2340_android_dev_project.controllers.R.layout.activity_report_details;

public class ListReportActivity extends AppCompatActivity {

    private ListView reportListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_report);

        // set up list view
        reportListView = (ListView) findViewById(R.id.reportListView);
        ArrayAdapter<String> listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.reportList.getReportList());
        reportListView.setAdapter(listAdapter);

        // event handler for report on list
        reportListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ReportDetailsActivity.setReport(MainActivity.reportList.getReportList().get(position));
                onReportPressed(view);

            }
        });
    }

    public void onReportPressed(View v) {
        Intent intent = new Intent(this, ReportDetailsActivity.class);
        startActivity(intent);
    }
}
