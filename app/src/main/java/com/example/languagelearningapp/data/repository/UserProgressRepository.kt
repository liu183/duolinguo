package com.example.languagelearningapp.data.repository

import com.example.languagelearningapp.data.local.UserProgressDao
import com.example.languagelearningapp.data.model.ContentType
import com.example.languagelearningapp.data.model.UserProgress
import javax.inject.Inject

class UserProgressRepository @Inject constructor(
    private val userProgressDao: UserProgressDao
) {
    fun getUserProgress(userId: String) = userProgressDao.getUserProgress(userId)

    suspend fun updateProgress(progress: UserProgress) {
        userProgressDao.insertOrUpdateProgress(progress)
    }

    suspend fun getProgressForContent(userId: String, contentId: String, contentType: ContentType) =
        userProgressDao.getProgressForContent(userId, contentId, contentType)
}
