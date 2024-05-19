package com.example.parkir.views.core.bookings.data.entity

import com.example.parkir.views.core.parkings.data.entity.Address
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.payment.data.entity.Payment
import java.time.LocalDate

data class Booking(
    val id: Int,
    val parkingSpot: ParkingSpot,
    val date: String,
    val beginTime: String,
    val endTime: String,
    val duration: String,
    val status: BookingStatus,
//    val payment: Payment?
)

enum class BookingStatus {
    Canceled, Completed, OnGoing, Paid
}
