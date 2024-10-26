package com.example.languagelearningapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgress(
    @PrimaryKey val id: String,
    val userId: String,
    val contentId: String,
    val contentType: ContentType,
    val progress: Float,
    val lastAccessTime: Long
)

enum class ContentType {
    LISTENING,
    READING,
    AUDIOBOOK
}
