package com.example.parkir.views.core.parkings.data.service

import com.example.parkir.ParkirConsts
import com.example.parkir.views.core.parkings.data.entity.Floor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface FloorService {
        @GET("/parkings/{parkingId}/floors")
        suspend fun getAllParkingFloors(@Path("parkingId") parkingId: Int): Response<List<Floor>>

        companion object {
            private var floorService: FloorService? = null
            fun getInstance(): FloorService {
                if (floorService == null) {
                    floorService =
                        Retrofit.Builder().baseUrl(ParkirConsts.BASE_URL).addConverterFactory(
                            GsonConverterFactory.create()
                        ).build().create(FloorService::class.java)
                }
                return floorService!!
            }
        }
    }