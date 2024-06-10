package com.example.parkir.views.core.parkings.data.service

import com.example.parkir.ParkirConsts
import com.example.parkir.views.core.parkings.data.entity.Parking
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ParkingService {
    @GET("/api/v1/parkings")
    suspend fun getAllParkings(): Response<List<Parking>>

    @GET("/api/v1/parkings/{parkingId}")
    suspend fun getParkingById(@Path("parkingId") parkingId: Int): Response<Parking>

    companion object {
        private var parkingService: ParkingService? = null
        fun getInstance(): ParkingService {
            if (parkingService == null) {
                parkingService =
                    Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL).addConverterFactory(
                        GsonConverterFactory.create()
                    ).build().create(ParkingService::class.java)
            }
            return parkingService!!
        }
    }
}