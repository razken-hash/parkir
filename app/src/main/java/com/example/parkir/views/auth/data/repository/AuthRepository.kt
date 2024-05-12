package com.example.parkir.views.auth.data.repository

import com.example.parkir.utils.Resource
import com.example.parkir.views.auth.data.remote.AuthInterface
import com.example.parkir.views.auth.data.remote.request.AuthRequest
import retrofit2.HttpException
import java.io.IOException

class AuthRepository(
    private val authInterface: AuthInterface
) {
    suspend fun login(loginRequest: AuthRequest): Resource<Unit> {
        return try {
            val response = authInterface.login(loginRequest)
            Resource.Success(Unit)
        } catch (e: IOException) {
            Resource.Error("${e.message}")
        } catch (e: HttpException) {
            Resource.Error("${e.message}")
        }
    }

    suspend fun register(registerRequest: AuthRequest): Resource<Unit> {
        return try {
            val response = authInterface.register(registerRequest)
            Resource.Success(Unit)
        } catch (e: IOException) {
            Resource.Error("${e.message}")
        } catch (e: HttpException) {
            Resource.Error("${e.message}")
        }
    }
}


