package com.example.languagelearningapp.data.remote

import com.example.languagelearningapp.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("api/listening-content")
    suspend fun getListeningContent(): List<ListeningContent>

    @GET("api/reading-content")
    suspend fun getReadingContent(): List<ReadingContent>

    @GET("api/audiobook-content")
    suspend fun getAudiobookContent(): List<AudiobookContent>

    @POST("api/login")
    suspend fun login(@Body loginRequest: LoginRequest): User

    @POST("api/register")
    suspend fun register(@Body registerRequest: RegisterRequest): User
}

data class LoginRequest(val email: String, val password: String)
data class RegisterRequest(val name: String, val email: String, val password: String)
