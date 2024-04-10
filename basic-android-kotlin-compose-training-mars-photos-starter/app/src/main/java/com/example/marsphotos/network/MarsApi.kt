package com.example.marsphotos.network

object MarsApi {
    val retrofitService : MarsApiServiceInteface by lazy {
        retrofit.create(MarsApiServiceInteface::class.java)
    }
}