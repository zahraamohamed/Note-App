package com.example.noteapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.data.Note
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface NoteDao {

    @Insert
   suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC ")
    suspend fun getAllNot(): List<Note>


}