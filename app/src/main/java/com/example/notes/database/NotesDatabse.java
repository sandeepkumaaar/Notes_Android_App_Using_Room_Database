package com.example.notes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notes.dao.NoteDao;
import com.example.notes.entities.Note;

@Database(entities = Note.class, version = 1, exportSchema = false)
public abstract class NotesDatabse extends RoomDatabase {

    private static NotesDatabse notesDatabse;

    public static synchronized NotesDatabse getDatabse(Context context){
        if (notesDatabse == null){
            notesDatabse = Room.databaseBuilder(
                    context,
                    NotesDatabse.class,
                    "notes_db"
            ).build();
        }

        return notesDatabse;
    }
    public abstract NoteDao noteDao();
}
