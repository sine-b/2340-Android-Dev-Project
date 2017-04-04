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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;;
import com.google.firebase.database.ValueEventListener;

import edu.gatech.cs2340.a2340_android_dev_project.model.UserList;
import edu.gatech.cs2340.a2340_android_dev_project.model.AccType;

/**
 * Activity that handles registering new users. Also holds the userList refered to
 * by the LoginActivity.
 */
public class RegisterActivity extends AppCompatActivity {
    private DatabaseReference dataUserList = WelcomeActivity.getDatabase().getReference("userList");
    private static UserList userList;
    private Spinner type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // set up spinner, associate with AccType enum
        type = (Spinner) findViewById(R.id.registertype);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,
                AccType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
        type.setSelection(AccType.BASICUSER.ordinal());

        // event handler for register button
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterButtonPressed(view);
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
     * Function for the register button's onClick method. Registers
     * a user to the user list and then logs you in
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onRegisterButtonPressed(View v) {
        EditText username = (EditText) findViewById(R.id.registerUser);
        EditText password = (EditText) findViewById(R.id.registerPass);

        userList.addUser(username.getText().toString(), password.getText().toString(),
                (AccType)type.getSelectedItem());
        MainActivity.setUser(userList.getUser(username.getText().toString()));
        MainActivity.setUserList(userList);
        dataUserList.setValue(userList);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
