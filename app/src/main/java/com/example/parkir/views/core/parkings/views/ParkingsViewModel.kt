package com.example.parkir.views.core.parkings.views

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.parkir.views.auth.data.repository.AuthRepository
import com.example.parkir.views.auth.data.service.request.AuthRequest
import com.example.parkir.views.auth.views.AuthViewModel
import com.example.parkir.views.core.parkings.data.entity.Parking
import com.example.parkir.views.core.parkings.data.repository.ParkingRepository
import com.example.parkir.views.core.parkings.data.service.ParkingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.logging.Logger

class ParkingsViewModel(val parkingRepository: ParkingRepository) : ViewModel() {

    var parkings = mutableStateOf<List<Parking>>(emptyList())

    var selectedParking: Parking? by mutableStateOf<Parking?>(null)

    var isLoading by mutableStateOf(true)
    fun getAllParkings() {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = parkingRepository.getAllParkings();
                if (data.isSuccessful) {
                    if (data.body() != null) {
                        parkings.value = data.body()!!
                        isLoading = false;
                    }
                }
            }
        }
    }

    fun getParkingById(parkingId: Int) {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = parkingRepository.getParkingById(parkingId = parkingId);
               val logger = Logger.getLogger("myprint")
                logger.info("BEfire")
                if (data.isSuccessful) {
                    logger.info("Suceees")
                    logger.info(data.body().toString())
                    if (data.body() != null) {
                        logger.info("Body")
                        selectedParking = data.body()!!
                        isLoading = false;
                        logger.info(selectedParking.toString())
                    }
                }
            }
        }
    }

    class Factory(private val parkingRepository: ParkingRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ParkingsViewModel(parkingRepository) as T
        }
    }
}