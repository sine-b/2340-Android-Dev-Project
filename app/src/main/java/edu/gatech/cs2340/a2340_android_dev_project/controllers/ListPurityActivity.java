package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Activity that displays a list of current purity reports, each of which can
 * be pressed to display more information about them.
 */
public class ListPurityActivity extends AppCompatActivity {
    private ListView reportListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_purity);

        // set up list view
        reportListView = (ListView) findViewById(R.id.reportListView);
        ArrayAdapter<String> listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MainActivity.purityReportList.getReportList());
        reportListView.setAdapter(listAdapter);

        // event handler for report on list
        reportListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ReportDetailsActivity.setReport(MainActivity.purityReportList.getReportList().get(position));
                onReportPressed(view);

            }
        });
    }

    /**
     * Function for each ListView item's onClick method.
     * Sends user to ReportDetailsActivity where detailed
     * information about the report they tapped is displayed.
     *
     * @param v the view the onItemClickListener belongs to
     */
    public void onReportPressed(View v) {
        Intent intent = new Intent(this, ReportDetailsActivity.class);
        startActivity(intent);
    }
}
