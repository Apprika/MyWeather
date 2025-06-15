package co.za.kudzi.myweather.model

data class ForecastDisplay(
    val city: String,
    val foreCasts: List<ForecastsDisplay>
)

data class ForecastsDisplay(
    val dt:Long,
    val dayOfTheWeek: String,
    val degrees: Double,
    val iconDrawable: String,
    val background: Int
)