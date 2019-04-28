package com.example.mi.muncipality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class manage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        Button btn21 = (Button) findViewById(R.id.btncomup);

        btn21.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(manage.this, compaintdbv.class);
                startActivity(intent);
            }
        });

        Button btn22 = (Button) findViewById(R.id.btnnewconnup);

        btn22.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(manage.this, new_connectiondbv.class);
                startActivity(intent);
            }
        });


    }


    }
