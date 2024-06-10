package com.example.parkir.views.core.parkings.views

import android.util.Log
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
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.parkings.data.repository.ParkingRepository
import com.example.parkir.views.core.parkings.data.service.ParkingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.logging.Logger

class ParkingsViewModel(val parkingRepository: ParkingRepository) : ViewModel() {

    var parkings = mutableStateOf<List<Parking>>(emptyList())

    var selectedParking: Parking? by mutableStateOf<Parking?>(null)
    var selectedParkingSpot: ParkingSpot? by mutableStateOf<ParkingSpot?>(null)

    var isLoading by mutableStateOf(true)
    fun getAllParkings() {
        val logger = Logger.getLogger("myprint")
        isLoading = true
        viewModelScope.launch {
            logger.info("Suceees")
            withContext(Dispatchers.IO) {
                logger.info("Suceees2")
                val data = parkingRepository.getAllParkings();
                logger.info("Suceees3")
                if (data.isSuccessful) {
                    if (data.body() != null) {
                        logger.info("Suceees4")
                        parkings.value = data.body()!!
                        isLoading = false;
                    }
                }
            }
        }
    }

    fun getParkingById(parkingId: Int) {
        isLoading = true
        val logger = Logger.getLogger("myprint")
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = parkingRepository.getParkingById(parkingId = parkingId);

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

    fun getParkingSpotById(parkingSpotId: Int) {
        isLoading = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = parkingRepository.getParkingSpotById(parkingSpotId = parkingSpotId);
                if (data.isSuccessful) {
                    if (data.body() != null) {
                        Log.i("ngrook", "get By id")
                        selectedParkingSpot = data.body()
                        isLoading = false;
                    }
                }
                Log.i("ngrook", "Nooo")
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