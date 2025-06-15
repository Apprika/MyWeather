package co.za.kudzi.myweather.di

import co.za.kudzi.myweather.BuildConfig
import co.za.kudzi.myweather.network.NetworkConstants.QUERY_PARAM_APP_ID
import co.za.kudzi.myweather.network.WeatherService
import co.za.kudzi.myweather.repository.ForecastRepository
import co.za.kudzi.myweather.repository.ForecastRepositoryImpl
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private fun addApiKeyToRequest(chain: Interceptor.Chain) = chain.proceed(
        chain.request()
            .newBuilder()
            .url(chain.request().url.newBuilder().addQueryParameter(QUERY_PARAM_APP_ID, BuildConfig.API_KEY).build())
            .build()
    )

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): WeatherService = retrofit.create(WeatherService::class.java)

    @Provides
    @Singleton
    fun providesForecastRepository(service: WeatherService): ForecastRepository = ForecastRepositoryImpl(service)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(
                OkHttpClient()
                    .newBuilder()
                    .addNetworkInterceptor(FlipperOkhttpInterceptor(NetworkFlipperPlugin()))
                    .addInterceptor(HttpLoggingInterceptor())
                    .addInterceptor { addApiKeyToRequest(it) }
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}