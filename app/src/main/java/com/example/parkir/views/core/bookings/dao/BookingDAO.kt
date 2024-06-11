package com.example.parkir.views.core.bookings.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.parkir.views.core.bookings.data.entity.Booking

@Dao
interface BookingDAO {
    @Insert
    fun addBooking(booking: Booking)
    @Update
    fun updateBooking(booking: Booking)
    @Delete
    fun deleteBooking(booking: Booking)
    @Query("SELECT * FROM BOOKINGS")
    fun getAllBookings():List<Booking>
    @Query("SELECT count(*) FROM BOOKINGS")
    fun getCount():Int
}