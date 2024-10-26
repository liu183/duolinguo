package com.example.languagelearningapp.data.local

import androidx.room.*
import com.example.languagelearningapp.data.model.AudiobookContent
import kotlinx.coroutines.flow.Flow

@Dao
interface AudiobookContentDao {
    @Query("SELECT * FROM audiobook_content")
    fun getAllAudiobookContent(): Flow<List<AudiobookContent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(audiobookContent: List<AudiobookContent>)

    @Query("SELECT * FROM audiobook_content WHERE id = :id")
    suspend fun getAudiobookContentById(id: String): AudiobookContent?
}
