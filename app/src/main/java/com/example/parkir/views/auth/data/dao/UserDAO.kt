package com.example.parkir.views.auth.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.parkir.views.auth.data.entity.User

@Dao
interface UserDAO {
    @Insert
    fun saveUser(user: User)
    @Update
    fun updateUser(user: User)
    @Delete
    fun deleteUser(user: User)
    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): User

}