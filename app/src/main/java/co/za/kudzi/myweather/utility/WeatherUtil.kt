package co.za.kudzi.myweather.utility

import co.za.kudzi.myweather.R

object WeatherUtil {

    enum class WeatherCondition(val drawable: Int) {
        RAINY(R.drawable.group_rainy),
        SUNNY(R.drawable.group_sunny),
        CLOUDY(R.drawable.group_cloudy),
        FOREST(R.drawable.group_forest)
    }

    fun backgroundFromCode(code: Int): Int {
        return when (code) {
            800 -> WeatherCondition.SUNNY.drawable
            in 500..531 -> WeatherCondition.RAINY.drawable
            in 200..232 -> WeatherCondition.RAINY.drawable
            in 300..321 -> WeatherCondition.RAINY.drawable
            in 600..621 -> WeatherCondition.RAINY.drawable
            in 801..804 -> WeatherCondition.CLOUDY.drawable
            else -> WeatherCondition.SUNNY.drawable
        }
    }



}