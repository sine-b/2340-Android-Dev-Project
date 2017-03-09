package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListReportActivity extends AppCompatActivity {

    private ListView reportListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_report);

        // set up list view
        reportListView = (ListView) findViewById(R.id.reportListView);
        ArrayAdapter<String> listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.reportList.getReports());
        reportListView.setAdapter(listAdapter);

        // event handler for report on list
        reportListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
