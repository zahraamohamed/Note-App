package com.example.noteapp.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Note
import com.example.noteapp.repository.NoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(), NoteInteractionListener {
    private val repository = NoteRepository()

    val newNoteText = MutableLiveData<String>()

    private val _notes=MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    init {
        loadNotes()
    }
    fun addNote(){
        viewModelScope.launch {
            newNoteText.value?.let {
                repository.insertNote(Note(0, it, "99", false))
            }
        }
    }
    private fun loadNotes(){
        viewModelScope.launch {
            val allNotes=repository.getAllNotes()
            _notes.postValue(allNotes)
        }
    }

//
//    fun addNote() {
//        newNoteText.value?.let {
//            repository.insertNote(Note(0, it, "99", false))
//                .subscribeOn(Schedulers.io())
//                .subscribe()
//            newNoteText.postValue(" ")
//        }
//    }




}