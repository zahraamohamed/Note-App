package com.example.noteapp.repository

import com.example.noteapp.data.Note
import com.example.noteapp.data.database.NoteDatabase

class NoteRepository {
    val dao = NoteDatabase.getInstanceWithOutContext().noeDao()

    suspend fun insertNote(note: Note){
        return dao.insert(note = note)
    }

     fun getAllNotes() = dao.getAllNot()
}