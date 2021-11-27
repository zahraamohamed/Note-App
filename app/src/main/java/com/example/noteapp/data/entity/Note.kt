package com.example.noteapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "NOTE_TABLE")
data class Note(
   @PrimaryKey( autoGenerate = true) val id: Long,
    var content: String?,
    var date: Date,
    var isImportant: Boolean?,
)
