package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;
import edu.gatech.cs2340.a2340_android_dev_project.model.ReportList;
import edu.gatech.cs2340.a2340_android_dev_project.model.User;

/**
 * Activity that acts as a hub to all of the app's functions. Mainly provides
 * button links to other activities, but stores the current user and report list
 * for other purposes as well.
 */
public class MainActivity extends AppCompatActivity {
    // the user currently logged into the appliation
    public static User user;
    public static ReportList reportList = new ReportList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = RegisterActivity.user;

        // event handler for the sign out button
        Button signOutButton = (Button) findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignOutButtonPressed(view);
            }
        });

        // event handler for the edit profile button
        Button editProfileButton = (Button) findViewById(R.id.editProfileButton);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEditProfileButtonPressed(view);
            }
        });

        // event handler for the submit report button
        Button submitButton = (Button) findViewById(R.id.submitReportButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitButtonPressed(view);
            }
        });

        // event handler for the list report button
        Button listButton = (Button) findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onListButtonPressed(view);
            }
        });

        // event handler for the map button
        Button mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMapButtonPressed(view);
            }
        });
    }

    /**
     * Function for the edit profile button's onClick method.
     * Sends the user to the profile editing screen.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onEditProfileButtonPressed(View v) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }

    /**
     * Function for the sign out button's onClick method. Returns
     * the user to the welcome activity.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onSignOutButtonPressed(View v) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    /**
     * Function for the submit report button's onClick method. Sends
     * the user to the report submission screen.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onSubmitButtonPressed(View v) {
        if (user.getType().equals(AccType.WORKER) || user.getType().equals(AccType.MANAGER)) {
            Intent intent = new Intent(this, ReportTypeActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, SubmitReportActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Function for the list report button's onClick method. Shows
     * the user a list of submitted reports.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onListButtonPressed(View v) {
        Intent intent = new Intent(this, ListReportActivity.class);
        startActivity(intent);
    }

    /**
     * Function for the map button's onClick method. Shows
     * a map of nearby reports.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onMapButtonPressed(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // does nothing so logout feels more secure
    }

}
