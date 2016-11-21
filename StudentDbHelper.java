package com.example.pustikom.adapterplay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pustikom.adapterplay.StudentContract.StudentEntry;
import com.example.pustikom.adapterplay.com.example.pustikom.user.Student;


/**
 * Created by M. FACHRIZAL on 11/11/2016.
 */

public class StudentDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = StudentDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "student.db";

    private static final int DATABASE_VERSION = 1;

    public StudentDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //public StudentDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        //super(context, name, factory, version);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_STUDENT_TABLE =  "CREATE TABLE " + StudentEntry.TABLE_NAME + " ("
                + StudentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StudentEntry.COLUMN_STUDENT_Noreg + " TEXT NOT NULL, "
                + StudentEntry.COLUMN_STUDENT_Nama + " TEXT NOT NULL, "
                + StudentEntry.COLUMN_STUDENT_Email + " TEXT NOT NULL, "
                + StudentEntry.COLUMN_STUDENT_Phone + " TEXT NOT NULL;"
                + StudentEntry.COLUMN_STUDENT_Gender + " INTEGER NOT NULL, ";

    }

    public void insertStudent(SQLiteDatabase db, Student student) {
        ContentValues values = new ContentValues();
        values.put(StudentEntry.COLUMN_STUDENT_Noreg, student.getNoreg());
        values.put(StudentEntry.COLUMN_STUDENT_Nama, student.getName());
        values.put(StudentEntry.COLUMN_STUDENT_Email, student.getMail());
        values.put(StudentEntry.COLUMN_STUDENT_Phone, student.getPhone());
        values.put(StudentEntry.COLUMN_STUDENT_Gender, student.getPhone());
        db.insert(StudentEntry.TABLE_NAME, null, values);
    }


    public void UpdateStudent(SQLiteDatabase db, Student student){
        ContentValues values = new ContentValues();
        values.put(StudentEntry.COLUMN_STUDENT_Noreg, student.getNoreg());
        values.put(StudentEntry.COLUMN_STUDENT_Nama, student.getName());
        values.put(StudentEntry.COLUMN_STUDENT_Email, student.getMail());
        values.put(StudentEntry.COLUMN_STUDENT_Phone, student.getPhone());
        values.put(StudentEntry.COLUMN_STUDENT_Gender, student.getGender());

// Which row to update, based on the title
        String selection = StudentEntry.COLUMN_STUDENT_Noreg + " LIKE ?";
        String[] selectionArgs = { "update" };

        int count = db.update(StudentEntry.TABLE_NAME, values, selection, selectionArgs);
    }
    public void fetchStudent(SQLiteDatabase db, Student student){
        String[] projection = {
                StudentEntry._ID,
                StudentEntry.COLUMN_STUDENT_Nama,
                StudentEntry.COLUMN_STUDENT_Nama,
                StudentEntry.COLUMN_STUDENT_Email,
                StudentEntry.COLUMN_STUDENT_Phone,
                StudentEntry.COLUMN_STUDENT_Gender
        };

// Filter results WHERE "title" = 'My Title'
        String selection = StudentEntry.COLUMN_STUDENT_Noreg + " = ?";
        String[] selectionArgs = { "read" };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                StudentEntry.COLUMN_STUDENT_Noreg + " DESC";

        Cursor c = db.query(StudentEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
    }
    public void deleteStudent(SQLiteDatabase db, Student student) {
        String selection = StudentEntry.COLUMN_STUDENT_Noreg + " LIKE ?";
        String[] selectionArgs = { "delete" };
        db.delete(StudentEntry.TABLE_NAME, selection, selectionArgs);
    }
    public void truncateStudent(SQLiteDatabase db, Student student){
        db.delete(StudentEntry.TABLE_NAME, null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
