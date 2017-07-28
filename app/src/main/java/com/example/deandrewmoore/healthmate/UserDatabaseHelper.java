package com.example.deandrewmoore.healthmate;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;
import static android.R.attr.version;
import static com.example.deandrewmoore.healthmate.R.string.email;
import static com.example.deandrewmoore.healthmate.R.string.gender;

/**
 * Created by Deandrew Moore on 15/7/2017.
 */

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Client.db";
    public static final String TABLE_NAME = "client_table";
    public static final int DATABASE_VERSION = 2;
    public static final String UID = "_id";
    public static final String NAME = "Name";
    public static final String EMAIL = "Email";
    public static final String NUMBER = "Number";
    public static final String GENDER = "Gender";
    public static final String AGE = "Age";
    public static final String PRESSURE = "Pressure";
    public static final String CHOLESTEROL = "Cholesterol";
    public static final String SUGAR = "Sugar";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + EMAIL + " VARCHAR(255), " + NUMBER + " VARCHAR(255), " + GENDER + " VARCHAR(255), " + AGE + " VARCHAR(255), " + PRESSURE + " VARCHAR(255), " + CHOLESTEROL + " VARCHAR(255), " + SUGAR + " VARCHAR(255));";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME + "";

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public boolean insertData(String name, String email, String number, String gender, String age, String pressure, String cholesterol, String sugar) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(EMAIL,email);
        contentValues.put(NUMBER,number);
        contentValues.put(GENDER,gender);
        contentValues.put(AGE,age);
        contentValues.put(PRESSURE,pressure);
        contentValues.put(CHOLESTEROL,cholesterol);
        contentValues.put(SUGAR,sugar);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}