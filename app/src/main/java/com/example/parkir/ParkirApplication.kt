package com.example.parkir

import android.app.Application
import com.example.parkir.views.auth.data.repository.AuthRepository
import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.core.bookings.data.repository.BookingsRepository
import com.example.parkir.views.core.bookings.data.services.BookingsService
import com.example.parkir.views.core.parkings.data.repository.ParkingRepository
import com.example.parkir.views.core.parkings.data.service.ParkingService
import com.example.parkir.views.core.payment.data.repository.PaymentRepository
import com.example.parkir.views.core.payment.data.services.PaymentService

class ParkirApplication : Application() {

    private val authService by lazy { AuthService.getInstance() }
    val authRepository by lazy { AuthRepository(authService, this) }

    private val parkingService by lazy { ParkingService.getInstance() }
    val parkingRepository by lazy { ParkingRepository(parkingService) }

    private val bookingsService by lazy { BookingsService.getInstance() }
    val bookingsRepository by lazy { BookingsRepository(bookingsService) }
    private val paymentService by lazy { PaymentService.getInstance() }
    val paymentRepository by lazy { PaymentRepository(paymentService) }
}