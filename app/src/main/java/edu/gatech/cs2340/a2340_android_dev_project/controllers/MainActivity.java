package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.a2340_android_dev_project.model.User;

public class MainActivity extends AppCompatActivity {

    public static User user;
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
    }

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
}
