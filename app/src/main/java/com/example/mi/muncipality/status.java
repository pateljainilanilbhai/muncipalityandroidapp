package com.example.mi.muncipality;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class status extends AppCompatActivity {
    TextView status;

    helper d1;
    SQLiteDatabase sqLiteDatabase;
    EditText search_id;
    Button btn, btn1,btnstcan;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        status = (TextView) findViewById(R.id.sttxtview);
        search_id = (EditText) findViewById(R.id.statustxt);
        status.setVisibility(View.GONE);

        Button btn = (Button) findViewById(R.id.statusbtn1);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String s=search_id.getText().toString();
                int sa=new Integer(s).intValue();
                d1 = new helper(getApplicationContext());
                sqLiteDatabase = d1.getWritableDatabase();
                Cursor cursor = d1.getstatus(sa);
                if (cursor.moveToFirst()) {
                    String sta = cursor.getString(0);
                    status.setText(sta);
                    status.setVisibility(v.VISIBLE);



                }


            }


        });
        btnstcan = (Button) findViewById(R.id.statusbtn2);

        btnstcan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(status.this,user_home.class);
                startActivity(intent);
            }
        });




    }
}
