package com.example.languagelearningapp.ui.listening

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languagelearningapp.data.repository.ListeningRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListeningViewModel @Inject constructor(
    private val listeningRepository: ListeningRepository
) : ViewModel() {

    val listeningContent = listeningRepository.getListeningContent()

    fun refreshContent() {
        viewModelScope.launch {
            listeningRepository.refreshListeningContent()
        }
    }
}
