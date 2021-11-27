package com.example.noteapp.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.ui.base.BaseAdapter
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:note_color"])
fun changeColor(view: View,value:Boolean?){
    val random=Random()
    val color: Int =Color.argb(
        100,
        random.nextInt(255),
        random.nextInt(255),
        random.nextInt(255),
    )
    when (value) {
        true -> {
            view.setBackgroundColor(color)
        }
        else -> {
            view.setBackgroundColor(Color.GRAY)
        }
    }
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter(value = ["app:date"])
fun setDate(view: TextView, date: Date?) {
    date?.let { view.text = SimpleDateFormat("MMM dd, yyyy hh:mm a").format(date) }
}