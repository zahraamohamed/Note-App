package com.example.noteapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.data.Note
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert
   suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC ")
     fun getAllNot():Flow<List<Note>>

     @Query("SELECT * FROM NOTE_TABLE WHERE id==:id ")
     fun getANotById(id :Long?):Flow<Note>

    @Query("SELECT * FROM NOTE_TABLE WHERE content LIKE:searchTerm ORDER BY id DESC ")
   suspend fun getFilterNotes(searchTerm:String):List<Note>
}