package com.example.noteapp.ui.home

import com.example.noteapp.ui.base.BaseInteractionListener

interface HomeInteractionListener:BaseInteractionListener {
    fun onClickNote(id: Long?)
}