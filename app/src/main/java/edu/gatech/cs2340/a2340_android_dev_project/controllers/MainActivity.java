package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;
import edu.gatech.cs2340.a2340_android_dev_project.model.ReportList;
import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReportList;
import edu.gatech.cs2340.a2340_android_dev_project.model.User;
import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;

/**
 * Activity that acts as a hub to all of the app's functions. Mainly provides
 * button links to other activities, but stores the current user and report list
 * for other purposes as well.
 */
public class MainActivity extends AppCompatActivity {
    private static User user;
    private static UserList userList;
    private static ReportList reportList = new ReportList();
    private static PurityReportList purityReportList = new PurityReportList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        if (user.getType().equals(AccType.WORKER) || user.getType().equals(AccType.MANAGER)) {
            Intent intent = new Intent(this, ListChoiceActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, ListReportActivity.class);
            startActivity(intent);
        }
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

    /**
     * Gets the user held by this activity.
     *
     * @return the current user in session
     */
    public static User getUser() {
        return user;
    }

    /**
     * Sets the new user in session by altering
     * this activity's user parameter.
     *
     * @param newUser new user in session
     */
    public static void setUser(User newUser) {
        user = newUser;
    }

    /**
     * Gets a current copy of the userList.
     *
     * @return the current list of users registered
     */
    public static UserList getUserList() {
        return userList;
    }

    /**
     * Sets the userList for the app's reference.
     *
     * @param newUserList the current list of users registered
     */
    public static void setUserList(UserList newUserList) {
        userList = newUserList;
    }

    /**
     * Returns the current list of water reports.
     *
     * @return list of water reports
     */
    public static ReportList getReportList() {
        return reportList;
    }

    /**
     * Sets a new reportList to serve as the current
     * list of reports.
     *
     * @param newReportList new list of water reports
     */
    public static void setReportList(ReportList newReportList) {
        reportList = newReportList;
    }

    /**
     * Returns the current list of purity reports.
     *
     * @return list of purity reports
     */
    public static PurityReportList getPurityReportList() {
        return purityReportList;
    }

    /**
     * Sets a new purityReportList to serve as the
     * current list of purity reports.
     *
     * @param newPurityReportList new list of purity reports
     */
    public static void setPurityReportList(PurityReportList newPurityReportList) {
        purityReportList = newPurityReportList;
    }

}
