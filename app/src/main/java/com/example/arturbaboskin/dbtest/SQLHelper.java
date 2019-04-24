package com.example.arturbaboskin.dbtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "students.db";
    public static final int DB_VERSION = 1;

    public static final String STUDENT_TABLE = "students";
    public static final String STUDENT_NAME = "name";
    public static final String STUDENT_AGE = "age";

    public static final String CREATE_STUDENT_TABLE =
            "CREATE TABLE " + STUDENT_TABLE +
                    " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    STUDENT_NAME + " VARCHAR(255), " +
                    STUDENT_AGE + " INTEGER)";

    public SQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
