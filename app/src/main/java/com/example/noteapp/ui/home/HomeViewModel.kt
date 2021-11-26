package com.example.noteapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Note
import com.example.noteapp.repository.NoteRepository
import com.example.noteapp.util.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import java.util.*

class HomeViewModel : ViewModel(), NoteInteractionListener {
    private val repository = NoteRepository()

    val notes = MutableStateFlow<List<Note>?>(null)
    val searchNote = MutableStateFlow("")
    private val _navigateToEditNote = MutableStateFlow<Event<Long?>>(Event(null))
    val navigateToEditNote: StateFlow<Event<Long?>> get() = _navigateToEditNote

    init {
        showNotes()
         searchNote()
    }

    private fun showNotes() {
        viewModelScope.launch {
            repository.getAllNotes().collect {
                notes.emit(it)
            }
        }
    }

    private fun searchNote() {
        viewModelScope.launch {
            searchNote.debounce(1000).collect {
                val result = repository.getFilterNotes(it)
                notes.emit(result)
            }
        }
    }

    override fun onClickNote(id: Long?) {
        viewModelScope.launch {
            _navigateToEditNote.emit(Event(id))
        }
    }

}