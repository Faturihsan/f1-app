package com.D121211043.f1_apps.data.repository

import com.D121211043.f1_apps.data.response.CircuitResponse
import com.D121211043.f1_apps.data.source.remote.ApiService

class CircuitRepository (private val apiService: ApiService) {
    suspend fun getCircuit(): CircuitResponse {
        return apiService.getCircuit()
    }
}