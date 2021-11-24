package com.example.noteapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTE_TABLE")
data class Note(
   @PrimaryKey( autoGenerate = true) val id: Long,
    val content: String,
    val date: String,
    val isImportant: Boolean,
)
