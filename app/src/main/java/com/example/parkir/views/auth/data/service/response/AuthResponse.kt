package com.example.parkir.views.auth.data.service.response

import com.google.gson.annotations.SerializedName

class AuthResponse (
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phoneNumber")
    val phoneNumber: String? = null,
    @SerializedName("gender")
    val gender: String? = null,
)