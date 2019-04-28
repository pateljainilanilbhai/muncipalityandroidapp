package com.example.mi.muncipality;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn,btn2,btn3;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText mailedit,passedit;
    String smail,spass;
    String mail,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            btn3 = (Button) findViewById(R.id.userloginbtn);

            btn3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
                    mailedit=(EditText)findViewById(R.id.txtusername1);
                    passedit=(EditText)findViewById(R.id.txtuserpass);
                    mail=sharedPreferences.getString("mail","aabbcc");
                    pass=sharedPreferences.getString("pass", "aabbcc");
                    Toast.makeText(getApplicationContext(), "" + mail + "  " + pass, Toast.LENGTH_SHORT).show();

                    btn3 = (Button) findViewById(R.id.userloginbtn);

                    btn3.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {


                            smail = mailedit.getText().toString();
                            spass = passedit.getText().toString();


                            if (smail.equals(mail) && spass.equals(pass)) {

                                Intent intent = new Intent(MainActivity.this, user_home.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Invalid password/mail", Toast.LENGTH_LONG).show();

                            }
                        }
                    });






                }
            });

            btn = (Button) findViewById(R.id.regbtn1);
            btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,registration.class);
                    startActivity(intent);
                }
            });

            btn2= (Button) findViewById(R.id.btnadmin);

            btn2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, admin_login.class);
                    startActivity(intent);
                }
            });

        }

    }

