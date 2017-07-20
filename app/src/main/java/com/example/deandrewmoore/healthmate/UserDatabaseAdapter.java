package com.example.deandrewmoore.healthmate;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;
import static com.example.deandrewmoore.healthmate.R.string.email;
import static com.example.deandrewmoore.healthmate.R.string.gender;

/**
 * Created by Deandrew Moore on 15/7/2017.
 */

public class UserDatabaseAdapter {

    UserHelper helper;
    public UserDatabaseAdapter(Context context) {
        helper = new UserHelper(context);
    }
    public long insertData(String name, String email, String number, String gender, String age, String pressure, String cholesterol, String sugar) {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserHelper.NAME,name);
        contentValues.put(UserHelper.EMAIL,email);
        contentValues.put(UserHelper.NUMBER,number);
        contentValues.put(UserHelper.GENDER,gender);
        contentValues.put(UserHelper.AGE,age);
        contentValues.put(UserHelper.PRESSURE,pressure);
        contentValues.put(UserHelper.CHOLESTEROL,cholesterol);
        contentValues.put(UserHelper.SUGAR,sugar);
        long id=db.insert(UserHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    static class UserHelper  extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "clientdatabase";
        private static final String TABLE_NAME = "CLIENTTABLE";
        private static final int DATABASE_VERSION = 11;
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final String EMAIL = "Email";
        private static final String NUMBER = "Number";
        private static final String GENDER = "Gender";
        private static final String AGE = "Age";
        private static final String PRESSURE = "Pressure";
        private static final String CHOLESTEROL = "Cholestorol";
        private static final String SUGAR = "Sugar";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + EMAIL + " VARCHAR(255), " + NUMBER + " VARCHAR(255), " + GENDER + " VARCHAR(255), " + AGE + " VARCHAR(255) " + PRESSURE + " VARCHAR(255), " + CHOLESTEROL + " VARCHAR(255), " + SUGAR + " VARCHAR(255);";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME + "";
        private Context context;

        public UserHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            }catch (SQLException e) {

            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (SQLException e){

            }


        }

    }

}
