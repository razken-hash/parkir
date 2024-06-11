package com.example.parkir.views.auth.views

import android.content.Context
import android.text.BoringLayout
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parkir.views.auth.data.repository.AuthRepository
import com.example.parkir.views.auth.data.service.request.AuthRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialException
import com.example.parkir.utils.PasswordGenerator
import com.example.parkir.views.auth.data.entity.User
import com.example.parkir.views.core.parkings.data.entity.Parking
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Integer.parseInt
import java.util.logging.Logger

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    var email: String by mutableStateOf("ka_kenniche@esi.dz")
    var password: String by mutableStateOf("12345678")
    var rememberMe: Boolean by mutableStateOf(false)

    var authStatus by mutableStateOf(false)
    var userId by mutableStateOf(-1)
    var user: User? by mutableStateOf<User?>(null)

    fun login() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val body = AuthRequest(email = email, password = password)
                val data = authRepository.login(body)
                if (data.isSuccessful) {
                    if (data.body() != null) {
                        userId = data.body()?.id?.toInt() ?: -1
                        authRepository.saveUserId(userId)
                        authRepository.saveUser(data.body()!!)
                        authStatus = trueg}
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

    fun signInWthGoogle(context: Context) {

        val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false) // Query all google accounts on the device
            .setServerClientId("98997096205-7fn1pkd5mbomsuephopc7o092vgffuf2.apps.googleusercontent.com")
            .build()

        val request =
            GetCredentialRequest.Builder().addCredentialOption(googleIdOption)
                .build()

        val credentialManager = CredentialManager.create(context)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val result =
                    credentialManager.getCredential(context, request)

                when (val credential = result.credential) {
                    is Credential -> {
                        if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                            try {
                                val googleIdTokenCredential =
                                    GoogleIdTokenCredential.createFrom(credential.data)

                                val body = AuthRequest(
                                    email = googleIdTokenCredential.id,
                                    password = PasswordGenerator.generatePassword(50)
                                )
                                val data = authRepository.signInWithGoogle(body)
                                if (data.isSuccessful) {
                                    if (data.body() != null) {
                                        authStatus = true
                                    }
                                }


                                authStatus = true

                            } catch (e: GoogleIdTokenParsingException) {
                                Log.e("MainActivity", "GetCredentialException", e)
                            }
                        }
                    }

                }
            } catch (e: GetCredentialException) {
                Log.e("MainActivity", "GetCredentialException", e)
            }
        }

    }
    /**
     * to get saved user info use this function
     * this will retrieve user info from db
     * to use this use the code to retrieve id from shared references
     * to get from shared references you need the context  use this code
     * val context = LocalContext.current;
     * val pref = context.getSharedPreferences("local", Context.MODE_PRIVATE);
     * val userId = pref.getInt("userId",-1);
     * -1 is the default value when it's not set
    **/

    suspend fun getSavedUser(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                user = authRepository.getUser(id)
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