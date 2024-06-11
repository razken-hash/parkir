package com.example.parkir.views.core.bookings.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.core.parkings.data.entity.Address
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.payment.data.entity.Payment
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

@Entity(tableName = "bookings")
class Booking(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @ColumnInfo(name = "parking_spot")
    @SerializedName("parkingSpot")
    val parkingSpot: ParkingSpot,
    @ColumnInfo(name = "date")
    @SerializedName("date")
    val date: String,
    @ColumnInfo(name = "begin_time")
    @SerializedName("beginTime")
    val beginTime: String,
    @ColumnInfo(name = "duration")
    @SerializedName("duration")
    val duration: String,
    @ColumnInfo(name = "status")
    @SerializedName("status")
    val status: BookingStatus? = null,
    @ColumnInfo("user")
    @SerializedName("user")
    val user: User,
    @ColumnInfo("booking_payment")
    @SerializedName("bookingPayment")
    val payment: Payment? = null,
)

enum class BookingStatus {
    Canceled, Completed, OnGoing, Paid
}
