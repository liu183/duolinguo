package com.example.languagelearningapp.data.repository

import com.example.languagelearningapp.data.local.ListeningContentDao
import com.example.languagelearningapp.data.remote.ApiService
import javax.inject.Inject

class ListeningRepository @Inject constructor(
    private val listeningContentDao: ListeningContentDao,
    private val apiService: ApiService
) {
    suspend fun getListeningContent() = listeningContentDao.getAllListeningContent()

    suspend fun refreshListeningContent() {
        val remoteContent = apiService.getListeningContent()
        listeningContentDao.insertAll(remoteContent)
    }
}
