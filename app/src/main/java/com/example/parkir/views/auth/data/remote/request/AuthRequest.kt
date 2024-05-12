package com.example.parkir.views.auth.data.remote.request

import com.google.gson.annotations.SerializedName

class AuthRequest(
    @SerializedName("email") var email: String,
    @SerializedName("password") var password: String
)