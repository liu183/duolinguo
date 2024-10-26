package com.example.languagelearningapp.ui.reading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.languagelearningapp.databinding.FragmentReadingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReadingFragment : Fragment() {

    private val viewModel: ReadingViewModel by viewModels()
    private lateinit var binding: FragmentReadingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentReadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.readingContent.observe(viewLifecycleOwner) { content ->
            // Update UI with reading content
        }

        binding.refreshButton.setOnClickListener {
            viewModel.refreshContent()
        }
    }
}
