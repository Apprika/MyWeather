package co.za.kudzi.myweather.view;

import android.util.Log
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import co.za.kudzi.myweather.model.Forecast
import co.za.kudzi.myweather.model.ForecastUiState
import co.za.kudzi.myweather.viewmodel.ForecastViewModel;

@Composable
fun WeatherScreen(forecastViewModel: ForecastViewModel = viewModel()) {

    Log.i("WeatherScreen", "Fetching forecast")

    val weather = forecastViewModel.uiState.collectAsState()

    when (val state = weather.value) {
        ForecastUiState.Loading -> LoadingScreen()
        is ForecastUiState.Success -> WeatherLoaded(state.data)
        is ForecastUiState.Error -> ErrorDialog(state.message)
        ForecastUiState.Empty -> EmptyWeather()
    }
}

@Composable
fun EmptyWeather() {
    Log.i("WeatherApp", "Empty weather")
}

@Composable
fun WeatherLoaded(forecast: Forecast) {
    Log.i("WeatherApp", forecast.forecasts.toString())
}

@Composable
fun ErrorDialog(errors: String) {
    Log.i("WeatherApp", errors)
}
