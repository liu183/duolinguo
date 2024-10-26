package com.example.languagelearningapp.ui.listening

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.languagelearningapp.databinding.FragmentListeningBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListeningFragment : Fragment() {

    private val viewModel: ListeningViewModel by viewModels()
    private lateinit var binding: FragmentListeningBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListeningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listeningContent.observe(viewLifecycleOwner) { content ->
            // Update UI with content
        }

        binding.refreshButton.setOnClickListener {
            viewModel.refreshContent()
        }
    }
}
