package com.example.project_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;

    EditText editName,editsurname,editMarks;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editTextName);
        editsurname = (EditText)findViewById(R.id.editTextSurname);
        editMarks = (EditText)findViewById(R.id.editTextMarks);
        btnAdd = (Button)findViewById(R.id.btn_save);

        AddData();
    }

    public void AddData(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = db.insertData(editName.getText().toString(),editsurname.getText().toString(),editMarks.getText().toString());
                if(isInserted =true)
                    Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }
}
