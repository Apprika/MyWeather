package co.za.kudzi.myweather.repository

import co.za.kudzi.myweather.network.WeatherService
import co.za.kudzi.myweather.model.Forecast
import retrofit2.Response
import javax.inject.Inject

class ForecastRepository @Inject constructor(private val apiService: WeatherService) {
    suspend fun getForecast(
        latitude: Double,
        longitude: Double,
    ): Response<Forecast> {
        return apiService.fetchForecast(latitude, longitude)
    }
}