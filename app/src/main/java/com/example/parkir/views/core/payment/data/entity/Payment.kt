package com.example.parkir.views.core.payment.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "payment")
data class Payment(
    @PrimaryKey
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("date")
    val date: String,
    @SerializedName("time")
    val time: String,
    @SerializedName("cardNumber")
    @ColumnInfo(name = "card_number")
    val cardNumber: String,
    @ColumnInfo(name = "card_date")
    @SerializedName("cardCVC")
    val cardDate: String,
    @ColumnInfo(name = "card_cvc")
    @SerializedName("cardDate")
    val cardCVC: String,
    @SerializedName("amount")
    val amount: Double,
)
