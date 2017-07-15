package com.example.deandrewmoore.healthmate;

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

        final Button logInButton = (Button) findViewById(R.id.logInButton);
    }
    public void logIn (View view) {
        Intent intent = new Intent(this, AllergyAndDisease.class);
        startActivity(intent);
    }
}

