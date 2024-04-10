package com.example.marsphotos.network

import retrofit2.http.GET

interface MarsApiServiceInteface {
    @GET("photos")
    suspend fun getPhotos(): String
}