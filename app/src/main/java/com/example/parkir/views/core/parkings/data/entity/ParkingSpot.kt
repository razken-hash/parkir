package com.example.parkir.views.core.parkings.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parking_spots")
class ParkingSpot(
    @PrimaryKey
    val id: Int,
    val number: Int,
    val floor: Floor,
    val status: String,
)
