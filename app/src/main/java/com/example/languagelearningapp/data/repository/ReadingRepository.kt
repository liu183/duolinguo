package com.example.languagelearningapp.data.repository

import com.example.languagelearningapp.data.local.ReadingContentDao
import com.example.languagelearningapp.data.remote.ApiService
import javax.inject.Inject

class ReadingRepository @Inject constructor(
    private val readingContentDao: ReadingContentDao,
    private val apiService: ApiService
) {
    fun getReadingContent() = readingContentDao.getAllReadingContent()

    suspend fun refreshReadingContent() {
        val remoteContent = apiService.getReadingContent()
        readingContentDao.insertAll(remoteContent)
    }

    suspend fun getReadingContentById(id: String) = readingContentDao.getReadingContentById(id)
}
