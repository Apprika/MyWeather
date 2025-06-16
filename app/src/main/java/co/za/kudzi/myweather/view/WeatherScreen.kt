package co.za.kudzi.myweather.view

import android.Manifest
import android.util.Log
import androidx.activity.compose.LocalActivity
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import co.za.kudzi.myweather.model.ForecastUiState
import co.za.kudzi.myweather.viewmodel.ForecastViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import com.google.android.gms.location.LocationServices

@Composable
@OptIn(ExperimentalPermissionsApi::class)
@RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
fun HomeScreen(forecastViewModel: ForecastViewModel = viewModel()) {

    val activity = LocalActivity.current

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
                activity?.finish()
            })
        } else {
            PermissionDenied(onDismiss = { }, onTryAgain = {
                locationPermissionState.launchPermissionRequest()
            }, onExit = {
                activity?.finish()
            })
        }
    }
}

@Composable
@RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
private fun FetchWeather(forecastViewModel: ForecastViewModel) {

    val context = LocalContext.current

    val activity = LocalActivity.current

    val collectAsState = forecastViewModel.uiState.collectAsState()

    val fusedLocationClient = remember {
        LocationServices.getFusedLocationProviderClient(context)
    }

    fusedLocationClient.lastLocation.addOnSuccessListener {
        forecastViewModel.setLocation(it)
    }.addOnFailureListener { it ->
        Log.i("HomeScreen", "Failed to get location: ${it.message}")
    }.addOnCanceledListener {
        Log.i("HomeScreen", "Cancelled while getting location")
    }

    when (val state = collectAsState.value) {
        ForecastUiState.Empty -> EmptyWeather()
        ForecastUiState.Loading -> LoadingScreen()
        is ForecastUiState.Success -> WeatherLoaded(state.data)
        is ForecastUiState.Error -> GenericError(
            error = state.message,
            onDismiss = { activity?.finish() },
            onExit = { activity?.finish() })

    }
}
