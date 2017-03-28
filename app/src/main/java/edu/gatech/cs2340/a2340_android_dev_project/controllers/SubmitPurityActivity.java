package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReport;
import edu.gatech.cs2340.a2340_android_dev_project.model.ConditionType;
import edu.gatech.cs2340.a2340_android_dev_project.model.Report;

/**
 * Activity that handles submitting purity reports
 */
public class SubmitPurityActivity extends AppCompatActivity {
    private Spinner conditionSpinner;
    private boolean locationSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_purity);

        // set up condition spinner
        conditionSpinner = (Spinner) findViewById(R.id.conditionSpinner);
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

        // event handler for the submit button
        Button submitReportButton = (Button) findViewById(R.id.submitPurityButton);
        submitReportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitReportButtonPressed(view);
            }
        });

    }

    /**
     * Function for the select location button's onClick method.
     * Sends the user to a map screen where they can tap the location
     * of a water source.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onSelectLocationButtonPressed(View v) {
        Intent intent = new Intent(this, SelectLocationActivity.class);
        startActivity(intent);

        locationSelected = true;

        Button button = (Button) findViewById(R.id.locationSelecterButton);
        button.setText("Ok!");
    }

    /**
     * Function for the submit report button's onClick method.
     * Creates a new report from the entered information and
     * adds it to the report list. Once done, the user is sent
     * back to the main screen.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onSubmitReportButtonPressed(View v) {

        EditText virusNumber = (EditText) findViewById(R.id.virusNum);
        EditText contaminantNumber = (EditText) findViewById(R.id.contaminantNum);

        int virusNum = (int) Integer.parseInt(virusNumber.getText().toString());
        int contaminantNum = (int) Integer.parseInt(contaminantNumber.getText().toString());

        if (!locationSelected) {
            Toast error = Toast.makeText(getApplicationContext(), "You need to select a location first", Toast.LENGTH_SHORT);
            error.show();
        } else {
            PurityReport newReport = new PurityReport();
            newReport.setLocation(SelectLocationActivity.getLocation());
            newReport.setVirusNumber(virusNum);
            newReport.setContaminantNumber(contaminantNum);
            newReport.setConditionType((ConditionType) conditionSpinner.getSelectedItem());

            MainActivity.purityReportList.addReport(newReport);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
