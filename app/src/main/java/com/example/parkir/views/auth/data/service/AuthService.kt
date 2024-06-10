package com.example.parkir.views.auth.data.service

import com.example.parkir.ParkirConsts
import com.example.parkir.views.auth.data.service.request.AuthRequest
import com.example.parkir.views.auth.data.service.response.AuthResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/v1/auth/login")
    suspend fun login(@Body loginRequest: AuthRequest): Response<AuthResponse>

    @POST("/api/v1/auth/register")
    suspend fun register(@Body registerRequest: AuthRequest): Response<AuthResponse>

    @POST("/api/v1/auth/signinwithgoogle")
    suspend fun signInWithGoogle(@Body registerRequest: AuthRequest): Response<AuthResponse>

    companion object {
        private var authInterface: AuthService? = null
        fun getInstance(): AuthService {
            if (authInterface == null) {
                authInterface =
                    Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL).addConverterFactory(
                        GsonConverterFactory.create()
                    ).build().create(AuthService::class.java)
            }
            return authInterface!!
        }
    }
}
