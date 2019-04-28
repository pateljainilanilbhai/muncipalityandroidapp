package com.example.mi.muncipality;

/**
 * Created by MI on 5/10/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class helpnewconnec extends SQLiteOpenHelper   {
    public static final String DATABASE_NAME = "Mysystem1.db";
    public static final String COMPLAINT_TABLE_NAMENEW = "newreg";
    public static final String COMPLAINT_COLUMN_IDNEW = "id";
    public static final String COMPLAINT_COLUMN_NAMENEW = "name";
    public static final String COMPLAINT_COLUMN_CONTACTNONEW = "contactno";
    public static final String COMPLAINT_COLUMN_NEWTY = "newtyp";
    public static final String COMPLAINT_COLUMN_DISCRIPTIONNEW = "discription";
    public static final String COMPLAINT_COLUMN_STATUSNEW = "status";
    private HashMap hp;

    public helpnewconnec(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table newreg " +
                        "(id integer primary key autoincrement, name text,contactno number,newtyp text,discription char(20),status text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS newreg");
        onCreate(db);
    }

   /* public String getSinlgeEntry(String userName)
    {   SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor=db.query("complaint", null, " id=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("id"));
        cursor.close();
        return password;
    }*/


    public boolean insertnewconnection  (String name, String contact,String newtyp,String discrip,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contactno", contact);
        contentValues.put("newtyp", newtyp);
        contentValues.put("discription", discrip);
        contentValues.put("status","stage-1");
        db.insert("newreg", null, contentValues);

        return true;
    }

    public Cursor selectAllnew() {
        Cursor cursor;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT id FROM " +COMPLAINT_TABLE_NAMENEW;
        System.out.println(query);
        cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        return cursor;

    }

    public Cursor getDatanew(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from newreg where id=" + id + "", null);
        return res;
    }

    public Cursor getstatusfornew(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select status from newreg where id=" + id + "", null );
        return res;
    }

    public Cursor getname(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from newreg where name like "+name+"", null );
        return res;
    }

    public Cursor getidfromnamenew(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select name from newreg where name="+name+"", null );
        return res;
    }


    public int numberOfRowsnew(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, COMPLAINT_TABLE_NAMENEW);
        return numRows;
    }

    public boolean updatenewconnection (Integer id, String name, String contact,String newtyp,String discrip,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contactno", contact);
        contentValues.put("newtyp", newtyp);
        contentValues.put("discription", discrip);
        contentValues.put("status",status);
        db.update("newreg", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deletenewconnection (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("newreg",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAll()
    {
        Cursor res;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        res =  db.rawQuery( "select * from newreg", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COMPLAINT_COLUMN_NAMENEW)));
            res.moveToNext();
        }
        return array_list;
    }
}
