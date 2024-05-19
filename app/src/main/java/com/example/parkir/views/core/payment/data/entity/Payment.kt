package com.example.parkir.views.core.payment.data.entity

import com.example.parkir.views.core.bookings.data.entity.Booking
import java.time.LocalDate
import java.time.LocalTime

data class Payment(
    val id: Int,
    val date: LocalDate,
    val time: LocalTime,
    val cardNumber: String,
    val cardCVC: String,
    val amount: Double,
    val booking: Booking
)