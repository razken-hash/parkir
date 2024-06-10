package com.example.parkir.views.auth.data.entity

import com.google.gson.annotations.SerializedName

class User (
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

