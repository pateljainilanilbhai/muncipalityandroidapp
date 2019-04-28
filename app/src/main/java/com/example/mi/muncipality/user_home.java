package com.example.mi.muncipality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class user_home extends AppCompatActivity {
    Button btn7,btn8,btn9,btn10,btn11,btn12,btnuselgo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        btn7 = (Button) findViewById(R.id.button3);

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(user_home.this, complaint.class);
                startActivity(intent);
            }
        });
        btnuselgo = (Button) findViewById(R.id.button2);

        btnuselgo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(user_home.this, MainActivity.class);
                startActivity(intent);
            }
        });




        btn9 = (Button) findViewById(R.id.btnstatus);
        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(user_home.this, status.class);
                startActivity(intent);
            }
        });

        btn10 = (Button) findViewById(R.id.btnwithdraw);

        btn10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(user_home.this, Withrawn.class);
                startActivity(intent);
            }
        });



        btn12 = (Button) findViewById(R.id.btnnewconn);

        btn12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(user_home.this, new_connection.class);
                startActivity(intent);
            }
        });


    }
    }

