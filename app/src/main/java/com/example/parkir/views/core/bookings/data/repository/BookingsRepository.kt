package com.example.parkir.views.core.bookings.data.repository

import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.bookings.data.entity.BookingStatus
import com.example.parkir.views.core.bookings.data.services.BookingsService
import retrofit2.Response
class BookingsRepository (
    private val bookingService: BookingsService
) {
    suspend fun getAllBookings(): Response<List<Booking>> {
        return bookingService.getAllBookings()
    }

    suspend fun getBookingById(bookingId: Int): Response<Booking> {
        return bookingService.getBookingById(bookingId = bookingId)
    }

    suspend fun getBookingsByStatus(status: BookingStatus): Response<List<Booking>> {
        return bookingService.getBookingsByStatus(status = status.name)
    }
}