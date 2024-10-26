package com.example.languagelearningapp.ui.audiobook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.languagelearningapp.databinding.FragmentAudiobookBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AudiobookFragment : Fragment() {

    private val viewModel: AudiobookViewModel by viewModels()
    private lateinit var binding: FragmentAudiobookBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAudiobookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.audiobookContent.observe(viewLifecycleOwner) { content ->
            // Update UI with audiobook content
        }

        binding.refreshButton.setOnClickListener {
            viewModel.refreshContent()
        }
    }
}
