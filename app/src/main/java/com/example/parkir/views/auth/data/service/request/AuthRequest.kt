package com.example.parkir.views.auth.data.service.request

import com.google.gson.annotations.SerializedName

class AuthRequest(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null
)
