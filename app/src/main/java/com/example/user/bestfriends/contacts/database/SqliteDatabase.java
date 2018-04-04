package com.example.user.bestfriends.contacts.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.bestfriends.contacts.Contacts;

import java.util.ArrayList;
import java.util.List;

public class SqliteDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "contact";
    private static final String TABLE_CONTACTS = "contacts";

    private static final String KEY_ID = "_id";
    //    private static final String KEY_PHOTO = "photo";
    private static final String KEY_NAME = "personname";
    private static final String KEY_BIRTHDAY = "birthday";
    private static final String KEY_TELEPHONE = "telephone";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_CHUKPOK = "chukpok";

    public SqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "CREATE TABLE "
                + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
//                + COLUMN_PERSONPHOTO + " BLOB,"
                + KEY_NAME + " TEXT,"
                + KEY_BIRTHDAY + " TEXT,"
                + KEY_TELEPHONE + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_CHUKPOK + " TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE);
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    public List<Contacts> listContacts() {
        String sql = "select * from " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        List<Contacts> storeContacts = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String birthday = cursor.getString(2);
                String telephone = cursor.getString(3);
                String email = cursor.getString(4);
                String chukpok = cursor.getString(5);
//                byte[] photo = cursor.getBlob(6);
                storeContacts.add(new Contacts(id, name, birthday, telephone, email, chukpok));

            } while (cursor.moveToNext());
        }
        cursor.close();
        return storeContacts;
    }

    public void addContacts(Contacts contacts) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getPersonName());
        values.put(KEY_BIRTHDAY, contacts.getPersonBirthday());
        values.put(KEY_TELEPHONE, contacts.getPersonTelephone());
        values.put(KEY_EMAIL, contacts.getPersonEmail());
        values.put(KEY_CHUKPOK, contacts.getPersonChukpok());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CONTACTS, null, values);
    }

    public void updateContacts(Contacts contacts) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getPersonName());
        values.put(KEY_BIRTHDAY, contacts.getPersonBirthday());
        values.put(KEY_TELEPHONE, contacts.getPersonTelephone());
        values.put(KEY_EMAIL, contacts.getPersonEmail());
        values.put(KEY_CHUKPOK, contacts.getPersonChukpok());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_CONTACTS, values, KEY_ID + "	= ?", new String[] { String.valueOf(contacts.getContactsID()) });
    }

    public void deleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " =?", new String[] { String.valueOf(id) });
    }
}