package com.example.noteapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.data.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noeDao(): NoteDao

    companion object {
        private const val DATABASE_NAME = "MyNoteDatabase"

        @Volatile
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            return instance ?: synchronized(this) { buildDatabase(context).also { instance = it } }

        }
        fun getInstanceWithOutContext(): NoteDatabase{
            return instance!!
        }

        fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME).build()
        }
    }
}