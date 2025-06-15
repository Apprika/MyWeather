package co.za.kudzi.myweather.mappers

import co.za.kudzi.myweather.model.Forecasts
import co.za.kudzi.myweather.model.ForecastsDisplay
import co.za.kudzi.myweather.util.WeatherUtil.backgroundFromCode
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.math.round

fun Forecasts.toDisplay(): ForecastsDisplay {
    val weatherIcon = "icon_" + this.weather[0].icon

    val cardBackground = backgroundFromCode(this.weather[0].id.toInt())

    val dayOfWeek = Instant.fromEpochMilliseconds(this.dt).toLocalDateTime(TimeZone.currentSystemDefault())
        .dayOfWeek
        .name

    return ForecastsDisplay(this.dt, dayOfWeek, round(this.temp.day / 10), weatherIcon, cardBackground)
}



