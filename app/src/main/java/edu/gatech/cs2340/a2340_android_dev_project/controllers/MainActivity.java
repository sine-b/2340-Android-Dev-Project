package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
}
