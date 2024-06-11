package com.example.parkir.views.core.parkings.data.repository

import android.util.Log
import com.example.parkir.views.core.parkings.data.entity.Parking
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import com.example.parkir.views.core.parkings.data.service.ParkingService
import retrofit2.Response

class ParkingRepository(
    private val parkingService: ParkingService
) {
    suspend fun getAllParkings(): Response<List<Parking>> {
        Log.i("myprint", "HLL")
        return parkingService.getAllParkings()
    }

    suspend fun getParkingById(parkingId: Int): Response<Parking> {
        return parkingService.getParkingById(parkingId = parkingId)
    }

    suspend fun getParkingSpotById(parkingSpotId: Int): Response<ParkingSpot> {
        return parkingService.getParkingSpotById(parkingSpotId = parkingSpotId)
    }
}