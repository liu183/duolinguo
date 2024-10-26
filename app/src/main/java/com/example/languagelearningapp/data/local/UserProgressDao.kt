package com.example.languagelearningapp.data.local

import androidx.room.*
import com.example.languagelearningapp.data.model.UserProgress
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProgressDao {
    @Query("SELECT * FROM user_progress WHERE userId = :userId")
    fun getUserProgress(userId: String): Flow<List<UserProgress>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateProgress(progress: UserProgress)

    @Query("SELECT * FROM user_progress WHERE userId = :userId AND contentId = :contentId AND contentType = :contentType")
    suspend fun getProgressForContent(userId: String, contentId: String, contentType: ContentType): UserProgress?
}
