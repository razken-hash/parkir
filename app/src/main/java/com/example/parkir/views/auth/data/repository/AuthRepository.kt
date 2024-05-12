package com.example.parkir.views.auth.data.repository

import com.example.parkir.views.auth.data.service.AuthService
import com.example.parkir.views.auth.data.service.request.AuthRequest
import com.example.parkir.views.auth.data.service.response.AuthResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.util.logging.Logger
class AuthRepository(
    private val authService: AuthService
) {
    private val log = Logger.getLogger("AuthRepository")

    suspend fun login(user: AuthRequest): Response<AuthResponse> {
        try {
            log.info("Attempting to log in")
            log.info("here")
            var data =  authService.login(user)
            if (data.message()!= null) {
                log.info("here")
            } else
            {
                log.info("herenull")
            }
            return  data;
        } catch (e: IOException) {
            log.warning("IOException during login: $e")
            throw e
        } catch (e: HttpException) {
            log.warning("HttpException during login: ${e.response()?.code()}")
            throw e
        } catch (e: Exception) {
            log.warning("Exception during login: $e")
            throw e
        } finally {
            log.info("finally")
        }
    }

    suspend fun register(user: AuthRequest): Response<AuthResponse> {
        try {
            return authService.register(user)
        } catch (e: IOException) {
            log.warning("IOException during registration: $e")
            throw e
        } catch (e: HttpException) {
            log.warning("HttpException during registration: ${e.response()?.code()}")
            throw e
        } catch (e: Exception) {
            log.warning("Exception during registration: $e")
            throw e
        }
    }
}