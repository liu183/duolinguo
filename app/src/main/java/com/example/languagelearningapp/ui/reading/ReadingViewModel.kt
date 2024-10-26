package com.example.languagelearningapp.ui.reading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.languagelearningapp.data.repository.ReadingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReadingViewModel @Inject constructor(
    private val readingRepository: ReadingRepository
) : ViewModel() {

    val readingContent = readingRepository.getReadingContent()

    fun refreshContent() {
        viewModelScope.launch {
            readingRepository.refreshReadingContent()
        }
    }

    suspend fun getReadingContentById(id: String) = readingRepository.getReadingContentById(id)
}
