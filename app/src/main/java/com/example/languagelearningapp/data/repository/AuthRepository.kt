package com.example.languagelearningapp.data.repository

import com.example.languagelearningapp.data.model.User
import com.example.languagelearningapp.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun login(email: String, password: String): Flow<Result<User>> = flow {
        try {
            val user = apiService.login(email, password)
            emit(Result.success(user))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }

    suspend fun register(name: String, email: String, password: String): Flow<Result<User>> = flow {
        try {
            val user = apiService.register(name, email, password)
            emit(Result.success(user))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}
