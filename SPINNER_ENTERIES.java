package com.gmail.peeman34.eglisaofficial;

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


    public class SPINNER_ENTERIES extends Activity {

        public SPINNER_ENTERIES(Context ourContext) {
            OurContext = ourContext;
        }


        public static final String KEYROWID ="id" ;
        public static final String  CHURCHNAME ="CHURCHNAME";
        public static final String  COUNTRY= "COUNTRY";

        public static final String DATABASENAME = "churchregistry_db";
        public static final String TABLENAME = "churchregistry_table";
        public static final int DATABASEVERSION = 1;

        private DbHelper OurChurchHelper;
        private final Context OurContext;
        private SQLiteDatabase OurDatabase ;


        private static class DbHelper extends SQLiteOpenHelper {

            public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
                super(context, name, factory, version);
            }

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL("CREATE TABLE " + TABLENAME + "(" + KEYROWID + "INTEGER PRIMARY KEY AUTOINCREMENT,"  + CHURCHNAME + "TEXT NOT NULL" + COUNTRY  + "TEXT NOT NULL );");
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
        public SPINNER_ENTERIES open(){
            OurChurchHelper = new DbHelper(OurContext, DATABASENAME , pee, DATABASEVERSION );
            OurDatabase = OurChurchHelper.getWritableDatabase();
            return this;

        }
        public void close (){
            OurChurchHelper.close();
        }
        public  long createEntery (String churcname, String country){
            ContentValues cv = new ContentValues();
            cv.put(CHURCHNAME, churcname );
            cv.put(COUNTRY, country);
             return  OurDatabase.insert(TABLENAME, null, cv);

        }}
