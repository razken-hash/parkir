package com.example.parkir.views.auth.data.remote.response

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phoneNumber") val phoneNumber: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("gender") val gender: String? = null,
)
