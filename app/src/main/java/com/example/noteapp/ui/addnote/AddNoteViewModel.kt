package com.example.noteapp.ui.addnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Note
import com.example.noteapp.repository.NoteRepository
import com.example.noteapp.util.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

class AddNoteViewModel : ViewModel(),AddNoteInteractionListener {
    private val repository = NoteRepository()

    val newNoteText = MutableStateFlow<String?>(null)

    fun addNote() {
        viewModelScope.launch {
            newNoteText.value?.let {
                repository.insertNote(Note(0, it, Date(), false))
            }
        }
    }

}