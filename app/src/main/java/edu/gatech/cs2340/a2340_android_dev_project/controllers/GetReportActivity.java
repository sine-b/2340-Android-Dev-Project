package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;
import edu.gatech.cs2340.a2340_android_dev_project.model.MyLatLng;
import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReport;
import edu.gatech.cs2340.a2340_android_dev_project.model.WaterCondition;

/**
 * Created by wes on 4/4/2017.
 */

public class GetReportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public LatLng location;
    static Spinner loc;
    static Spinner year;
    static Spinner condition;
    static ArrayList<PurityReport> pr = new ArrayList<PurityReport>();
    static String con;
    private static ArrayList<PurityReport> purityReport;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_waterreport);

        // sets the fields to the previous fields
        purityReport = MainActivity.getPurityReportList().getReportList();
        ArrayList<String> locations = new ArrayList<String>();
        String location;
        for (int i = 0; i < purityReport.size(); i++) {
            location = "Latitude: " + Math.round(purityReport.get(i).getLocation().getLatitude()) + " Longitude: " + Math.round(purityReport.get(i).getLocation().getLongitude());
            if (!locations.contains(location)) {
                locations.add(location);
            }
        }
        loc = (Spinner) findViewById(R.id.Location);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loc.setAdapter(adapter);
        loc.setSelection(AccType.BASICUSER.ordinal());

        year = (Spinner) findViewById(R.id.Year);

        condition = (Spinner) findViewById(R.id.Condition);

        // event handler initiation

        loc.setOnItemSelectedListener(this);
        Button getReport = (Button) findViewById(R.id.getReportButton);
        getReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGetReportButtonPressed(view);
            }
        });


    }

    /**
     * Function for the get report button's onClick method.
     * gets a graph with the desired data
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onGetReportButtonPressed(View v) {
        con = (String)condition.getSelectedItem();
        String location;
        for (int i = 0; i < purityReport.size(); i++) {
            location = "Latitude: " + Math.round(purityReport.get(i).getLocation().getLatitude()) + " Longitude: " + Math.round(purityReport.get(i).getLocation().getLongitude());
            if (location.equals(loc.getSelectedItem())) {
                pr.add(purityReport.get(i));
            }
        }

        Intent intent = new Intent(this, DisplayGraph.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<String> years = new ArrayList<String>();
        String location;
        for (int i = 0; i < purityReport.size(); i++) {
            location = "Latitude: " + Math.round(purityReport.get(i).getLocation().getLatitude()) + " Longitude: " + Math.round(purityReport.get(i).getLocation().getLongitude());
            if (location.equals(loc.getSelectedItem())) {
                years.add("20" + purityReport.get(i).getDate().substring(6, 8));
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(adapter);
        year.setSelection(AccType.BASICUSER.ordinal());

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"Contaminant", "Virus"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        condition.setAdapter(adapter);
        condition.setSelection(AccType.BASICUSER.ordinal());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}