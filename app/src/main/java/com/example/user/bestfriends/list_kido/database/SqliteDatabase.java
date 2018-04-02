package com.example.user.bestfriends.list_kido.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.bestfriends.list_kido.Person;

import java.util.ArrayList;
import java.util.List;

public class SqliteDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "person";
    private static final String TABLE_PERSONS = "persons";

    private static final String COLUMN_ID = "_id";
//    private static final String COLUMN_PERSONPHOTO = "photo";
    private static final String COLUMN_PERSONNAME = "personname";

    public SqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "CREATE TABLE "
                + TABLE_PERSONS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
//                + COLUMN_PERSONPHOTO + " INTEGER,"
                + COLUMN_PERSONNAME + " TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSONS);
        onCreate(db);
    }

    public List<Person> listPerson() {
        String sql = "select * from " + TABLE_PERSONS;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Person> storePerson = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
//                int photo = Integer.parseInt(cursor.getString(2));
                storePerson.add(new Person(id, name));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storePerson;
    }

    public void addPerson(Person person){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PERSONNAME, person.getPersonName());
//        values.put(String.valueOf(COLUMN_PERSONPHOTO), person.getPersonPhoto());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PERSONS, null, values);
    }

    public void updatePerson(Person person){
        ContentValues values = new ContentValues();
        values.put(COLUMN_PERSONNAME, person.getPersonName());
//        values.put(String.valueOf(COLUMN_PERSONPHOTO), person.getPersonPhoto());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_PERSONS, values, COLUMN_ID	+ "	= ?", new String[] { String.valueOf(person.getPersonID())});
    }

    public Person findPerson(String name){
        String query = "Select * FROM "	+ TABLE_PERSONS + " WHERE " + COLUMN_PERSONNAME + " = " + "name";
        SQLiteDatabase db = this.getWritableDatabase();
        Person mPerson = null;
        Cursor cursor = db.rawQuery(query,	null);
        if	(cursor.moveToFirst()){
            int id = Integer.parseInt(cursor.getString(0));
            String personName = cursor.getString(1);
//            int personPhoto = Integer.parseInt(cursor.getString(2));
            mPerson = new Person(id, personName);
        }
        cursor.close();
        return mPerson;
    }

    public void deleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PERSONS, COLUMN_ID + "	= ?", new String[]{String.valueOf(id)});
    }
}