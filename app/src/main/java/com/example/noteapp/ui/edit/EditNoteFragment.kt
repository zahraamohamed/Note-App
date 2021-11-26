package com.example.noteapp.ui.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.noteapp.databinding.FragmentEditNoteBinding
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.ui.base.BaseFragment
import com.example.noteapp.ui.home.HomeFragmentDirections
import com.example.noteapp.ui.home.HomeViewModel

class EditNoteFragment : BaseFragment<FragmentEditNoteBinding>() {
    private val args: EditNoteFragmentArgs by navArgs()
    override val viewModel: EditNoteViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentEditNoteBinding
        get() = FragmentEditNoteBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onNoteClicked(args.id)

        binding.check.setOnClickListener {
            viewModel.save()
            findNavController().navigate(EditNoteFragmentDirections.actionEditNoteFragmentToHomeFragment())
        }
    }
}