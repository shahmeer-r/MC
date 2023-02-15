package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.MyDbHandler;

public class Update_Sabaki extends AppCompatActivity {

    EditText sabaki;
    Button update_sabaki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sabaki);

        sabaki=(EditText) findViewById(R.id.UpdateSabaki);
        update_sabaki=(Button) findViewById(R.id.upName_btn);

        MyDbHandler db=new MyDbHandler(Update_Sabaki.this);
        update_sabaki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String up_sabaki=sabaki.getText().toString();

                if(up_sabaki.equals(""))
                {
                    //if ALL text field are empty
                    Toast.makeText(Update_Sabaki.this, "Provide Update Name!!", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Intent intent = getIntent();
                    if (intent != null) {
                        String student_id = intent.getStringExtra("id");

                        db.updateSabak(student_id,up_sabaki);
                        Toast.makeText(Update_Sabaki.this, "Provide Update Name!!", Toast.LENGTH_SHORT).show();

                    }

                    else {
                        Toast.makeText(Update_Sabaki.this, "Cannot Update!!!", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });


    }
}