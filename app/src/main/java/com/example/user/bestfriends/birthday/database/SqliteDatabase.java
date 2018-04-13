package com.example.user.bestfriends.birthday.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.bestfriends.birthday.Birthday;

import java.util.ArrayList;
import java.util.List;

public class SqliteDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "birthday";
    private static final String TABLE_BIRTHDAY = "birthdays";

    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "personname";
    private static final String KEY_BIRTHDAY = "birthday";

    public SqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BIRTHDAY_TABLE = "CREATE TABLE "
                + TABLE_BIRTHDAY + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_BIRTHDAY + " TEXT" + ")";
        db.execSQL(CREATE_BIRTHDAY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BIRTHDAY);
        onCreate(db);
    }

    public List<Birthday> listBirthday() {
        String sql = "select * from " + TABLE_BIRTHDAY;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Birthday> storeContacts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String birthday = cursor.getString(2);
                storeContacts.add(new Birthday(id, name, birthday));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeContacts;
    }

    public void addBirthday(Birthday birthday) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, birthday.getPerson_name());
        values.put(KEY_BIRTHDAY, birthday.getDate_birthday());
        SQLiteDatabase db = this.getReadableDatabase();
        db.insert(TABLE_BIRTHDAY, null, values);
    }

    public void updateBirthday(Birthday birthday) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, birthday.getPerson_name());
        values.put(KEY_BIRTHDAY, birthday.getDate_birthday());
        SQLiteDatabase db = this.getReadableDatabase();
        db.update(TABLE_BIRTHDAY, values, KEY_ID + "=?", new String[] {String.valueOf(birthday.getBirthdayID())});
    }

    public void deleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BIRTHDAY, KEY_ID + " =?", new String[] { String.valueOf(id) });
    }
}