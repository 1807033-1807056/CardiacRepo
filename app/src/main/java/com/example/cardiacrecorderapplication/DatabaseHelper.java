package com.example.cardiacrecorderapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String Database_Name="CardiacArrest";
    public  static  final String Table_Name="Record_Table1";
    public static final String Name="Name";
    public static final String Phone="Contact_number";
    public static final String Date ="Date";
    public static final String Time="Time";
    public static final String Systolic ="Systolic";
    public static final String Diastolic ="Diastolic";
    public static final String HeartRate="HeartRate";
    public static final String Age="Age";
    public static final String Comment="Comment";
    private SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_Name,null, 3);
        this.db = db;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table " + Table_Name + "(Name text, Contact_number text, Date text, Time Text, Systolic Text, Diastolic Text, HeartRate Text, Age Text, Comment Text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table if exists " + Table_Name + "";
        db.execSQL(query);
        onCreate(db);
    }
    public  void AddRecord(Record record)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(Name, record.getName());
        contentValues.put(Phone, record.getContactNumber());
        contentValues.put(Date,record.getDate().toString());
        contentValues.put(Time,record.getTime().toString());
        contentValues.put(Systolic,record.getSystolic());
        contentValues.put(Diastolic,record.getDiastolic());
        contentValues.put(Age, record.getAge());
        contentValues.put(Comment,record.getComment());
        contentValues.put(HeartRate,record.getHeart_Rate());


        SQLiteDatabase database=this.getWritableDatabase();
        database.insert(Table_Name, null, contentValues);
        database.close();


    }


    public ArrayList<Record> fetchAlldata()
    {

        ArrayList<Record>arrayList=new ArrayList<Record>();

        SQLiteDatabase database=this.getReadableDatabase();

        Cursor cursor=database.rawQuery("Select * from Record_Table1 ",null);
        if(cursor.moveToFirst())
        {
            do {
                Record record=new Record();
                record.setName(cursor.getString(0));
                record.setContactNumber(cursor.getString(1));
                record.setDate(cursor.getString(2));
                record.setTime(cursor.getString(3));
                record.setSystolic(cursor.getString(4));
                record.setDiastolic(cursor.getString(5));
                record.setAge(cursor.getString(7));
                record.setHeart_Rate(cursor.getString(6));
                record.setComment(cursor.getString(8));
                arrayList.add(record);
            }

            while (cursor.moveToNext());
        }


        return arrayList;
    }

    public void DeleteData(String Datee, String Timee)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_Name,"Time=? and Date=?", new String[]{Timee,Datee});
        db.close();
    }

}


