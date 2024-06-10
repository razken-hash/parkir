package com.example.parkir.views.core.parkings.data.service

import com.example.parkir.ParkirConsts
import com.example.parkir.views.core.parkings.data.entity.Floor
import com.example.parkir.views.core.parkings.data.entity.Parking
import com.example.parkir.views.core.parkings.data.entity.ParkingSpot
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ParkingSpotService {

    @GET("/parkings/floors/parkingspots")
    suspend fun getAllParkingSpots(
        @Path("parkingId") parkingId: Int, @Path("floorId") floorId: Int
    ): Response<List<ParkingSpot>>

    @GET("/api/v1/parkings/floors/parkingspots/{parkingSpotId}")
    suspend fun getParkingSpotById(@Path("parkingSpotId") parkingSpotId: Int): Response<ParkingSpot>


    companion object {
        private var parkingSpotService: ParkingSpotService? = null
        fun getInstance(): ParkingSpotService {
            if (parkingSpotService == null) {
                parkingSpotService =
                    Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL).addConverterFactory(
                        GsonConverterFactory.create()
                    ).build().create(ParkingSpotService::class.java)
            }
            return parkingSpotService!!
        }
    }


}