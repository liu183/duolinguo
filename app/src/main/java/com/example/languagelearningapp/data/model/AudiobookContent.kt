package com.example.languagelearningapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "audiobook_content")
data class AudiobookContent(
    @PrimaryKey val id: String,
    val title: String,
    val audioUrl: String,
    val textContent: String,
    val duration: Long,
    val difficulty: Int
)
