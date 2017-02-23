package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.gatech.cs2340.a2340_android_dev_project.controllers.R;
import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;

public class WelcomeActivity extends AppCompatActivity {
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

}
