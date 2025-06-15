package co.za.kudzi.myweather.network

import co.za.kudzi.myweather.model.Forecast
import co.za.kudzi.myweather.network.NetworkConstants.ENDPOINT_FORECAST
import co.za.kudzi.myweather.network.NetworkConstants.QUERY_PARAM_COUNT
import co.za.kudzi.myweather.network.NetworkConstants.QUERY_PARAM_LATITUDE
import co.za.kudzi.myweather.network.NetworkConstants.QUERY_PARAM_LONGITUDE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(ENDPOINT_FORECAST)
    suspend fun getForecast(
        @Query(QUERY_PARAM_COUNT) count: Int,
        @Query(QUERY_PARAM_LATITUDE) lat: Double,
        @Query(QUERY_PARAM_LONGITUDE) long: Double,
    ): Response<Forecast>

}