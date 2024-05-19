package com.example.parkir.views.core.payment.data.services

import com.example.parkir.ParkirConsts
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface PaymentService {
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