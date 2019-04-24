package com.example.arturbaboskin.dbtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public final class DBHelper {

    private static DBHelper instance;
    private SQLHelper dbHelper;
    private SQLiteDatabase db;

    private DBHelper(Context context) {
        dbHelper = new SQLHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public static DBHelper getInstance(Context context) {

        synchronized (DBHelper.class) {
            if (instance == null)
                instance = new DBHelper(context);
        }
        return instance;

    }

    public void addStudent(Student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLHelper.STUDENT_NAME, student.getName());
        contentValues.put(SQLHelper.STUDENT_AGE, student.getAge());
        db.insert(SQLHelper.STUDENT_TABLE, null, contentValues);
    }

    public List<Student> getStudents() {

        List<Student> result = new ArrayList<>();

        Cursor cursor = db.query(SQLHelper.STUDENT_TABLE, new String[]{"*"},
                null, null, null, null, null);

        int id = cursor.getColumnIndex("id");
        int name = cursor.getColumnIndex(SQLHelper.STUDENT_NAME);
        int age = cursor.getColumnIndex(SQLHelper.STUDENT_AGE);

        while (cursor.moveToNext())
            result.add(new Student(cursor.getInt(id),
                    cursor.getString(name),
                    cursor.getInt(age)));

        return result;
    }

}
