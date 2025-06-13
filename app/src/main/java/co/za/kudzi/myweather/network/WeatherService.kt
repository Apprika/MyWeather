package co.za.kudzi.myweather.network

import co.za.kudzi.myweather.model.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
    @GET("/data/2.5/forecast/daily?")
    suspend fun fetchForecast(
        @Query("lat") lat: Double,
        @Query("lon") long: Double,
    ): Response<Forecast>

}