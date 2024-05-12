package com.example.parkir

import android.app.Application
import com.example.parkir.views.auth.data.repository.AuthRepository
import com.example.parkir.views.auth.data.service.AuthService

class ParkirApplication : Application() {

    private val authService by lazy { AuthService.getInstance() }
    val authRepository by lazy { AuthRepository(authService) }

}