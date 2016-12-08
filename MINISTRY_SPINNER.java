package com.gmail.peeman34.eglisaofficial;

/**
 * Created by pee on 7/27/2016.
 */

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

/**
 * Created by pee on 1/21/2016.
 */


public class MINISTRY_SPINNER extends Activity {

    private DbHelper OurMinistryHelper;

    public MINISTRY_SPINNER(Context ourContext) {
        OurContext = ourContext;
    }


    public static final String KEYROWID ="id" ;
    public static final String  MINISTRYNAME ="CHURCHNAME";


    public static final String DATABASENAME = "eglisadatabase";
    public static final String TABLENAME = "ministry_table";
    public static final int DATABASEVERSION = 1;
    private final Context OurContext;
    private SQLiteDatabase OurDatabase ;


    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLENAME + "(" + KEYROWID + "INTEGER PRIMARY KEY AUTOINCREMENT,"  + MINISTRYNAME + "TEXT NOT NULL);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXIST" + TABLENAME);
        }
    }
    SQLiteDatabase.CursorFactory pee = new SQLiteDatabase.CursorFactory() {
        @Override
        public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
            return null;
        }
    };
    public void open(){
        OurMinistryHelper = new DbHelper(OurContext, DATABASENAME , pee, DATABASEVERSION );
        OurDatabase = OurMinistryHelper.getWritableDatabase();


    }
    public void close (){
        OurMinistryHelper.close();
    }
    public  long createEntery (String ministry){
        ContentValues cv = new ContentValues();
        cv.put(MINISTRYNAME, ministry );

        return  OurDatabase.insert(TABLENAME, null, cv);

    }}
