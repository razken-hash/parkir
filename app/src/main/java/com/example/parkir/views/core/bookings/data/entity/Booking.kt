package com.example.parkir.views.core.bookings.data.entity

import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.core.parkings.data.entity.Address
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.payment.data.entity.Payment
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Booking(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("parkingSpot")
    val parkingSpot: ParkingSpot,
    @SerializedName("date")
    val date: String,
    @SerializedName("beginTime")
    val beginTime: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("status")
    val status: BookingStatus? = null,
    @SerializedName("user")
    val user: User,
    @SerializedName("bookingPayment")
    val payment: Payment? = null,
)

enum class BookingStatus {
    Canceled, Completed, OnGoing, Paid
}
