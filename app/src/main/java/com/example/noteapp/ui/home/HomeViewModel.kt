package com.example.noteapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapp.data.Note
import com.example.noteapp.repository.NoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : ViewModel(), NoteInteractionListener {
    private val repository = NoteRepository()

    val newNoteText = MutableLiveData<String>()


    val notes: LiveData<List<Note>> = repository.getAllNotes()


    fun addNote() {
        newNoteText.value?.let {
            repository.insertNote(Note(0, it, "99", false))
                .subscribeOn(Schedulers.io())
                .subscribe()
            newNoteText.postValue(" ")
        }
    }




}