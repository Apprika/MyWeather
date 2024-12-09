package co.za.kudzi.myweather

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.za.kudzi.myweather.network.NetworkResult
import co.za.kudzi.myweather.ui.theme.MyWeatherTheme
import co.za.kudzi.myweather.viewmodel.ForecastViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ForecastViewModel by viewModels()

    private val TAG = "WeatherApp"

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            fetchForeCast()
        } else {
            showPermissionDenied()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkLocationPermission()
        enableEdgeToEdge()
        setContent {
            MyWeatherTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun checkLocationPermission() {
        val locationPerm = "android.Manifest.permission.ACCESS_COARSE_LOCATION"
        when {
            PermissionUtil.checkPermission(this, locationPerm) -> fetchForeCast()
            PermissionUtil.showRationale(this, locationPerm) -> PermissionUtil.showPermissionRationale(this, locationPerm)
            else -> requestPermissionLauncher.launch(locationPerm)
        }
    }

    private fun showPermissionDenied() {
        Log.e(TAG, "Location permission was denied")
    }

    private fun fetchForeCast() {
        Log.i(TAG, "Fetching forecast")
        viewModel.fetchForeCast().observe(this) { resultState ->
            when (resultState) {
                is NetworkResult.Success -> {
                    Log.i(TAG, "Forecast success")
                    // Handle successful API calls
                }

                is NetworkResult.Loading -> {
                    Log.i(TAG, "Forecast loading")
                    // Handle UI when API calls is loading
                }

                is NetworkResult.Error -> {
                    Log.i(TAG, "Forecast error")
                    // Handle error API calls
                    // Example: Show error message to the user
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyWeatherTheme {
        Greeting("Android")
    }
}