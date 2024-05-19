package com.example.parkir.views.core.bookmarks.data.services

import com.example.parkir.ParkirConsts
import com.example.parkir.views.core.bookmarks.data.entity.Booking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BookingService {
    @GET("/api/v1/bookings")
    suspend fun getAllBookings(): Response<List<Booking>>

    @GET("/api/v1/bookings/{status}")
    suspend fun getBookingByStatus(@Path("status") status: String): Response<List<Booking>>

    companion object {
        private var bookingService: BookingService? = null
        fun getInstance(): BookingService {
            if (bookingService == null) {
                bookingService =
                    Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL).addConverterFactory(
                        GsonConverterFactory.create()
                    ).build().create(BookingService::class.java)
            }
            return bookingService!!
        }
    }
}