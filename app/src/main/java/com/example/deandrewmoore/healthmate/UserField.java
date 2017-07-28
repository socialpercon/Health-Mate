package com.example.deandrewmoore.healthmate;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.id;

public class UserField extends AppCompatActivity {

    private Toolbar mToolBar;
    UserDatabaseHelper userDb   ;
    EditText fullName, email, number, gender, age, pressure, cholesterol, sugar;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_field);

        mToolBar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userDb = new UserDatabaseHelper(this);

        fullName = (EditText) findViewById(R.id.NameInput);
        email = (EditText) findViewById(R.id.useremail);
        number = (EditText) findViewById(R.id.usernumber);
        gender = (EditText) findViewById(R.id.usergender);
        age = (EditText) findViewById(R.id.userage);
        pressure = (EditText) findViewById(R.id.bloodpressurecount);
        cholesterol = (EditText) findViewById(R.id.cholestoral_level);
        sugar = (EditText) findViewById(R.id.bloodsugarlevel);
        submitBtn = (Button) findViewById(R.id.submitbtn);
        submitData ();
    }

    public void submitData () {
        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = userDb.insertData(fullName.getText().toString(), email.getText().toString(), number.getText().toString(),
                                gender.getText().toString(),age.getText().toString(), pressure.getText().toString(), cholesterol.getText().toString(),
                                sugar.getText().toString() );

                        if (isInserted = true)
                            Message.message(UserField.this, "Great, Your Data was saved.");
                        else
                            Message.message(UserField.this, "OOPS, something went wrong!");

                        Intent intent = new Intent(UserField.this, Results.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**Handle app bar item clicks here. The app bar will automatically handle clicks on the Home
         * /Up Button, so as long as you specify a parent activity in Android Manifest.xml
         */

        int id = item.getItemId();

        if (id == android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
