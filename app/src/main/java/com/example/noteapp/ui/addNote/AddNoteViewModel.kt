package com.example.noteapp.ui.addNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.entity.Note
import com.example.noteapp.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*

class AddNoteViewModel : ViewModel(), AddNoteInteractionListener {
    private val repository = NoteRepository

    val newNoteText = MutableStateFlow<String?>(null)
    val newTitleText = MutableStateFlow<String?>(null)
    val isImportantNote = MutableStateFlow<Boolean?>(null)

    fun addNote() {
        viewModelScope.launch {
            repository.insertNote(Note(0,
                newNoteText.value,
                newTitleText.value,
                Date(),
                isImportantNote.value))

        }
    }


}