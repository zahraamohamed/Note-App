package com.example.noteapp.data.database

import androidx.room.TypeConverter
import java.util.*

class Converter {

    @TypeConverter
    fun dateToLong(date:Date):Long{
      return  Date().time
    }

    @TypeConverter
    fun longToDate(long:Long):Date{
      return  Date(long)
    }
}