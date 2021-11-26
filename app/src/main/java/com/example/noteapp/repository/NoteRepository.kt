package com.example.noteapp.repository

import com.example.noteapp.data.Note
import com.example.noteapp.data.database.NoteDatabase

class NoteRepository {
    private val dao = NoteDatabase.getInstanceWithOutContext().noeDao()

    suspend fun insertNote(note: Note) {
        return dao.insert(note = note)
    }

    fun getAllNotes() = dao.getAllNot()
    fun getNoteById(id: Long?) = dao.getANotById(id = id)

    suspend fun updateNote(note: Note) = dao.update(note)

    suspend fun getFilterNotes(searchTerm: String) = dao.getFilterNotes("%$searchTerm%")

}