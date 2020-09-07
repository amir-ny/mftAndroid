package com.example.mftandroidproject;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public static final int DBVersion=1;
    public static String DBName = "mftContactsDataBase";
    private static String tableName = "contacts";
    public static String col_contactId = "contact_id";
    public static String col_firstName = "first_name";
    public static String col_lastName = "last_name";
    public static String col_mobile="mobile";
    public static String col_email="email";
    public static String col_address="address";

    public ContactHelper(Context context ){
        super(context,DBName,null,DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = " CREATE TABLE IF NOT EXISTS "+tableName+" ( "+col_contactId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+col_firstName+" VARCHAR(30), "+col_lastName+" VARCHAR(30), "
                +col_mobile+" VARCHAR(11), "+col_email+" VARCHAR(30), "+col_address+" VARCHAR(300) );";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName + ";");
        onCreate(sqLiteDatabase);
    }

    public Cursor selectAll(){
        db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+tableName,null);
    }

    public Cursor select(int id){
        db=getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+tableName,null);
    }

    public void update(int id,Contact contact){

    }

    public void delete(int id){

    }

    public void insert(Contact contact){

    }

    public void search(String name){

    }
}
