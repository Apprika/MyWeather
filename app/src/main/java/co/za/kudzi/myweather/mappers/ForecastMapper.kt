package co.za.kudzi.myweather.mappers

import co.za.kudzi.myweather.model.Forecasts
import co.za.kudzi.myweather.model.ForecastsDisplay
import co.za.kudzi.myweather.utility.WeatherUtil.backgroundFromCode
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.floor

fun Forecasts.toDisplay(): ForecastsDisplay {

    val weatherIcon = "icon_" + this.weather[0].icon

    val cardBackground = backgroundFromCode(this.weather[0].id.toInt())

    val dayOfWeek = Instant.fromEpochMilliseconds(this.dt * 1000).toLocalDateTime(TimeZone.UTC)
        .dayOfWeek
        .toDisplay()

    return ForecastsDisplay(this.dt, dayOfWeek, "${floor(this.temp.day / 10)}°", weatherIcon, cardBackground)
}

fun DayOfWeek.toDisplay(): String {
    return when (this) {
        DayOfWeek.MONDAY -> "Monday"
        DayOfWeek.TUESDAY -> "Tuesday"
        DayOfWeek.WEDNESDAY -> "Wednesday"
        DayOfWeek.THURSDAY -> "Thursday"
        DayOfWeek.FRIDAY -> "Friday"
        DayOfWeek.SATURDAY -> "Saturday"
        DayOfWeek.SUNDAY -> "Sunday"
    }
}



