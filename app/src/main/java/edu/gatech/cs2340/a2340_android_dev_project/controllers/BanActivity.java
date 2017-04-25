package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import edu.gatech.cs2340.a2340_android_dev_project.model.User;


public class BanActivity extends AppCompatActivity {

    private DatabaseReference dataUserList = WelcomeActivity.getDatabase().getReference("userList");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ban);

        // event handler for ban button
        Button banButton = (Button) findViewById(R.id.banButton);
        banButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBanButtonPressed(view);
            }
        });

        // event handler for unban button
        Button unbanButton = (Button) findViewById(R.id.unbanButton);
        unbanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUnbanButtonPressed(view);
            }
        });

        // event handler for done button
        Button doneButton = (Button) findViewById(R.id.banDoneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBanDoneButtonPressed(view);
            }
        });

    }

    /**
     * Method for the ban button's onClick method. Unbans
     * the specified user if it exists and is currently
     * banned.
     *
     * @param view the view the OnClickListener belongs to
     */
    public void onBanButtonPressed(View view) {

        EditText banName = (EditText) findViewById(R.id.banName);
        String username = banName.getText().toString();
        User user = MainActivity.getUserList().getUser(username);

        if (user == null) {
            Toast toast = Toast.makeText(getApplicationContext(), "This user doesn't exist",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else if (user.getBanned()) {
            Toast toast = Toast.makeText(getApplicationContext(), "This user is banned already",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else {
            user.setBanned(true);
            Toast toast = Toast.makeText(getApplicationContext(), "The user has been banned",
                    Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    /**
     * Method for the unban button's onClick method. Unbans
     * the specified user if it exists and is currently
     * banned.
     *
     * @param view the view the OnClickListener belongs to
     */
    public void onUnbanButtonPressed(View view) {

        EditText banName = (EditText) findViewById(R.id.banName);
        String username = banName.getText().toString();
        User user = MainActivity.getUserList().getUser(username);

        if (user == null) {
            Toast toast = Toast.makeText(getApplicationContext(), "This user doesn't exist",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else if (!user.getBanned()) {
            Toast toast = Toast.makeText(getApplicationContext(), "This user has not been banned",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else {
            user.setBanned(false);
            Toast toast = Toast.makeText(getApplicationContext(), "The user has been unbanned",
                    Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    /**
     * Method for the done button's onClick method. Saves
     * changes to the database and goes back to the main
     * activity.
     *
     * @param view the view the onClickListener belongs to
     */
    public void onBanDoneButtonPressed(View view) {

        dataUserList.setValue(MainActivity.getUserList());
        onBackPressed();

    }

}
