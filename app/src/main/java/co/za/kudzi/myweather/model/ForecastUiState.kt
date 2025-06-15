package co.za.kudzi.myweather.model

sealed class ForecastUiState {
    object Empty : ForecastUiState()
    data object Loading : ForecastUiState()
    data class Success(val data: ForecastDisplay) : ForecastUiState()
    data class Error(val message: String) : ForecastUiState()
}