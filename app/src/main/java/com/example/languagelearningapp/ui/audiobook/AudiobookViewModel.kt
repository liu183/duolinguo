package com.example.languagelearningapp.ui.audiobook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languagelearningapp.data.repository.AudiobookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AudiobookViewModel @Inject constructor(
    private val audiobookRepository: AudiobookRepository
) : ViewModel() {

    val audiobookContent = audiobookRepository.getAudiobookContent()

    fun refreshContent() {
        viewModelScope.launch {
            audiobookRepository.refreshAudiobookContent()
        }
    }

    suspend fun getAudiobookContentById(id: String) = audiobookRepository.getAudiobookContentById(id)
}
