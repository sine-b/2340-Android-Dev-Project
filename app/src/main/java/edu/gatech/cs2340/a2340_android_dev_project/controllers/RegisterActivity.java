package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // event handler for register button
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegisterButtonPressed(view);
            }
        });
    }

    /**
     * Function for the register button's onClick method. Pops
     * a toast message saying registration isn't available yet.
     *
     * @param v the view the OnClickListener belongs to
     */
    public void onRegisterButtonPressed(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "This doesn't work yet", Toast.LENGTH_SHORT);
        toast.show();
    }

}
