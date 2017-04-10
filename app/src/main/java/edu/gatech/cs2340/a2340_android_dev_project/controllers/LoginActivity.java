package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;

/**
 * Activity that handles the login procedure. Capable of validating
 * users as well as displaying an error for incorrect logins.
 */
public class LoginActivity extends AppCompatActivity {
    private DatabaseReference dataUserList = WelcomeActivity.getDatabase().getReference("userList");
    private static UserList userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // event handler for sign in button
        Button signInButton = (Button) findViewById(R.id.loginButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignInButtonPressed(view);
            }
        });

        // reads in the userList
        dataUserList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userList = dataSnapshot.getValue(UserList.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast toast = Toast.makeText(getApplicationContext(), "Couldn't get the data...",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    /**
     * Function for the sign in button's onClick method. Validates
     * the login credentials (which have been hardcoded here for now)
     * and switches to the main activity if they're right. Otherwise,
     * displays a toast message saying the credentials were invalid.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onSignInButtonPressed(View v) {
        EditText username = (EditText) findViewById(R.id.loginUser);
        EditText password = (EditText) findViewById(R.id.loginPass);

        if (userList.authenticate(username.getText().toString(), password.getText().toString())) {
            MainActivity.setUser(userList.getUser(username.getText().toString()));
            MainActivity.setUserList(userList);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast fail = Toast.makeText(getApplicationContext(), "Invalid Username/Password",
                    Toast.LENGTH_SHORT);
            fail.show();
        }
    }
}
