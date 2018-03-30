package com.example.user.bestfriends.list_kido.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.user.bestfriends.list_kido.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

//    private static AppDatabase INSTANCE;
//
//    public static AppDatabase getInstance(Context context) {
//        if (INSTANCE == null) {
//            INSTANCE = Room.databaseBuilder(
//                    context.getApplicationContext(),
//                    AppDatabase.class,
//                    "BlogPostsDatabase")
//                    .build();
//        }
//
//        return INSTANCE;
//    }
//
//    public static void destroyInstance() {
//        INSTANCE = null;
//    }

    public abstract UserDao userDao();

}