package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signInButton = (Button) findViewById(R.id.signIn);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignInButtonPressed();
            }
        });
    }

    public void onSignInButtonPressed() {

        EditText username = (EditText) findViewById(R.id.loginUser);
        EditText password = (EditText) findViewById(R.id.loginPass);
        if (username.getText().toString().equals("user") && password.getText().toString().equals("pass")) {
            Toast success = Toast.makeText(getApplicationContext(), "Ok!", Toast.LENGTH_SHORT);
            success.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast fail = Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_SHORT);
            fail.show();
        }
    }
}
