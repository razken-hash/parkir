package com.example.parkir.views.auth.data.repository

import android.content.Context
import androidx.core.content.edit
import com.example.parkir.views.auth.data.dao.UserDAO
import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.auth.data.service.request.AuthRequest
import retrofit2.Response

class AuthRepository(
    private val authService: AuthService,
    private val context: Context,
    private val userDAO: UserDAO
) {
    suspend fun login(user: AuthRequest): Response<User> {
        return authService.login(user);
    }
    fun saveUserId(userId: Int){
        val pref =
            context.getSharedPreferences("local"
                ,Context.MODE_PRIVATE
            )

        pref.edit {
            putInt("userId",
                userId)
        }
    }
    suspend fun getUserId(): Int {
        val pref = context.getSharedPreferences(
            "local", Context.MODE_PRIVATE
        )
        return pref.getInt("userId", -1)
    }
    suspend fun register(user: AuthRequest): Response<User> {
        return authService.register(user)
    }

    suspend fun signInWithGoogle(user: AuthRequest): Response<User> {
        return authService.signInWithGoogle(user)
    }
    suspend fun saveUser(user: User){
        userDAO.saveUser(user)
    }
    suspend fun deleteUser(user:User){
        userDAO.deleteUser(user)
    }
    suspend fun updateUser(user:User){
        userDAO.updateUser(user)
    }
    suspend fun getUser(id:Int):User{
        return userDAO.getUser(id)
    }
}