package com.example.deandrewmoore.healthmate;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static android.R.attr.name;

public class UserField extends AppCompatActivity {

    private Toolbar mToolBar;
    UserDatabaseAdapter userHelper;
    EditText fullName, email, number, gender, age, pressure, cholesterol, sugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_field);

        mToolBar= (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userHelper = new UserDatabaseAdapter(this);

        fullName = (EditText) findViewById(R.id.NameInput);
        email = (EditText) findViewById(R.id.useremail);
        number = (EditText) findViewById(R.id.usernumber);
        gender = (EditText) findViewById(R.id.usergender);
        age = (EditText) findViewById(R.id.userage);
        pressure = (EditText) findViewById(R.id.bloodpressurecount);
        cholesterol = (EditText) findViewById(R.id.cholestoral_level);
        sugar = (EditText) findViewById(R.id.bloodsugarlevel);
    }

    public void submitData(View view) {
        String full=fullName.getText().toString();
        String mail=email.getText().toString();
        String num=number.getText().toString();
        String gen=gender.getText().toString();
        String a=age.getText().toString();
        String press=pressure.getText().toString();
        String chol=cholesterol.getText().toString();
        String suga=sugar.getText().toString();

        long id = userHelper.insertData(full,mail,num,gen,a,press,chol,suga);
        if(id==0)
        {
            Message.message(this, "OOPS, Unsuccessful");
        }else {
            Message.message(this, "Great, Your Data was successfully saved");
        }

        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
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
