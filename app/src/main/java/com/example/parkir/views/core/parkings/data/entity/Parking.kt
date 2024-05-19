package com.example.parkir.views.core.parkings.data.entity

data class Parking(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val address: Address,
    val openingTime: String,
    val closingTime: String,
    val pricePerHour: Int
)