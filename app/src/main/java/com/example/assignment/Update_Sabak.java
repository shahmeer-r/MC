package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import data.MyDbHandler;

public class Update_Sabak extends AppCompatActivity {

    EditText sabak;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sabak);

        sabak=(EditText) findViewById(R.id.UpdateSabak);
        update=(Button) findViewById(R.id.upName_btn);

        MyDbHandler db=new MyDbHandler(Update_Sabak.this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String up_sabak=sabak.getText().toString();

                if(up_sabak.equals(""))
                {
                    //if ALL text field are empty
                    Toast.makeText(Update_Sabak.this, "Provide Update Sabak!!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = getIntent();
                    if (intent != null)
                    {
                        String student_id = intent.getStringExtra("id");

                        db.updateSabaki(student_id,up_sabak);
                        Toast.makeText(Update_Sabak.this, "Provide Update Name!!", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(Update_Sabak.this, "Cannot Update!!!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

}