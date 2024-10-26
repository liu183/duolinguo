package com.example.languagelearningapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reading_content")
data class ReadingContent(
    @PrimaryKey val id: String,
    val title: String,
    val content: String,
    val type: ReadingType,
    val difficulty: Int
)

enum class ReadingType {
    SHORT_ARTICLE,
    NEWS,
    STORY,
    PRACTICAL_TEXT
}
