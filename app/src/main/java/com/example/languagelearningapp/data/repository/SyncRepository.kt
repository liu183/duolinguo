package com.example.languagelearningapp.data.repository

import com.example.languagelearningapp.data.local.UserProgressDao
import com.example.languagelearningapp.data.remote.ApiService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SyncRepository @Inject constructor(
    private val userProgressDao: UserProgressDao,
    private val apiService: ApiService
) {
    suspend fun syncUserProgress(userId: String) = flow {
        try {
            val localProgress = userProgressDao.getUserProgress(userId).first()
            apiService.syncUserProgress(localProgress)
            emit(Result.success(Unit))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    suspend fun fetchRemoteData() = flow {
        try {
            val listeningContent = apiService.getListeningContent()
            val readingContent = apiService.getReadingContent()
            val audiobookContent = apiService.getAudiobookContent()
            // Save fetched data to local database
            emit(Result.success(Unit))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
