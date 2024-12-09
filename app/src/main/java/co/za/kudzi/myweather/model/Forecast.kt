package co.za.kudzi.myweather.model

data class Forecast(
    val cnt: Long,
    val city: City,
    val cod: String,
    val message: Long,
    val forecasts: List<Forecasts>,
)