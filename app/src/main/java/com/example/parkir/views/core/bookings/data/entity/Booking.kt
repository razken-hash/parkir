package com.example.parkir.views.core.bookings.data.entity

import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.core.parkings.data.entity.Address
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.payment.data.entity.Payment
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class Booking(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("parkingSpot")
    var parkingSpot: ParkingSpot? = null,
    @SerializedName("date")
    var date: String = "",
    @SerializedName("beginTime")
    var beginTime: String = "",
    @SerializedName("duration")
    var duration: String = "",
    @SerializedName("status")
    var status: BookingStatus? = null,
    @SerializedName("user")
    var user: User? = null,
    @SerializedName("bookingPayment")
    var payment: Payment? = null,
)

enum class BookingStatus {
    Canceled, Completed, OnGoing, Paid
}