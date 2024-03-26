package com.example.dessertclicker.ui.theme

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()


    fun sumRevenuePrice(currentDessertPrice: Int) {
        val updatePrice = _uiState.value.revenue.plus(currentDessertPrice)
        _uiState.update { currentDessertState ->
            currentDessertState.copy(
                revenue = updatePrice
            )
        }
    }

    fun sumDessertSold() {
        val updatePrice = _uiState.value.dessertsSold.inc()
        _uiState.update { currentDessertState ->
            currentDessertState.copy(
                dessertsSold = updatePrice
            )
        }
    }

    fun updateCurrentDessertAndPrice(imageID: Int, priceId: Int) {
        _uiState.update { currentDessertState ->
            currentDessertState.copy(
                currentDessertImageId = imageID,
                currentDessertPrice = priceId,
            )
        }
    }

}