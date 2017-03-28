package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import edu.gatech.cs2340.a2340_android_dev_project.model.Report;
import edu.gatech.cs2340.a2340_android_dev_project.model.ConditionType;
public class SubmitPurityActivity extends AppCompatActivity {
    private Spinner conditionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_purity);

        // set up condition spinner
        conditionSpinner = (Spinner) findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ConditionType.values());
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditionSpinner.setAdapter(typeAdapter);
        conditionSpinner.setSelection(ConditionType.SAFE.ordinal());

        // event handler for the select location button
        Button selectLocationButton = (Button) findViewById(R.id.locationSelecterButton);
        selectLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectLocationButtonPressed(view);
            }
        });
    }
}
