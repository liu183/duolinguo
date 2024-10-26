package com.example.languagelearningapp.data.local

import androidx.room.*
import com.example.languagelearningapp.data.model.ReadingContent
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadingContentDao {
    @Query("SELECT * FROM reading_content")
    fun getAllReadingContent(): Flow<List<ReadingContent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(readingContent: List<ReadingContent>)

    @Query("SELECT * FROM reading_content WHERE id = :id")
    suspend fun getReadingContentById(id: String): ReadingContent?
}
