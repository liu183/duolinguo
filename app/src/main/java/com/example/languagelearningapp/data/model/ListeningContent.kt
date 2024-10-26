package com.example.languagelearningapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listening_content")
data class ListeningContent(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val audioUrl: String,
    val type: ListeningType
)

enum class ListeningType {
    SHORT_DIALOGUE,
    NEWS,
    SONG,
    MOVIE_CLIP
}
