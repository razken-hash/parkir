package com.example.parkir.views.auth.data.repository

import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.auth.data.service.request.AuthRequest
import com.example.parkir.views.auth.data.service.response.AuthResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.util.logging.Logger

class AuthRepository(
    private val authService: AuthService
) {
    suspend fun login(user: AuthRequest): Response<AuthResponse> {
        return authService.login(user);
    }

    suspend fun register(user: AuthRequest): Response<AuthResponse> {
        return authService.register(user)
    }

    suspend fun signInWithGoogle(user: AuthRequest): Response<AuthResponse> {
        return authService.signInWithGoogle(user)
    }
}