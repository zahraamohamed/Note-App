package com.example.noteapp


import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.noteapp.R
import com.example.noteapp.data.database.NoteDatabase
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_NoteApp
    override val viewID = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NoteDatabase.getInstance(applicationContext)
    }


}