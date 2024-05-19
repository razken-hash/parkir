package com.example.parkir.views.core.bookmarks.data.entity

import com.example.parkir.views.core.parkings.data.entity.Address
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import java.time.LocalDate

data class Booking(
    val id: Int,
    val parkingSpot: ParkingSpot,
    val date: LocalDate,
    val beginTime: String,
    val endTime: Address,
    val duration: String,
    val status: String,
    val payment: Map<String, Object>
)