package com.example.noteapp.ui.addNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapp.databinding.FragmentAddNoteBinding
import com.example.noteapp.ui.base.BaseFragment

class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>() {
    override val viewModel: AddNoteViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentAddNoteBinding
        get() = FragmentAddNoteBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.note.requestFocus()
        binding.check.setOnClickListener {
            viewModel.addNote()
            findNavController().navigate(AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment())
            clearView()
        }

    }

    fun clearView(){
        binding.apply {
            note.setText("")
            title.setText("")
            isImportant.isChecked=false
        }

    }


}

