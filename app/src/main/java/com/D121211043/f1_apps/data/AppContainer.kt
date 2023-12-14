package com.D121211043.f1_apps.data

import com.D121211043.f1_apps.data.repository.CircuitRepository
import com.D121211043.f1_apps.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val circuitRepository: CircuitRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://api.openf1.org/v1/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val circuitRepository: CircuitRepository
        get() = CircuitRepository(retrofitService)

}