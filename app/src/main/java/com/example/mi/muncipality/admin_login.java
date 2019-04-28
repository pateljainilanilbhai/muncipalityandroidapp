package com.example.mi.muncipality;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class admin_login extends AppCompatActivity {
    EditText s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        s1=(EditText)findViewById(R.id.adminemaileditText3);
        s2=(EditText)findViewById(R.id.adminpass);

        final String userName=s1.getText().toString();
        final String password=s2.getText().toString();

        Button btn = (Button) findViewById(R.id.addminlogin);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(admin_login.this, admin_home.class);
                startActivity(intent);

            }
        });
    }
    }

