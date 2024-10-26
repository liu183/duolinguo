package com.example.languagelearningapp.data.repository

import com.example.languagelearningapp.data.local.AudiobookContentDao
import com.example.languagelearningapp.data.remote.ApiService
import javax.inject.Inject

class AudiobookRepository @Inject constructor(
    private val audiobookContentDao: AudiobookContentDao,
    private val apiService: ApiService
) {
    fun getAudiobookContent() = audiobookContentDao.getAllAudiobookContent()

    suspend fun refreshAudiobookContent() {
        val remoteContent = apiService.getAudiobookContent()
        audiobookContentDao.insertAll(remoteContent)
    }

    suspend fun getAudiobookContentById(id: String) = audiobookContentDao.getAudiobookContentById(id)
}
