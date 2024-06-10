package com.example.parkir.views.core.bookings.data.services

import com.example.parkir.ParkirConsts
import com.example.parkir.views.core.bookings.data.entity.Booking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BookingsService {
    @GET("/api/v1/bookings/1")
    suspend fun getAllBookings(): Response<List<Booking>>

    @GET("/api/v1/bookings/1/id={bookingId}")
    suspend fun getBookingById(@Path("bookingId") bookingId: Int): Response<Booking>

    @GET("/api/v1/bookings/1/{status}")
    suspend fun getBookingsByStatus(@Path("status") status: String): Response<List<Booking>>

    companion object {
        private var bookingsService: BookingsService? = null
        fun getInstance(): BookingsService {
            if (bookingsService == null) {
                bookingsService =
                    Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL).addConverterFactory(
                        GsonConverterFactory.create()
                    ).build().create(BookingsService::class.java)
            }
            return bookingsService!!
        }
    }
}