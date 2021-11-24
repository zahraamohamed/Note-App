package com.example.noteapp.repository

import com.example.noteapp.data.Note
import com.example.noteapp.data.database.NoteDatabase
import io.reactivex.rxjava3.core.Completable

class NoteRepository {
    val dao = NoteDatabase.getInstanceWithOutContext().noeDao()

    fun insertNote(note: Note): Completable {
        return dao.insert(note = note)
    }

    fun getAllNotes() = dao.getAllNot()
}