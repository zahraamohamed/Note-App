package com.example.noteapp.data.dao

import androidx.room.*
import com.example.noteapp.data.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note?)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC ")
    fun getAllNote(): Flow<List<Note>>

    @Query("SELECT * FROM NOTE_TABLE WHERE id==:id ")
    fun getNoteById(id: Long?): Flow<Note>

    @Query("SELECT * FROM NOTE_TABLE WHERE content LIKE:searchTerm ORDER BY id DESC ")
    suspend fun getFilterNotes(searchTerm: String): List<Note>
}