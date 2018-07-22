package com.example.antariksh.mydatabase.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.antariksh.mydatabase.helper.MyHelper;

public class MyDatabase {
  public static final String MY_DB="employeeDB";
  Context myCon;
  SQLiteDatabase sdb;
  MyHelper myHelper;

  public MyDatabase(Context myContext) {
    myCon = myContext;
    myHelper = new MyHelper(myCon,MY_DB,null,1);
  }
  public void open()
  {
    sdb=myHelper.getWritableDatabase();
  }

  public void insertEmp(ContentValues cv)
  {
    sdb.insert("employee",null,cv);
    Log.i("EmployeeDB","Data inserted");
  }
  public Cursor getEmp()
  {
    sdb= myHelper.getReadableDatabase();
    Cursor cursor=sdb.query("employee",null,null,null,null,null,null);
    return cursor;
  }
}

