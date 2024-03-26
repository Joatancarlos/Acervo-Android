package com.example.dessertclicker.ui.theme

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource

data class DessertUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertImageId: Int = Datasource.dessertList[currentDessertIndex].imageId,
    @DrawableRes val currentDessertPrice: Int = Datasource.dessertList[currentDessertIndex].price
)
