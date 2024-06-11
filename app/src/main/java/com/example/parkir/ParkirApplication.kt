package com.example.parkir

import android.app.Application
import com.example.parkir.views.auth.data.repository.AuthRepository
import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.core.bookings.data.repository.BookingsRepository
import com.example.parkir.views.core.bookings.data.services.BookingsService
import com.example.parkir.views.core.parkings.data.repository.ParkingRepository
import com.example.parkir.views.core.parkings.data.service.ParkingService

class ParkirApplication : Application() {

    private val authService by lazy { AuthService.getInstance() }
    private val db by lazy {ParkirDataBase.getInstance(this)}
    private val userDao by lazy {db.getUserDao()}
    val authRepository by lazy { AuthRepository(authService, this, userDao) }

    private val parkingService by lazy { ParkingService.getInstance() }
    val parkingRepository by lazy { ParkingRepository(parkingService) }

    private val bookingsService by lazy { BookingsService.getInstance() }
    private val bookingDAO by lazy {db.getBookingDAO()}
    val bookingsRepository by lazy { BookingsRepository(bookingsService,bookingDAO) }




}