package co.za.kudzi.myweather.repository

import co.za.kudzi.myweather.network.WeatherService
import co.za.kudzi.myweather.model.Forecast
import co.za.kudzi.myweather.network.NetworkConstants.DAYS_TO_RETRIEVE
import retrofit2.Response
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(private val apiService: WeatherService) : ForecastRepository {
    override suspend fun getFiveDayForecast(latitude: Double, longitude: Double): Response<Forecast> =
        apiService.getForecast(lat = latitude, long = longitude, count = DAYS_TO_RETRIEVE)
}