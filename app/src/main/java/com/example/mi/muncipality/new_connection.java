package com.example.mi.muncipality;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class new_connection extends AppCompatActivity {
    Button btn22,btncan1;
    helpnewconnec d1 = new helpnewconnec(this);
    EditText name,contact,discription;
    SQLiteDatabase db1;
    Cursor cursor;
    int id=0;
    Spinner type;

    String[] typ = {
            "water",
            "electricity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_connection);

        type = (Spinner) findViewById(R.id.reglist);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,typ);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        type.setAdapter(adapter);
        type.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = type.getSelectedItemPosition();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                    }
                }
        );

        btn22 = (Button) findViewById(R.id.regpost1);
        btn22.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                EditText con = (EditText) findViewById(R.id.regnum);
                final String number = con.getText().toString();

                if (!isValidnumber(number)  && view.getId() == R.id.regpost1) {

                    con.setError("invalid phone");

                }
                else {

                    name = (EditText) findViewById(R.id.regtxt);
                    contact = (EditText) findViewById(R.id.regnum);
                    discription = (EditText) findViewById(R.id.regdesc);
                    type = (Spinner) findViewById(R.id.reglist);
                    String n = name.getText().toString();
                    String d = discription.getText().toString();
                    String t = type.getSelectedItem().toString();
                    String c = contact.getText().toString();



                    d1.insertnewconnection(n, c, t, d, "unknown");
                    cursor=d1.selectAllnew();
                    id++;
                    Toast.makeText(getApplicationContext(), "your new register id  " + id, Toast.LENGTH_LONG).show();
                    Toast.makeText(getBaseContext(), "your Registation successfully", Toast.LENGTH_LONG).show();

                }


            }
        });
        btncan1 = (Button) findViewById(R.id.regcancle);

        btncan1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(new_connection.this, user_home.class);
                startActivity(intent);
            }
        });

    }

    private boolean isValidnumber(String number){

        if (number.length()!=10) {
            return false;
        } else {
            return android.util.Patterns.PHONE.matcher(number).matches();
        }
    }

}

