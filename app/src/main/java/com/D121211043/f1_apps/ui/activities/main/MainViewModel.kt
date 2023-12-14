package com.D121211043.f1_apps.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211043.f1_apps.data.repository.CircuitRepository
import com.D121211043.f1_apps.MyApplication
import com.D121211043.f1_apps.data.models.CircuitItem
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val circuit: List<CircuitItem>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val circuitRepository: CircuitRepository) : ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getCircuit() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = circuitRepository.getCircuit()
            Log.d("MainViewModel", "getNews: ${result.data?.size}")
            mainUiState = MainUiState.Success(result.data.orEmpty())
        } catch (e: IOException) {
            Log.d("MainViewMode", "getNews error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getCircuit()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val circuitRepository = application.container.circuitRepository
                MainViewModel(circuitRepository)
            }
        }
    }
}
