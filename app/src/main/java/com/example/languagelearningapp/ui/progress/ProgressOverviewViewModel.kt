package com.example.languagelearningapp.ui.progress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.languagelearningapp.data.repository.UserProgressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProgressOverviewViewModel @Inject constructor(
    private val userProgressRepository: UserProgressRepository
) : ViewModel() {

    // Assuming we have a way to get the current user ID
    private val userId = "current_user_id"

    val userProgress = userProgressRepository.getUserProgress(userId).asLiveData()
}
