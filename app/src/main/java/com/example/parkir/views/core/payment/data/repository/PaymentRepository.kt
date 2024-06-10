package com.example.parkir.views.core.payment.data.repository

import com.example.parkir.views.core.bookings.data.entity.Booking
import com.example.parkir.views.core.payment.data.entity.Payment
import com.example.parkir.views.core.payment.data.services.PaymentService
import retrofit2.Response


class PaymentRepository(
    private val paymentService: PaymentService
) {
    suspend fun pay(payment: Payment): Response<Payment> {
        return paymentService.pay(payment = payment)
    }
}