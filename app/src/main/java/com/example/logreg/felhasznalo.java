package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class felhasznalo extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "felhasznalo.db";    //ADATBÁZIS FILE NEVE
    public static final String TABLE_NAME = "felhasznalo";           //TÁBLA NEVE

    public static final String COL_1 = "ID";                //Első oszlop
    public static final String COL_2 = "EMAIL";        //Második oszlop
    public static final String COL_3 = "FELHNEV";        //Harmadik oszlop
    public static final String COL_4 = "JELSZO";              //Negyedik oszlop
    public static final String COL_5 = "TELJESNEV";              //Ötödik oszlop
//Konstruktór létrehozása

    public felhasznalo(@Nullable Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, FELHNEV TEXT, JELSZO TEXT, TELJESNEV TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //Adat felvétel

    public boolean adatRogzites(String email, String felhnev, String jelszo, String teljesnev)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, felhnev);
        contentValues.put(COL_4, jelszo);
        contentValues.put(COL_4, teljesnev);

        long eredmeny = database.insert(TABLE_NAME, null, contentValues);

        if (eredmeny == -1)
            return false;       //sikertelen felvétel esetén false eredményt kapunk
        else
            return true;        //sikeres felvétel esetén true eredményt kapunk
    }

    //Adat lekérdezés

    public Cursor adatLekerdezes()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor eredmeny = database.rawQuery("SELECT * from " + TABLE_NAME, null);
        return eredmeny;
    }
/*
    public long adatTorles(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME, COL_1+" = ?", new String[] {String.valueOf(id)});
    }

    public long adatModosit(String id, String email, String felhnev, String jelszo, String teljesnev){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, email);
        values.put(COL_3, felhnev);
        values.put(COL_4, jelszo);
        values.put(COL_4, teljesnev);
        return database.update(TABLE_NAME, values, COL_1 + " = ?", new String[] {id});
    }*/

    public boolean bejEllenorzes(String Felhasznalonev, String Jelszo){
        String[] columns = {COL_1};
        SQLiteDatabase db = getReadableDatabase();
        String kivalasztas = COL_3 + "=?" + " and " + COL_4 + "=?";
        String[] kivalasztArgs = {Felhasznalonev, Jelszo};
        Cursor cursor = db.query(TABLE_NAME, columns, kivalasztas, kivalasztArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return false;
    }


}
