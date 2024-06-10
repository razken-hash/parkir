package com.example.parkir.views.core.payment.data.services

import com.example.parkir.ParkirConsts
import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.payment.data.entity.Payment
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface PaymentService {

    @POST("/api/v1/bookings_payments/pay")
    suspend fun pay(@Body payment: Payment): Response<Payment>

    companion object {
        private var paymentService: PaymentService? = null
        fun getInstance(): PaymentService {
            if (paymentService == null) {
                paymentService =
                    Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL).addConverterFactory(
                        GsonConverterFactory.create()
                    ).build().create(PaymentService::class.java)
            }
            return paymentService!!
        }
    }
}