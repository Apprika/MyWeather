package co.za.kudzi.myweather.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
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
class ForecastViewModel @Inject constructor(private val repository: ForecastRepository, app: Application) :
    AndroidViewModel(app) {

    private val _uiState = MutableStateFlow<ForecastUiState>(ForecastUiState.Empty)
    val uiState: StateFlow<ForecastUiState> = _uiState

    init {
        fetchForeCast()
    }

    private fun fetchForeCast() {
        _uiState.value = ForecastUiState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getForecast(latitude = -26.065753, longitude = 27.959141)
                _uiState.value = ForecastUiState.Success(response.body()!!)
            } catch (ex: Exception) {
                if (ex is HttpException && ex.code() == 429) {
                    onQueryLimitReached()
                } else {
                    onErrorOccurred(ex.message)
                }
            }
        }
    }

    private fun onQueryLimitReached() {
        _uiState.value = ForecastUiState.Error("We have exceeded query limit")

    }

    private fun onErrorOccurred(message: String?) {
        _uiState.value = ForecastUiState.Error("An error has occurred: \n $message")
    }

}
