package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Model.Student;
import data.MyDbHandler;

public class UpdateActivity extends AppCompatActivity {

    EditText stu_id,f_name,prev_sabak,prev_sabaki, newFName, newSabak, newSabki;
    Button search_btn, name_update_btn, sabak_update_btn, sabaki_update_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        MyDbHandler db = new MyDbHandler(UpdateActivity.this);

        //Initiaze the Text Edits and Button
        stu_id=(EditText) findViewById(R.id.StudentID);
        f_name=(EditText) findViewById(R.id.FName);
        prev_sabak=(EditText) findViewById(R.id.PSabak);
        prev_sabaki=(EditText) findViewById((R.id.PSabaki));



        search_btn=(Button) findViewById(R.id.btn_search);

        name_update_btn= (Button) findViewById(R.id.up_name);
        sabak_update_btn= (Button) findViewById(R.id.up_sabak);
        sabaki_update_btn= (Button) findViewById(R.id.up_sabaki);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Student_ID=stu_id.getText().toString();

                if(!(f_name.getText().toString().equals("")))   //Field are NOT empty
                {
                    //Clear the text Fields
                    f_name.setText("");
                    prev_sabaki.setText("");
                    prev_sabaki.setText("");
                }

                if(Student_ID.equals(""))
                {
                    Toast.makeText(UpdateActivity.this, "Enter Id", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Student result=db.getData(Student_ID);

                   if(result.getName().equals(""))
                   {
                       //No Record Found
                       Toast.makeText(UpdateActivity.this, "No Record!!", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       //Record is Displayed
                       f_name.setText(result.getName());
                       prev_sabak.setText(result.getSabak());
                       prev_sabaki.setText(result.getSabki());
                   }


                }
            }
        });


        name_update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent=new Intent(getApplicationContext(),Update_Name.class);
                addIntent.putExtra("id",stu_id.getText().toString());
                startActivity(addIntent);
            }
        });

        sabak_update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent=new Intent(getApplicationContext(),Update_Sabak.class);
                addIntent.putExtra("id",stu_id.getText().toString());
                startActivity(addIntent);
            }
        });

        sabaki_update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent=new Intent(getApplicationContext(),Update_Sabaki.class);
                addIntent.putExtra("id",stu_id.getText().toString());
                startActivity(addIntent);
            }
        });


    }
}