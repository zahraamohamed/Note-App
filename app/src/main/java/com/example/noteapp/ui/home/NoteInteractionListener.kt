package com.example.noteapp.ui.home

import com.example.noteapp.ui.base.BaseInteractionListener

interface NoteInteractionListener:BaseInteractionListener {
    fun onClickNote(id: Long?)
}