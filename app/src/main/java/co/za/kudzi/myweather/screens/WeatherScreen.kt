package co.za.kudzi.myweather.screens

import android.Manifest
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import co.za.kudzi.myweather.model.ForecastUiState
import co.za.kudzi.myweather.screens.MyObject.TAG
import co.za.kudzi.myweather.viewmodel.ForecastViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.android.gms.location.LocationServices


object MyObject {
    const val TAG = "HomeScreen"
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
@RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
fun HomeScreen(forecastViewModel: ForecastViewModel = viewModel()) {

    val locationPermissionState = rememberPermissionState(
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    if (locationPermissionState.status.isGranted) {
        FetchWeather(forecastViewModel)
    } else {
        if (locationPermissionState.status.shouldShowRationale) {
            PermissionDenied(onDismiss = { }, onTryAgain = {
                locationPermissionState.launchPermissionRequest()
            }, onExit = {

            })
        } else {
            PermissionDenied(onDismiss = { }, onTryAgain = {
                locationPermissionState.launchPermissionRequest()
            }, onExit = {

            })
        }
    }
}

@Composable
@RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
private fun FetchWeather(forecastViewModel: ForecastViewModel) {

    val context = LocalContext.current

    val collectAsState = forecastViewModel.uiState.collectAsState()

    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        location?.let {
            forecastViewModel.setLocation(location)
        }
    }.addOnFailureListener { it ->
        Log.i(TAG, "Failed to get location: ${it.message}")
    }.addOnCanceledListener {
        Log.i(TAG, "Cancelled while to get location")
    }

    when (val state = collectAsState.value) {
        ForecastUiState.Empty -> EmptyWeather()
        ForecastUiState.Loading -> LoadingScreen()
        is ForecastUiState.Error -> ErrorDialog(state.message)
        is ForecastUiState.Success -> WeatherLoaded(state.data)
    }

}

@Composable
fun ErrorDialog(errorMessage: String) {
}
