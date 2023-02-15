package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.Student;
import data.MyDbHandler;

public class Update_Name extends AppCompatActivity {

    Button update;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_name);

        name=(EditText) findViewById(R.id.UpdatedFName);
        update=(Button) findViewById(R.id.up_name_btn);

        MyDbHandler db=new MyDbHandler(Update_Name.this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String up_name=name.getText().toString();

                if(up_name.equals(""))
                {
                    //if ALL text field are empty
                    Toast.makeText(Update_Name.this, "Provide Updated Name!!", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Intent intent = getIntent();
                    if (intent != null) {
                       String student_id = intent.getStringExtra("id");

                       db.updateName(student_id,up_name);
                        Toast.makeText(Update_Name.this, "Name Updated!!", Toast.LENGTH_SHORT).show();

                    }

                    else {
                        Toast.makeText(Update_Name.this, "Cannot Update!!!", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }
}