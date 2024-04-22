package com.example.anfbios.data

import com.example.anfbios.models.AnfibioInfo
import com.example.anfbios.network.AmphibiansApiService

interface AmphibiansInfoRepository {
    suspend fun getAmphibiansInfo(): List<AnfibioInfo>
}

class NetworkAmphibiansInfoRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansInfoRepository {
    override suspend fun getAmphibiansInfo(): List<AnfibioInfo> = amphibiansApiService.getAmphibians()
}