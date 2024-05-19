package com.example.parkir.views.core.bookmarks.data.repository

import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.auth.data.service.request.AuthRequest
import com.example.parkir.views.auth.data.service.response.AuthResponse
import com.example.parkir.views.core.bookmarks.data.entity.Booking
import com.example.parkir.views.core.bookmarks.data.entity.BookingStatus
import com.example.parkir.views.core.bookmarks.data.services.BookingService
import com.example.parkir.views.core.parkings.data.entity.Parking
import com.example.parkir.views.core.parkings.data.service.ParkingService
import retrofit2.Response
class BookingRepository (
    private val bookingService: BookingService
) {
    suspend fun getAllBooking(): Response<List<Booking>> {
        return bookingService.getAllBookings()
    }

    suspend fun getBookingByStatus(status: BookingStatus): Response<List<Booking>> {
        return bookingService.getBookingByStatus(status = status.name)
    }
}