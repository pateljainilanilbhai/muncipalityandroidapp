package com.example.mi.muncipality;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class up_complaint extends AppCompatActivity {
    int from_Where_I_Am_Coming = 0;
    private helper mydb;
    Cursor rs;
    TextView name1,con1,dis1,compty1,status1;
    int id_To_Update = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_complaint);

        name1 = (TextView) findViewById(R.id.txtupcomname);
        con1 = (TextView) findViewById(R.id.txtupcomcontact);
        dis1 = (TextView) findViewById(R.id.txtupcomdesc);
        compty1 = (TextView) findViewById(R.id.txtupcomtype);
        status1 = (TextView) findViewById(R.id.txtupcomstatus);

        mydb = new helper(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int Value = extras.getInt("id");

            if (Value > 0) {
                //means this is the view part not the add contact part.
                rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();


                String contcon = rs.getString(rs.getColumnIndex(helper.COMPLAINT_COLUMN_CONTACTNO));
                String typecon = rs.getString(rs.getColumnIndex(helper.COMPLAINT_COLUMN_COMPTY));
                String statucon = rs.getString(rs.getColumnIndex(helper.COMPLAINT_COLUMN_STATUS));
                String descon=rs.getString(rs.getColumnIndex(helper.COMPLAINT_COLUMN_DISCRIPTION));
                String namucon = rs.getString(rs.getColumnIndex(helper.COMPLAINT_COLUMN_NAME));
                if (!rs.isClosed()) {
                    rs.close();
                }

                name1.setText((CharSequence) namucon);
                con1.setText((CharSequence) contcon);
                dis1.setText((CharSequence) descon);
                compty1.setText((CharSequence) typecon);
                status1.setText((CharSequence)statucon);
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
                if(mydb.updatecomplaint(id_To_Update, name1.getText().toString(), con1.getText().toString(), compty1.getText().toString(), dis1.getText().toString() ,status1.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),admin_home.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "not Updated", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                if(mydb.insertcomplaint(name1.getText().toString(), con1.getText().toString(), compty1.getText().toString(), dis1.getText().toString(), "unknown-admin")){
                    Toast.makeText(getApplicationContext(), "registered", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "not registered", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),admin_home.class);
                startActivity(intent);
            }
        }
       Button btnupca = (Button) findViewById(R.id.btnupcancel);

        btnupca.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(up_complaint.this, admin_home.class);
                startActivity(intent);
            }
        });
    }
    }
