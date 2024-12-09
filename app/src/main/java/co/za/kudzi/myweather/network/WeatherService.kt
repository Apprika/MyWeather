package co.za.kudzi.myweather.network

import co.za.kudzi.myweather.model.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {
    @GET("/data/2.5/forecast?lat={lat}&lon={long}")
    fun fetchForecast(
        @Path("lat") lat: Double,
        @Path("lon") long: Double,
    ): Response<Forecast>

}