package co.za.kudzi.myweather.di

import co.za.kudzi.myweather.network.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val API_KEY = "bd6726e1be1b7902b03d4eb347360c23"

    private const val APP_ID_QUERY_PARAM = "appid"

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): WeatherService = retrofit.create(WeatherService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org")
        .client(
            OkHttpClient()
                .newBuilder()
                .addInterceptor { chain ->
                    apiKeyAsQuery(chain)
                }
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun apiKeyAsQuery(chain: Interceptor.Chain) = chain.proceed(
        chain.request()
            .newBuilder()
            .url(chain.request().url().newBuilder().addQueryParameter(APP_ID_QUERY_PARAM, API_KEY).build())
            .build()
    )
}