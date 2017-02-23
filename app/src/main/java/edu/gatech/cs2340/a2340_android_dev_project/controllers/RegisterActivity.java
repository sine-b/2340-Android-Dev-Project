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

import edu.gatech.cs2340.a2340_android_dev_project.controllers.LoginActivity;
import edu.gatech.cs2340.a2340_android_dev_project.model.User;
import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;
import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;

public class RegisterActivity extends AppCompatActivity {
    public static UserList userList = new UserList();
    Spinner type;
    public static User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        type = (Spinner) findViewById(R.id.registertype);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, AccType.values());
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter2);
        type.setSelection(AccType.WORKER.ordinal());
        // event handler for register button
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterButtonPressed(view);
            }
        });
    }
    public static UserList getUserList() {
        return userList;
    }
    /**
     * Function for the register button's onClick method. Registers
     * a user to the user list and then logs you in
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onRegisterButtonPressed(View v) {
        EditText username = (EditText) findViewById(R.id.registerUser);
        EditText password = (EditText) findViewById(R.id.registerPass);

        userList.addUser(username.getText().toString(), password.getText().toString(), (AccType)type.getSelectedItem());
        user = userList.getUser(username.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
