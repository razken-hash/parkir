package com.example.parkir

import android.app.Application
import com.example.parkir.views.auth.data.repository.AuthRepository
import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.core.parkings.data.repository.ParkingRepository
import com.example.parkir.views.core.parkings.data.service.ParkingService

class ParkirApplication : Application() {

    private val authService by lazy { AuthService.getInstance() }
    val authRepository by lazy { AuthRepository(authService) }

    private val parkingService by lazy { ParkingService.getInstance() }
    val parkingRepository by lazy { ParkingRepository(parkingService) }

}