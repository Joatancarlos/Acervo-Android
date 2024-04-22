package com.example.anfbios.network

import com.example.anfbios.models.AnfibioInfo
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("amphibians")
    suspend fun getAmphibians(): List<AnfibioInfo>
}