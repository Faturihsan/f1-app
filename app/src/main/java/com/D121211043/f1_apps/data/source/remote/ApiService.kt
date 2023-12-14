package com.D121211043.f1_apps.data.source.remote

import com.D121211043.f1_apps.data.response.CircuitResponse
import retrofit2.http.GET

interface ApiService {
    @GET("meetings")
    suspend fun getCircuit(): CircuitResponse
}