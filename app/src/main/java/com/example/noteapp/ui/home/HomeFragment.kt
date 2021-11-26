package com.example.noteapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.ui.base.BaseFragment
import kotlinx.coroutines.flow.collect

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.noteRecycler.adapter = NoteAdapter(emptyList(), viewModel)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddNoteFragment())
        }

        lifecycleScope.launchWhenCreated {
            viewModel.navigateToEditNote.collect { event ->
                event.getContentIfNotHandled()?.let {
                    findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(it)
                    )
                }
            }
        }

    }}