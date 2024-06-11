package com.example.parkir

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.parkir.views.auth.data.dao.UserDAO
import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.core.bookings.dao.BookingDAO
import com.example.parkir.views.core.bookings.data.entity.Booking

@Database(entities = [User::class, Booking::class], version=1)
@TypeConverters(Converters::class)
abstract class ParkirDataBase : RoomDatabase() {
    abstract fun getUserDao():UserDAO
    abstract fun getBookingDAO():BookingDAO
    companion object{
        var INSTANCE : ParkirDataBase?=null
        fun getInstance(context: Context):ParkirDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(context, ParkirDataBase:: class.java, name="parkir.db").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}