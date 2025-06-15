package co.za.kudzi.myweather.repository

import co.za.kudzi.myweather.model.Forecast
import retrofit2.Response

interface ForecastRepository {
    suspend fun getFiveDayForecast(latitude: Double, longitude: Double) : Response<Forecast>
}