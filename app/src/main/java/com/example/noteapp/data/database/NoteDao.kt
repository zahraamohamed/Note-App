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
    fun insert(note: Note): Completable

    @Delete
    fun delete(note: Note): Completable

    @Update
    fun update(note: Note): Completable

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC ")
    fun getAllNot(): LiveData<List<Note>>


}