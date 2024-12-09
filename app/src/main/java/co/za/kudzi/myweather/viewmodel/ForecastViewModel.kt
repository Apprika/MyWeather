package co.za.kudzi.myweather.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import co.za.kudzi.myweather.network.NetworkResult
import co.za.kudzi.myweather.repository.ForecastRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val repository: ForecastRepository, app: Application) :
    AndroidViewModel(app) {
    fun fetchForeCast() = liveData(Dispatchers.IO) {
        emit(NetworkResult.Loading)
        viewModelScope.launch {
            try {
                emit(NetworkResult.Success(repository.getForecast(1.0, 1.0)))
            } catch (e: Exception) {
                emit(NetworkResult.Error(code = 100, message = e.message ?: "Error Occurred!"))
            }
        }
    }
}
