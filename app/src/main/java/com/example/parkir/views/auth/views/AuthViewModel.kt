package com.example.parkir.views.auth.views

import android.text.BoringLayout
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parkir.views.auth.data.repository.AuthRepository
import com.example.parkir.views.auth.data.service.request.AuthRequest
import com.example.parkir.views.auth.data.service.response.AuthResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.logging.Logger

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    var email: String by mutableStateOf("ka_kenniche@esi.dz")
    var password: String by mutableStateOf("12345678")
    var rememberMe: Boolean by mutableStateOf(false)

    var authStatus by mutableStateOf(false)

    fun login() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val body = AuthRequest(email = email, password = password)
                val data = authRepository.login(body)
                if (data.isSuccessful) {
                    if (data.body() != null) {
                        authStatus = true
                    }
                }
            }
        }
    }

    fun register() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val body = AuthRequest(email = email, password = password)
                val data = authRepository.register(body)
                if (data.isSuccessful) {
                    if (data.body() != null) {
                        authStatus = true
                    }
                }
            }
        }
    }

    class Factory(private val authRepository: AuthRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AuthViewModel(authRepository) as T
        }
    }
}