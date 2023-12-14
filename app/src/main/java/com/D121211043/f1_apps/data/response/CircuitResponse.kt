package com.D121211043.f1_apps.data.response
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CircuitResponse (
    @SerialName("meeting_name")
    val meetingName: String?,
    @SerialName("meeting_official_name")
    val meetingOfficialName: String?,
    @SerialName("location")
    val location: String?,
    @SerialName("country_key")
    val countryKey: Int?,
    @SerialName("country_code")
    val countryCode: String?,
    @SerialName("country_name")
    val countryName: String?,
    @SerialName("circuit_key")
    val circuitKey: Int?,
    @SerialName("circuit_short_name")
    val circuitShortName: String?,
    @SerialName("date_start")
    val dateStart: String?,
    @SerialName("gmt_offset")
    val gmtOffset: String?,
    @SerialName("meeting_key")
    val meetingKey: Int?,
    @SerialName("year")
    val year: Int?
)

