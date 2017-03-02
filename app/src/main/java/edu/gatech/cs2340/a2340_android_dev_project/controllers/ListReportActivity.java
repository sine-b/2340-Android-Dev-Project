package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListReportActivity extends AppCompatActivity {

    ListView reportListView = (ListView) findViewById(R.id.reportListView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_report);


    }
}
