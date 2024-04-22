package com.example.anfbios

import android.app.Application
import com.example.anfbios.data.AppContainer
import com.example.anfbios.data.DefaultAppContainer

class AmphibiansInfoApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}