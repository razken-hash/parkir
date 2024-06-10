package com.example.parkir.views.auth.data.repository

import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.auth.data.service.request.AuthRequest
import retrofit2.Response

class AuthRepository(
    private val authService: AuthService
) {
    suspend fun login(user: AuthRequest): Response<User> {
        return authService.login(user);
    }

    suspend fun register(user: AuthRequest): Response<User> {
        return authService.register(user)
    }

    suspend fun signInWithGoogle(user: AuthRequest): Response<User> {
        return authService.signInWithGoogle(user)
    }
}