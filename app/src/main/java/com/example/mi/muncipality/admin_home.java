package com.example.mi.muncipality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin_home extends AppCompatActivity {
    Button btn12,btn13,btn14,btn15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);


        btn12 = (Button) findViewById(R.id.userdatabtn);

        btn12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_home.this,database.class);
                startActivity(intent);
            }
        });

        btn13 = (Button) findViewById(R.id.adminmanagebtn);

        btn13.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_home.this, manage.class);
                startActivity(intent);
            }
        });

       btn14 = (Button) findViewById(R.id.adminlogout);

        btn14.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(admin_home.this, admin_login.class);
                startActivity(intent);
            }
        });

        btn15 = (Button) findViewById(R.id.adminbtn);

        btn15.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(admin_home.this, new_connection.class);
                startActivity(intent);
            }
        });

    }
}
