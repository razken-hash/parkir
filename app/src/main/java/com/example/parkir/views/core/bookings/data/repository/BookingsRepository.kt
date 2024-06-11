package com.example.parkir.views.core.bookings.data.repository

import com.example.parkir.views.core.bookings.dao.BookingDAO
import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.bookings.data.entity.BookingStatus
import com.example.parkir.views.core.bookings.data.services.BookingsService
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.logging.Logger

class BookingsRepository (
    private val bookingService: BookingsService,
    private val bookingDAO: BookingDAO
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

    suspend fun bookParking(booking: Booking): Response<Booking> {
        //TODO: payment
        return bookingService.bookParking(booking = booking)
    }
    suspend fun addBooking(booking: Booking){
        bookingDAO.addBooking(booking)
    }
    suspend fun deleteUser(booking: Booking){
        bookingDAO.deleteBooking(booking)
    }
    suspend fun updateUser(booking: Booking){
        bookingDAO.updateBooking(booking)
    }
    suspend fun getAllSavedBookings():List<Booking>{
        return bookingDAO.getAllBookings()
    }
    suspend fun getCount():Int{
        return bookingDAO.getCount()
    }
}