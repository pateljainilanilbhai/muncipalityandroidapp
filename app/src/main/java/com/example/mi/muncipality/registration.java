package com.example.mi.muncipality;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registration extends AppCompatActivity {

    EditText name, mail, pass, address;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        name = (EditText) findViewById(R.id.regisname);
        mail = (EditText) findViewById(R.id.regismail);
        pass = (EditText) findViewById(R.id.regispass);
        address = (EditText) findViewById(R.id.regisadd);


        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btn5 = (Button) findViewById(R.id.regisbtn1);
        btn5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                final String password = pass.getText().toString();
                final String email = mail.getText().toString();
                if (!isValidEmail(email) && !isValidPassword(password)) {
                    mail.setError("invalid email");
                    pass.setError("need 8 characters");
                }
                else {


                    String m = mail.getText().toString();

                    String p = pass.getText().toString();
                    editor.putString("mail", m);
                    editor.putString("pass", p);
                    editor.commit();
                    Intent i = new Intent(registration.this, MainActivity.class);

                    startActivity(i);

                }
            }
        });
    }
    private boolean isValidEmail(String email){
        String EMAIL_PATTERN="^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String pwd){
        if (pwd !=null && pwd.length()<=8){
            return true;
        }
        return false;
    }

}

