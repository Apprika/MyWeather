package co.za.kudzi.myweather.model

import com.google.gson.annotations.SerializedName

data class Forecasts(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp:Temp,
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    val visibility: Long,
    val pop: Double,
    val sys: Sys,
    @SerializedName("dt_txt")
    val dtTxt: String,
    val rain: Rain?,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike,
    val pressure: Long,
    val humidity: Long,
    val speed: Double,
    val deg: Long,
    val gust: Double,
    val clouds: Long,
)
