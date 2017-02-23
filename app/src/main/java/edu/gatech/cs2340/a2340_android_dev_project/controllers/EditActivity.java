package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;
import edu.gatech.cs2340.a2340_android_dev_project.model.User;
import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;

/**
 * Created by wes on 2/22/2017.
 */

public class EditActivity extends AppCompatActivity {
    private EditText emailField;
    private EditText addressField;
    private EditText titleField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        emailField = (EditText) findViewById(R.id.email);
        addressField = (EditText) findViewById(R.id.address);
        titleField = (EditText) findViewById(R.id.title);
        TextView type = (TextView)findViewById(R.id.type);
        type.setText(MainActivity.user.getType().getValue());
        // event handler for register button
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveButtonPressed(view);
            }
        });
        emailField.setText(MainActivity.user.getEmail());
        addressField.setText(MainActivity.user.getAddress());
        titleField.setText(MainActivity.user.getTitle());
    }
    /**
     * Function for the register button's onClick method. Pops
     * a toast message saying registration isn't available yet.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onSaveButtonPressed(View v) {
        User user = RegisterActivity.user;

        user.setAddress(addressField.getText().toString());
        user.setEmail(emailField.getText().toString());
        user.setTitle(titleField.getText().toString());
        MainActivity.user = user;
        RegisterActivity.userList.addUser(user);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
