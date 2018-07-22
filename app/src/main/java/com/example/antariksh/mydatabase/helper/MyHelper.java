package com.example.antariksh.mydatabase.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Here we create our table for the database
    db.execSQL("create table employee(_id integer primary key, emp_name text, emp_location text, emp_salary integer );");
    Log.i("EmployeeDB","Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
