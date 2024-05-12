package com.example.parkir.views.auth.data.entities

data class User(
    val id: Int? = null,
    val email: String? = null,
    val hashedPassword: String? = null,
    val phoneNumber: String? = null,
    val name: String? = null,
    val gender: String? = null
) {

}