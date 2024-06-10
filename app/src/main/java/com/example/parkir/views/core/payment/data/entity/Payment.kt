package com.example.parkir.views.core.payment.data.entity

import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("cardNumber")
    val cardNumber: String,
    @SerializedName("cardCVC")
    val cardDate: String,
    @SerializedName("cardDate")
    val cardCVC: String,
    @SerializedName("amount")
    val amount: Double,
)
