package com.example.mi.muncipality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class database extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        Button btn7 = (Button) findViewById(R.id.dbmanagebutton);

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(database.this, compaintdbv.class);
                startActivity(intent);
            }
        });

        Button btn8 = (Button) findViewById(R.id.dbnewbtn);

        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(database.this, new_connectiondbv.class);
                startActivity(intent);
            }
        });
    }
}
