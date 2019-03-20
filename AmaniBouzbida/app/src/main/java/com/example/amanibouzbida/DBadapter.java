package com.example.amanibouzbida;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBadapter extends SQLiteOpenHelper {

    public DBadapter(Context context)
    {
        super(context," AmaniBouzbida",null,1);
    }

    public void onCreate(SQLiteDatabase db) {
        String creatTable="create table masrouf(id integer primary key,achat text ,prix float, date text)";
        db.execSQL(creatTable); }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable=("drop table if exists masrouf ");
        db.execSQL(deleteTable);
        onCreate(db); }

    public void ajoutdepense(expanse e){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("achat",e.getNom());
        contentValues.put("prix",e.getMontant());
        contentValues.put("date",e.getDate());
        db.insert("masrouf",null,contentValues);

    }

    public ArrayList<expanse> liste(){
        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM masrouf";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<expanse> depenses=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                expanse e=new expanse(cursor.getString(1),cursor.getFloat(2),cursor.getString(3),cursor.getInt(0));


                depenses.add(e); }
            while(cursor.moveToNext()); }
        return depenses;}

    public void remove(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("masrouf","id="+Integer.toString(id),null);}

         public Float sum()
        {

            SQLiteDatabase db=getReadableDatabase();
            String selectall="SELECT * FROM masrouf";
            Cursor cursor= db.rawQuery(selectall,null);

            ArrayList<expanse> depenses=new ArrayList<>();
            Float total =0f ;
            if (cursor.moveToFirst()){
                do{
                   total+=cursor.getFloat(2);
                    }
                while(cursor.moveToNext());
            }

            return total ;}



}
