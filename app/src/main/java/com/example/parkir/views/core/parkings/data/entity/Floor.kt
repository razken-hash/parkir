package com.example.parkir.views.core.parkings.data.entity

data class Floor(
    val id: Int,
    val number: Int,
    val name: String,
    val description: String,
    val parking: Parking,
    val parkingSpots: List<ParkingSpot>,
    val parkingSpotsCount: Int,
    val availableParkingSpotsCount: Int
)