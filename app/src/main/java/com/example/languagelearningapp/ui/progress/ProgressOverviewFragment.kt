package com.example.languagelearningapp.ui.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.languagelearningapp.databinding.FragmentProgressOverviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProgressOverviewFragment : Fragment() {

    private val viewModel: ProgressOverviewViewModel by viewModels()
    private lateinit var binding: FragmentProgressOverviewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProgressOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userProgress.observe(viewLifecycleOwner) { progress ->
            // Update UI with user progress
        }
    }
}
