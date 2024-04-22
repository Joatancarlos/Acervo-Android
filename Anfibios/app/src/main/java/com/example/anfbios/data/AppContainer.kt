package com.example.anfbios.data

import com.example.anfbios.network.AmphibiansApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val amphibiansInfoRepository: AmphibiansInfoRepository
}


class DefaultAppContainer : AppContainer {
    private val base_url = "https://android-kotlin-fun-mars-server.appspot.com/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(base_url)
        .build()
    private val retrofitService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    override val amphibiansInfoRepository: AmphibiansInfoRepository by lazy {
        NetworkAmphibiansInfoRepository(retrofitService)
    }
}