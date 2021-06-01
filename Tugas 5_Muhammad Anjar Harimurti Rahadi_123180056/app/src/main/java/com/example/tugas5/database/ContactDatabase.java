package com.example.tugas5.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tugas5.model.Contact;

@Database(entities = Contact.class, version = 1,exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase{
    private static String DB_NAME = "db_notes";
    private static ContactDatabase instance;

    public abstract ContactDao contactDao();

    public static ContactDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ContactDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
