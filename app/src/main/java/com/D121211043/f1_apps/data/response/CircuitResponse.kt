package com.D121211043.f1_apps.data.response
import com.D121211043.f1_apps.data.models.CircuitItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CircuitResponse (
    @SerialName("data")
    val data: List<CircuitItem>?,
)

