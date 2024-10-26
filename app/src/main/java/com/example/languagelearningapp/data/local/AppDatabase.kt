package com.example.languagelearningapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.languagelearningapp.data.model.*

@Database(entities = [User::class, ListeningContent::class, ReadingContent::class, AudiobookContent::class, UserProgress::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun listeningContentDao(): ListeningContentDao
    abstract fun readingContentDao(): ReadingContentDao
    abstract fun audiobookContentDao(): AudiobookContentDao
    abstract fun userProgressDao(): UserProgressDao
}
