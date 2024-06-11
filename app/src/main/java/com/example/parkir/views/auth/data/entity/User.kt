package com.example.parkir.views.auth.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "users")
class User (
    @PrimaryKey
    @SerializedName("id")
    val id: String = "",
    @ColumnInfo(name= "email")
    @SerializedName("email")
    val email: String? = null,
    @ColumnInfo(name= "name")
    @SerializedName("name")
    val name: String? = null,
    @ColumnInfo(name= "phone_name")
    @SerializedName("phoneNumber")
    val phoneNumber: String? = null,
    @ColumnInfo(name= "gender")
    @SerializedName("gender")
    val gender: String? = null,
)

