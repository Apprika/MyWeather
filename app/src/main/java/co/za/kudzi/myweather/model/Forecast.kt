package co.za.kudzi.myweather.model

data class Forecast(
    val cnt: Long,
    val city: City,
    val cod: String,
    val list: List<Forecasts>,
    val message: Double,
)