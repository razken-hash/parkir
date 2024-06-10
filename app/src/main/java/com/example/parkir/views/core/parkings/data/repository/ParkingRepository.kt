package com.example.parkir.views.core.parkings.data.repository

import com.example.parkir.views.core.parkings.data.entity.Parking
import com.example.parkir.views.core.parkings.data.service.ParkingService
import retrofit2.Response

class ParkingRepository(
    private val parkingService: ParkingService
) {
    suspend fun getAllParkings(): Response<List<Parking>> {
        return parkingService.getAllParkings()
    }

    suspend fun getParkingById(parkingId: Int): Response<Parking> {
        return parkingService.getParkingById(parkingId = parkingId)
    }
}