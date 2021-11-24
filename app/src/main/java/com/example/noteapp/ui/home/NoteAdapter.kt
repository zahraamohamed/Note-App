package com.example.noteapp.ui.home

import com.example.noteapp.R
import com.example.noteapp.data.Note
import com.example.noteapp.ui.base.BaseAdapter

class NoteAdapter(list: List<Note>, listener: NoteInteractionListener) :
    BaseAdapter<Note>(list, listener) {
    override val layoutID: Int
        get() = R.layout.item_note
}