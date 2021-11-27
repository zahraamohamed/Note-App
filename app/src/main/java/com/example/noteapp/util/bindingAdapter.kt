package com.example.noteapp.util

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.ui.base.BaseAdapter
import java.util.*

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:note_color"])
fun changeColor(view: View,value:Boolean?){
    val random=Random()
    val color: Int =Color.argb(
        255,
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