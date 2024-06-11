package com.example.parkir

import androidx.room.TypeConverter
import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.core.bookings.data.entity.BookingStatus
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.payment.data.entity.Payment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {

    @TypeConverter
    fun fromParkingSpot(parkingSpot: ParkingSpot):String{
        return Gson().toJson(parkingSpot)
    }
    @TypeConverter
    fun toParkingSpot(parkingSpotString:String):ParkingSpot{
        val type: Type = object : TypeToken<ParkingSpot>() {}.type
        return Gson().fromJson(parkingSpotString, type)
    }
    @TypeConverter
    fun fromUser(user: User): String {
        return Gson().toJson(user)
    }

    @TypeConverter
    fun toUser(userString: String): User {
        val type: Type = object : TypeToken<User>() {}.type
        return Gson().fromJson(userString, type)
    }
    @TypeConverter
    fun fromPayment(payment: Payment): String {
        return Gson().toJson(payment)
    }

    @TypeConverter
    fun toPayment(paymentString: String): Payment {
        val type: Type = object : TypeToken<Payment>() {}.type
        return Gson().fromJson(paymentString, type)
    }
    @TypeConverter
    fun fromBookingStatus(status: BookingStatus): String {
        return status.name
    }

    @TypeConverter
    fun toBookingStatus(statusString: String): BookingStatus {
        return BookingStatus.valueOf(statusString)
    }
}