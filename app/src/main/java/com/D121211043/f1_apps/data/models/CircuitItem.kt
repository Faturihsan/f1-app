package com.D121211043.f1_apps.data.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class CircuitItem(
    @SerialName("data")
    val circuit_key: Int,
    @SerialName("circuit_short_name")
    val circuit_short_name: String,
    @SerialName("country_code")
    val country_code: String,
    @SerialName("country_key")
    val country_key: Int,
    @SerialName("country_name")
    val country_name: String,
    @SerialName("date_start")
    val date_start: String,
    @SerialName("gmt_offset")
    val gmt_offset: String,
    @SerialName("location")
    val location: String,
    @SerialName("meeting_key")
    val meeting_key: Int,
    @SerialName("meeting_name")
    val meeting_name: String,
    @SerialName("meeting_official_name")
    val meeting_official_name: String,
    @SerialName("year")
    val year: Int

) : Parcelable