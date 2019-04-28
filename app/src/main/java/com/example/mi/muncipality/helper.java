package com.example.mi.muncipality;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class helper extends SQLiteOpenHelper  {
    public static final String DATABASE_NAME = "Mysystem.db";
    public static final String COMPLAINT_TABLE_NAME = "complaintreg";
    public static final String COMPLAINT_COLUMN_ID = "id";
    public static final String COMPLAINT_COLUMN_NAME = "name";
    public static final String COMPLAINT_COLUMN_CONTACTNO = "contactno";
    public static final String COMPLAINT_COLUMN_COMPTY = "complainttyp";
    public static final String COMPLAINT_COLUMN_DISCRIPTION = "discription";
    public static final String COMPLAINT_COLUMN_STATUS = "status";
    private HashMap hp;

    public helper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table complaintreg " +
                        "(id integer primary key autoincrement, name text,contactno number,complainttyp text,discription char(20),status text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS complaintreg");
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


    public boolean insertcomplaint  (String name, String contact,String complainttyp,String discrip,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contactno", contact);
        contentValues.put("complainttyp", complainttyp);
        contentValues.put("discription", discrip);
        contentValues.put("status","stage-1");
        db.insert("complaintreg", null, contentValues);

        return true;
    }

    public Cursor selectAll() {
        Cursor cursor;
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT id FROM " +COMPLAINT_TABLE_NAME;
        System.out.println(query);
        cursor = db.rawQuery(query, null);

        cursor.moveToFirst();
        return cursor;

    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from complaintreg where id=" + id + "", null);
        return res;
    }

    public Cursor getstatus(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select status from complaintreg where id=" + id + "", null );
        return res;
    }

    public Cursor getname(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from complaintreg where name like "+name+"", null );
        return res;
    }

    public Cursor getidfromname(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select name from complaintreg where name="+name+"", null );
        return res;
    }


    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, COMPLAINT_TABLE_NAME);
        return numRows;
    }

    public boolean updatecomplaint (Integer id, String name, String contact,String complainttyp,String discrip,String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contactno", contact);
        contentValues.put("compltyp", complainttyp);
        contentValues.put("discription", discrip);
        contentValues.put("status",status);
        db.update("complaintreg", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deletecomplaint (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("complaintreg",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAll()
    {
        Cursor res;
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        res =  db.rawQuery( "select * from complaintreg", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COMPLAINT_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}




