package com.example.antariksh.mydatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.antariksh.mydatabase.database.MyDatabase;

public class MainActivity extends AppCompatActivity {
    MyDatabase mdb= new MyDatabase(this);
    Cursor cursor;
    SimpleCursorAdapter sca;
    EditText etName, etAddress, etSalary;
    Button btnInsert;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName=findViewById(R.id.editTextName);
        etAddress=findViewById(R.id.editTextAddress);
        etSalary=findViewById(R.id.editTextSalary);
        lv=findViewById(R.id.listViewEmployee);
        mdb.open();
        btnInsert=findViewById(R.id.buttonInsert);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                String stName=etName.getText().toString();
                String stAddress=etAddress.getText().toString();
                Integer salary=Integer.parseInt(etSalary.getText().toString());

                ContentValues cv=new ContentValues();
                cv.put("emp_name",stName);
                cv.put("emp_location",stAddress);
                cv.put("emp_salary",salary);

                mdb.insertEmp(cv);
                etName.setText(null);
                etAddress.setText(null);
                etSalary.setText(null);
                cursor.requery();
            }
        });
        cursor=mdb.getEmp();
        String[] dbRef= {"emp_name","emp_location","emp_salary"};
        int[] tvRef={R.id.textViewName,R.id.textViewAddress,R.id.textViewSalary};
        sca=new SimpleCursorAdapter(this,R.layout.row,cursor,dbRef,tvRef);
        lv.setAdapter(sca);
        sca.notifyDataSetChanged();
        cursor.requery();
    }
}
