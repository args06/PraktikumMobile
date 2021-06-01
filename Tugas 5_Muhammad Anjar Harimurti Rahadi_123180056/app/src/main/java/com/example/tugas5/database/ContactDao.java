package com.example.tugas5.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tugas5.model.Contact;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact")
    List<Contact> getAllData();

    @Insert
    void insertData(Contact contact);

    @Update
    void updateData(Contact contact);

    @Delete
    void deleteData(Contact contact);
}
