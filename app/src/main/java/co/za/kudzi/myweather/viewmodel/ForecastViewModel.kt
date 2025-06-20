package co.za.kudzi.myweather.viewmodel

import android.location.Location
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.za.kudzi.myweather.mappers.toDisplay
import co.za.kudzi.myweather.model.Forecast
import co.za.kudzi.myweather.model.ForecastDisplay
import co.za.kudzi.myweather.model.ForecastUiState
import co.za.kudzi.myweather.repository.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val repository: ForecastRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<ForecastUiState>(ForecastUiState.Empty)

    val uiState: StateFlow<ForecastUiState> = _uiState

    private val shouldFetchData = mutableStateOf(true)

    private val STATUS_CODE_TOO_MANY_ATTEMPTS = 429

    fun fetchForeCast(latitude: Double, longitude: Double) {

        _uiState.value = ForecastUiState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getFiveDayForecast(latitude, longitude).body()!!
                if (response.list.isNotEmpty()) {
                    handleSuccess(response)
                } else {
                    handleNoForecastsFound()
                }
            } catch (ex: Exception) {
                handleException(ex)
            }
        }
    }

    private fun handleNoForecastsFound() {
        _uiState.value = ForecastUiState.Empty
    }

    private fun handleSuccess(response: Forecast) {
        _uiState.value = ForecastUiState.Success(
            ForecastDisplay(
                response.city.name,
                response.list.map { it.toDisplay() }.toList()
            )
        )
    }

    private fun handleException(ex: Exception) {
        if (ex is HttpException && ex.code() == STATUS_CODE_TOO_MANY_ATTEMPTS) {
            _uiState.value = ForecastUiState.Error("Exceeded API query limit")
        } else {
            _uiState.value = ForecastUiState.Error("An error has occurred: \n $ex")
        }
    }

    fun setLocation(location: Location?) {
        if (location != null) {
            if (shouldFetchData.value) {
                shouldFetchData.value = false
                fetchForeCast(location.latitude, location.longitude)
            }
        } else {
            _uiState.value = ForecastUiState.Error("Failed to retrieve location from device. Could be an emulator error")
        }

    }

}
