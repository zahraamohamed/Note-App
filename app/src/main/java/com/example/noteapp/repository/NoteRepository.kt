package com.example.noteapp.repository

import com.example.noteapp.data.entity.Note
import com.example.noteapp.data.database.NoteDatabase

object NoteRepository {
    private val dao = NoteDatabase.getInstanceWithOutContext().noeDao()

    suspend fun insertNote(note: Note?) = dao.insert(note = note)

    suspend fun deleteNote(note: Note) = dao.delete(note=note)

    fun getAllNotes() = dao.getAllNote()

    fun getNoteById(id: Long?) = dao.getNoteById(id = id)

    suspend fun updateNote(note: Note) = dao.update(note = note)

    suspend fun getFilterNotes(searchTerm: String) = dao.getFilterNotes("%$searchTerm%")

}