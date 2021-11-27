package com.example.noteapp.ui.home

import android.graphics.Color
import com.example.noteapp.R
import com.example.noteapp.data.entity.Note
import com.example.noteapp.ui.base.BaseAdapter

class NoteAdapter(list: List<Note>, listener: HomeInteractionListener) :
    BaseAdapter<Note>(list, listener) {
    override val layoutID: Int
        get() = R.layout.item_note


}