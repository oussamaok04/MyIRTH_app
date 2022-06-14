package com.example.irth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.heirs.Deceased;
import com.example.heirs.Heir;

import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "DbHeritage.db";


    public DBHelper(@Nullable Context context) {
        super(context, "DbHeritage.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (username TEXT primary key, password TEXT)");
        db.execSQL("create table deceased (legacy TEXT, gender TEXT)");
        db.execSQL("create table heir (heirtype TEXT,heirnb NUMBER, inheritedvalue NUMBER, blocked BOOLEAN, blockreason TEXT)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists user");
        db.execSQL("drop Table if exists deceased");
        db.execSQL("drop Table if exists heir");
    }

    public boolean adddeceased(Deceased deceased){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("legacy", deceased.getLegacy());
        cv.put("gender", deceased.getGender());
        long insertd = db.insert("deceased", null, cv);
        if (insertd == -1)
            return false;
        else
            return true;
    }

    public boolean addheirs(Heir heir){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("heirtype", heir.getheirtype());
        cv.put("heirnb", heir.getHeirnb());
        cv.put("blocked", heir.isBlocked());
        cv.put("inheritedvalue", heir.getinheritedvalue());

        long inserth = db.insert("heirs", null, cv);

        if (inserth == -1)
            return false;
        else
            return true;
    }


    public Boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = db.insert("users", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }


    public Boolean checkusername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }


    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
