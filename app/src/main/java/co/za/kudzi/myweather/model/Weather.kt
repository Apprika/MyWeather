package co.za.kudzi.myweather.model

data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String,
)
