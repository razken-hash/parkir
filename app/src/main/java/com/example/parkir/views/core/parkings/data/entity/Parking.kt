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
) {
    override fun toString(): String {
        return "Parking(id=$id, name='$name', description='$description', image='$image', address=$address, openingTime='$openingTime', closingTime='$closingTime', pricePerHour=$pricePerHour)"
    }
}