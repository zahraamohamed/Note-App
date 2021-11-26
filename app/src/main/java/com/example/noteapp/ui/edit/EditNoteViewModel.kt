package com.example.noteapp.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Note
import com.example.noteapp.repository.NoteRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EditNoteViewModel : ViewModel() {
    val repository = NoteRepository()
    val oldNote = MutableStateFlow<Note?>(null)
    val content = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch {
            content.collect {
                oldNote.emit( oldNote.value?.apply { content = it.toString() })
            }
        }
    }

    fun save() {
        viewModelScope.launch {
            oldNote.value?.let { repository.updateNote(it) }
        }
    }

    fun onNoteClicked(id: Long?) {
        viewModelScope.launch {
            repository.getNoteById(id).collect {
                oldNote.emit(it)
                content.emit(it.content)
            }
        }
    }
}