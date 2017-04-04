package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.gatech.cs2340.a2340_android_dev_project.model.PurityReportList;
import edu.gatech.cs2340.a2340_android_dev_project.model.ReportList;

/**
 * Activity that acts as a gateway to either login or registration. The first
 * screen the user sees when opening the app.
 */
public class WelcomeActivity extends AppCompatActivity {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // event handler for login button
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonPressed(view);
            }
        });

        // event handler for register button
        Button registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterButtonPressed(view);
            }
        });

    }

    /**
     * Function for the login button's onClick method. Switches
     * to the login activity.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onLoginButtonPressed(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Function for the register button's onClick method. Switches
     * to the register activity.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onRegisterButtonPressed(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        // does nothing so logout can't be circumvented
    }

    /**
     * Returns an instance of the app's database
     *
     * @return instance of database
     */
    public static FirebaseDatabase getDatabase() {
        return database;
    }
}
