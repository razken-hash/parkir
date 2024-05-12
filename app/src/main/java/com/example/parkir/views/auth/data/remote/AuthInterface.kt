package com.example.parkir.views.auth.data.remote

import com.example.parkir.ParkirConsts
import com.example.parkir.views.auth.data.entities.User
import com.example.parkir.views.auth.data.remote.request.AuthRequest
import com.example.parkir.views.auth.data.remote.response.AuthResponse
import com.google.android.gms.common.api.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthInterface {
    @POST("/login")
    suspend fun login(@Body loginRequest: AuthRequest): AuthResponse

    @POST("/register")
    suspend fun register(@Body registerRequest: AuthRequest): AuthResponse

    companion object {
        private var authInterface: AuthInterface? = null
        fun getInstance(): AuthInterface {
            if (authInterface == null) {
                authInterface =
                    Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL + "/auth").addConverterFactory(
                        GsonConverterFactory.create()
                    ).build().create(AuthInterface::class.java)
            }
            return authInterface!!
        }
    }
}
