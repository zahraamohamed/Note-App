package com.example.noteapp.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.entity.Note
import com.example.noteapp.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EditNoteViewModel : ViewModel() {
    private val repository = NoteRepository
    private val oldNote = MutableStateFlow<Note?>(null)
    val content = MutableStateFlow<String?>(null)
    val isImportant = MutableStateFlow<Boolean?>(null)

    init {
        viewModelScope.launch {
            content.collect {
                oldNote.emit(oldNote.value?.apply {
                    content = it.toString()
                })
            }
        }
        viewModelScope.launch {
            isImportant.collect {
                oldNote.emit(oldNote.value?.apply {
                    isImportant = it
                })
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
                isImportant.emit(it.isImportant)
            }
        }
    }
}