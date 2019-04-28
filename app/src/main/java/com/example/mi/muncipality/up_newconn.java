package com.example.mi.muncipality;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class up_newconn extends AppCompatActivity {
    int from_Where_I_Am_Coming = 0;
    private helpnewconnec mydb;
    Cursor rs;
    TextView name,con,dis,newpty,status;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_newconn);

        name = (TextView) findViewById(R.id.txtstaname);
        con = (TextView) findViewById(R.id.txtstacontact);
        dis = (TextView) findViewById(R.id.txtstadis);
        newpty = (TextView) findViewById(R.id.txtstatype);
        status = (TextView) findViewById(R.id.txtstastatus);

        mydb = new helpnewconnec(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");

            if (Value > 0) {
                //means this is the view part not the add contact part.
                rs = mydb.getDatanew(Value);
                id_To_Update = Value;
                rs.moveToFirst();


                String cont = rs.getString(rs.getColumnIndex(helpnewconnec.COMPLAINT_COLUMN_CONTACTNONEW));
                String type = rs.getString(rs.getColumnIndex(helpnewconnec.COMPLAINT_COLUMN_NEWTY));
                String statu = rs.getString(rs.getColumnIndex(helpnewconnec.COMPLAINT_COLUMN_STATUSNEW));
                String des=rs.getString(rs.getColumnIndex(helpnewconnec.COMPLAINT_COLUMN_DISCRIPTIONNEW));
                String namu = rs.getString(rs.getColumnIndex(helpnewconnec.COMPLAINT_COLUMN_NAMENEW));
                if (!rs.isClosed()) {
                    rs.close();
                }
                name.setText((CharSequence) namu);
                con.setText((CharSequence) cont);

                dis.setText((CharSequence) des);
                newpty.setText((CharSequence) type);
                status.setText((CharSequence)statu);
            }



        }
    }

    public void run(View view)
    {
        Bundle extras = getIntent().getExtras();
        if(extras !=null)
        {
            int Value = extras.getInt("id");
            if(Value>0){
                if(mydb.updatenewconnection(id_To_Update, name.getText().toString(), con.getText().toString(), newpty.getText().toString(), dis.getText().toString() ,status.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),admin_home.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                if(mydb.insertnewconnection(name.getText().toString(), con.getText().toString(), newpty.getText().toString(), dis.getText().toString(), "unknown-admin")){
                    Toast.makeText(getApplicationContext(), "registered", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "not registered", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),admin_home.class);
                startActivity(intent);
            }
        }

        Button btnupnca = (Button) findViewById(R.id.btncancel);

        btnupnca.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(up_newconn.this, admin_home.class);
                startActivity(intent);
            }
        });
    }

    }

